package cn.geodata.models;

public @interface GeoOutput {
	String title();
	String description() default "";
	String[] keywords() default "";
	String[] metadata() default "";
}
