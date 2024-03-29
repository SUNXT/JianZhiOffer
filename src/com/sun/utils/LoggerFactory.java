package com.sun.utils;

public class LoggerFactory {

    public static Logger getLogger(Object o){
        Class clazz = o.getClass();
        return new Logger(clazz.getName());
    }

    public static Logger getLogger(Class c){
        return new Logger(c.getName());
    }
}
