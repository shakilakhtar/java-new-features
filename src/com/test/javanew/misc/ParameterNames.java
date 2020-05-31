package com.test.javanew.misc;

import java.lang.reflect.*;

public class ParameterNames {
    public static void main(String[] args) throws Exception {
        Method method = ParameterNames.class.getMethod("main" ,String[].class);
        for (final Parameter parameter:method.getParameters()){
            System.out.println("Parameter: "+parameter.getName());
        }


    }
}
