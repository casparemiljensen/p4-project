package com.eel.AST;

import com.eel.AST.nodes.AbstractNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;

public class ASTPrinter {
    public void print(AbstractNode node) {
        String nodeName = node.getClass().getSimpleName();
        System.out.print("[" + nodeName);
        Field[] fields = node.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value;
            try {
                value = field.get(node);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error accessing field " + field.getName() + " in node " + nodeName, e);
            }
            // Omitting all that is string, tokens to avoid concatenation with class/field name.
            if (value != null && value instanceof String == false && value instanceof TerminalNode == false) {
                if (value instanceof AbstractNode) {
                    System.out.print("[");
                    print((AbstractNode) value);
                    System.out.print("]");
                } else if (value instanceof List) {
                    List<?> list = (List<?>) value;
                    // Removing all null elements.. i.e. StatementNode only has 1 non-null field
                    for (Object element : list.stream().filter(Objects::nonNull).toList()) {
                        if (element instanceof AbstractNode) {
                            System.out.print("[");
                            print((AbstractNode) element);
                            System.out.print("]");
                        } else {
                            System.out.print("[");
                            System.out.print(element);
                            System.out.print("]");
                        }
                    }
                }
                    else {
                    System.out.print(value);
                }
            }
        }
        System.out.print("]");
    }
}
