package com.heiha.sinfonia.lab.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <br>
 * <b>Project:</b> lab<br>
 * <b>Date:</b> 2017/10/12 11:50<br>
 * <b>Author:</b> Topashman<br>
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
public @interface Default {
    @AliasFor("set")
    String value() default "default";

    @AliasFor("value")
    String set() default "set";
}
