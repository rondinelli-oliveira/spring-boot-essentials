package academy.devdojo.spring.boot.essentials.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {

    private final String fields;
    private final String fieldsMessage;
}
