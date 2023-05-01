package com.eel.antlr;

/** Reflective visitor pattern -- a node must accept a visitor */
public interface ReflectiveVisitable {
   public void accept(ReflectiveVisitor rv);
}
