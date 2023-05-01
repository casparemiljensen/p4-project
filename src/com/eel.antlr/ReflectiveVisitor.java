package com.eel.antlr;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

abstract public class ReflectiveVisitor {

    public static boolean debug = false;
    private static Class objectClass = (new Object()).getClass();

    abstract public void defaultVisit(Object o);

    private void debugMsg(String s) {
        if (debug) System.err.println(s);
    }


    /** Method to kick things off. Override to do other stuff if
     * you wish
     */

    public void  perform(AbstractNode n) {
        n.accept(this);
    }

    /** Better version of perform */
    public final ReflectiveVisitor performVisit(AbstractNode n) {
        perform(n);
        return this;
    }

    /** Method to accomplish the double-dispatch. */
    public final void dispatch(Object o) {
        Method m = getBestMethodFor(o);
        try {
            m.invoke(this, new Object[] { o });
        } catch (IllegalAccessException e) {
            e.printStackTrace(System.err);
            throw new Error("Method " + m + " aborting, bad access: "+e);
        } catch (InvocationTargetException e) {
            if (e.getCause() != null) throw new Error(e.getCause());
            else {
                // This exception is thrown if the reflectively called method
                // throws anything for any reason
                e.printStackTrace(System.err);
                throw new Error("Method " + m + " aborting: "+e+" cause: " + e.getCause());
            }
        }
    }

    /**
     * Find the closest visit method that handles the supplied object.
     * First we try the superclasses.  If none is found, then we try
     * All interfaces and superinterfaces of all superclasses.
     */

    protected Method getBestMethodFor(Object o) {
        Class nodeClass = o.getClass();
        Method ans = null;

        // Try the superclasses

        for (Class c = nodeClass;
             c != objectClass && ans == null;
             c = c.getSuperclass()) {
            debugMsg("Looking for class match for " + c.getName());
            try {

                // Unlike GoF, all methods are "visit" and are
                // distinguished by their param type

                ans = getClass().getMethod("visit", new Class[] {c});

            } catch (NoSuchMethodException e) { }
        }

        // For each superclass of this class,
        // try the interfaces.  The code below will find the last
        // interface listed for
        // which "this" visitor can handle the type

        Class iClass = nodeClass;
        while (ans == null && iClass != objectClass) {
            debugMsg("Looking for interface  match in " + iClass.getName());
            Class[] interfaces = iClass.getInterfaces();
            for (int i = 0; i < interfaces.length; i++) {
                debugMsg("   trying interface " + interfaces[i]);
                try {
                    ans = getClass().getMethod("visit", new Class[] {interfaces[i]});
                } catch (NoSuchMethodException e) { }
                Class[] superInterfaces = interfaces[i].getInterfaces();
                for (int j=0; j < superInterfaces.length && ans == null; ++j) {
                    debugMsg("   trying super interface " + superInterfaces[j]);
                    try {
                        ans = getClass().getMethod("visit", new Class[] {superInterfaces[j]});
                    } catch (NoSuchMethodException e) { }
                }

            }
            iClass = iClass.getSuperclass();
        }

        if (ans == null) {
            try {
                debugMsg("Giving up");
                ans = getClass().getMethod("defaultVisit",
                        new Class[] {(new Object()).getClass()});
            } catch (NoSuchMethodException e) {
                // Just stop, because throwing an exception will cascade upwards
                debugMsg("Cannot happen -- could not find defaultVisit(Object)");
                e.printStackTrace(System.err);
                System.exit(-1);
            }
        }
        debugMsg("Best method for " + o + " is " + ans);
        return ans;
    }

}