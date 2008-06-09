package cn.geodata.models;

public @interface GeoProcessing {
	String title();
	String description() default "";
	String[] keywords() default "";
	String[] metadata() default "";
}
