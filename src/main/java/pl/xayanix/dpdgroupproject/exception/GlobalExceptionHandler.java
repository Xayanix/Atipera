package pl.xayanix.dpdgroupproject.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pl.xayanix.dpdgroupproject.model.ErrorResponse;


@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ApiException.class)
	public ResponseEntity<ErrorResponse> handleApiException(ApiException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getStatusCode(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.valueOf(ex.getStatusCode())).body(errorResponse);
	}
}
