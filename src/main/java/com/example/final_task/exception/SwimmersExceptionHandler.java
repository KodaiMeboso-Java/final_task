package com.example.final_task.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class SwimmersExceptionHandler {
    //    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
//        // ここでエラーメッセージを作成
//        String errorMessage = "Validation failed for argument(s): ";
//        errorMessage += ex.getBindingResult().getFieldErrors().stream()
//                .map(error -> error.getDefaultMessage())
//                .collect(Collectors.joining(", "));
//
//        // エラーメッセージとHTTPステータスを返す
//        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
//    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<Map<String, String>> errors = new ArrayList<>();
        e.getBindingResult().getFieldErrors().forEach(fieldError -> {
            Map<String, String> error = new HashMap<>();
            error.put("field", fieldError.getField());
            error.put("message", fieldError.getDefaultMessage());
            errors.add(error);
        });
        ErrorResponse errorResponse =
                new ErrorResponse(HttpStatus.BAD_REQUEST, "validation error", errors);
        return ResponseEntity.badRequest().body(errorResponse);
    }

    /**
     * エラーレスポンスのクラス
     */
    public static final class ErrorResponse {
        private final HttpStatus status;
        private final String message;
        private final List<Map<String, String>> errors;

        public ErrorResponse(HttpStatus status, String message, List<Map<String, String>> errors) {
            this.status = status;
            this.message = message;
            this.errors = errors;
        }

        public HttpStatus getStatus() {
            return status;
        }

        public String getMessage() {
            return message;
        }

        public List<Map<String, String>> getErrors() {
            return errors;
        }

    }

    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNoResourceFound(
            ResourceNotFoundException e, HttpServletRequest request) {

        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "message", e.getMessage(),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "path", request.getRequestURI());

        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NameAndStrokeNotFoundException.class)
    public ResponseEntity<String> handleNameAndStrokeNotFoundException(NameAndStrokeNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
    }
}