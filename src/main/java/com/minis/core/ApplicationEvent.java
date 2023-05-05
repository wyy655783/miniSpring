package com.minis.core;

import java.util.EventObject;

/**
 * @program: miniSpring
 * @description:
 * @author: wyh
 * @create: 2023-03-15 11:42
 **/
public class ApplicationEvent extends EventObject {
    private static final long serialVersionUID = 1L;
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public ApplicationEvent(Object source) {
        super(source);
    }
}
