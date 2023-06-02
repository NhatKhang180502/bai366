package NguyenNhatKhang.bai36.validator.annotation;
import NguyenNhatKhang.bai36.validator.ValidUsernameValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import  static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD,TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = ValidUsernameValidator.class)
@Documented

public @interface ValidUsername {
    String message() default "Invalid User ID";
    Class<?> [] groups() default {};
    Class <? extends Payload> [] Payload () default {};
}