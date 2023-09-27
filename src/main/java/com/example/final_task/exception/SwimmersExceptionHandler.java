package com.example.final_task.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.stream.Collectors;


@RestControllerAdvice
public class SwimmersExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // ここでエラーメッセージを作成
        String errorMessage = "Validation failed for argument(s): ";
        errorMessage += ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));

        // エラーメッセージとHTTPステータスを返す
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
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


//    @ExceptionHandler(value = NameAndStrokeNotFoundException.class)
//    public ResponseEntity<Map<String, String>> handleStrokeNotFound(
//            NameAndStrokeNotFoundException e, HttpServletRequest request) {
//        Map<String, String> body = Map.of(
//                "timestamp", ZonedDateTime.now().toString(),
//                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
//                "message", e.getMessage(),
//                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
//                "path", request.getRequestURI());
//        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
//    }

    @ExceptionHandler(value = NameNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNameNotFound(
            NameNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "message", e.getMessage(),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = StrokeNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleStrokeNotFound(
            StrokeNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "message", e.getMessage(),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "path", request.getRequestURI());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

}