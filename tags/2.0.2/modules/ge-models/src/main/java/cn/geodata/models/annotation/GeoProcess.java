package cn.geodata.models.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface GeoProcess {
	String title();
	String description() default "";
	String[] keywords() default "";
	String[] metadata() default "";
}
