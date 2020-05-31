package com.test.javanew.annotations;

import java.lang.annotation.*;
import java.util.*;

public class AnnotationPlaces {
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE_USE, ElementType.TYPE_PARAMETER})
    @interface NonEmpty {

    }

    public static class Holder<@NonEmpty T> extends @NonEmpty Object {
        public void method() throws @NonEmpty Exception {

        }
    }

    public static void main(String[] args) {
        final Holder<String> holder = new @NonEmpty Holder<String>();
        @NonEmpty
        Collection<@NonEmpty String> strings = new ArrayList<>();
        strings.add("string1");
        strings.add("string2");
        for (String s : strings) {
            System.out.println(s);
        }
    }
}
