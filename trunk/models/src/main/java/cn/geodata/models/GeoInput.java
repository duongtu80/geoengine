package cn.geodata.models;

public @interface GeoInput {
	String title();
	String description() default "";
	String[] keywords() default "";
	String[] metadata() default "";
}
