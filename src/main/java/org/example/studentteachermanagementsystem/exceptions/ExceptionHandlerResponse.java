package org.example.studentteachermanagementsystem.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import java.util.HashMap;
import java.util.Objects;
@RestControllerAdvice
public class ExceptionHandlerResponse {
    @ExceptionHandler(BusinessRuleExceptions.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemInfo handleBusinessException(BusinessRuleExceptions businessRuleExceptions) {
        ProblemInfo problemInfo = new ProblemInfo();
        problemInfo.setMessage(businessRuleExceptions.getMessage());
        return problemInfo;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ProblemInfo> handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
        ValidationErrorInfo validationErrorInfo = new ValidationErrorInfo();
        validationErrorInfo.setMessage("Validation error!");
        validationErrorInfo.setValidationErrorInfos(new HashMap<>());
        for (FieldError fieldError :
                methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
            validationErrorInfo.getValidationErrorInfos()
                    .put(fieldError.getField(),
                            fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(validationErrorInfo, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ProblemInfo> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = "Invalid input for parameter '" + ex.getName() + "'. Expected type: " +
                Objects.requireNonNull(ex.getRequiredType()).getSimpleName() + ", but received: " + ex.getValue();
        ProblemInfo problemInfo = ProblemInfo.builder()
                .message(message)
                .build();
        return new ResponseEntity<>(problemInfo, HttpStatus.BAD_REQUEST);
    }
}