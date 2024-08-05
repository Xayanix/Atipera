package pl.xayanix.dpdgroupproject.exception;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@Getter
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ApiException extends RuntimeException {

    int statusCode;

    public ApiException(int statusCode, String message) {
        super(message);
        this.statusCode = statusCode;
    }

}
