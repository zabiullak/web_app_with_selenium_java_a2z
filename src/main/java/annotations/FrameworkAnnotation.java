package annotations;

import enums.CategoryType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
public @interface FrameworkAnnotation {

    String[] author();

    CategoryType[] category();
}
