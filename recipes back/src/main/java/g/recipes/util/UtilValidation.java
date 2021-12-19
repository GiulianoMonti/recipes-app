package g.recipes.util;//
//package g.react.util;
//
//import org.springframework.stereotype.Component;
//
//import javax.validation.*;
//import java.util.Set;
//
//@Component
//public class UtilValidation {
//
//        public void validationApp (Object object){
//
//        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
//        Validator validator = factory.getValidator();
//
//        Set<ConstraintViolation<Object>> violations = validator.validate(object);
//
//        if (!violations.isEmpty()) {
//           throw new ConstraintViolationException(violations);
//        }
//    }
//}
