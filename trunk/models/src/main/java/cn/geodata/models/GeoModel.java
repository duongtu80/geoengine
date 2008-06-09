package cn.geodata.models;

public @interface GeoModel {
	String title();
	String description() default "";
	String[] keywords() default "";
	String[] metadata() default "";
}

