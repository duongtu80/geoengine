package cn.geodata.models;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface GeoProcessing {
	String title();
	String description() default "";
	String[] keywords() default "";
	String[] metadata() default "";
}
