package me.kirenai.re.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.kirenai.re.validation.dto.ErrorResponse;
import me.kirenai.re.validation.exception.ValidatorException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomValidator implements Validator {

    private final org.springframework.validation.Validator validator;

    @Override
    public void validate(Object object) {
        Errors bindingResult = new BeanPropertyBindingResult(object, object.getClass().getName());
        validator.validate(object, bindingResult);
        if (bindingResult.hasErrors()) {
            log.error("Binding result has: {} errors", bindingResult.getFieldErrors().size());
            List<ErrorResponse> errorResponses = bindingResult.getFieldErrors()
                    .stream()
                    .map(ErrorResponse::new)
                    .toList();
            throw new ValidatorException(errorResponses);
        }
    }

}
