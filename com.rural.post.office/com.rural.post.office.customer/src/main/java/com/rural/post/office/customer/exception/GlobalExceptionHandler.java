//package com.rural.post.office.customer.exception;
//
//import jakarta.servlet.http.HttpServletRequest;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.time.LocalDateTime;
//
//@RestControllerAdvice
//@Slf4j
//public class GlobalExceptionHandler {
//    @ExceptionHandler(ResourceNotFoundException.class)
//    public ResponseEntity<ApiErrorResponse> handleNotFound(
//            ResourceNotFoundException ex,
//            HttpServletRequest request) {
//
//        return buildError(HttpStatus.NOT_FOUND, ex.getMessage(), request);
//    }
//
//    @ExceptionHandler(BusinessException.class)
//    public ResponseEntity<ApiErrorResponse> handleBusiness(
//            BusinessException ex,
//            HttpServletRequest request) {
//
//        return buildError(HttpStatus.BAD_REQUEST, ex.getMessage(), request);
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiErrorResponse> handleValidation(
//            MethodArgumentNotValidException ex,
//            HttpServletRequest request) {
//
//        String msg = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(e -> e.getField() + ": " + e.getDefaultMessage())
//                .findFirst()
//                .orElse("Validation error");
//
//        return buildError(HttpStatus.BAD_REQUEST, msg, request);
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiErrorResponse> handleGeneric(
//            Exception ex,
//            HttpServletRequest request) {
//
//        log.error("Unhandled exception", ex);
//        return buildError(
//                HttpStatus.INTERNAL_SERVER_ERROR,
//                "Internal server error",
//                request);
//    }
//
//    private ResponseEntity<ApiErrorResponse> buildError(
//            HttpStatus status, String message, HttpServletRequest request) {
//
//        ApiErrorResponse response = ApiErrorResponse.builder()
//                .timestamp(LocalDateTime.now())
//                .status(status.value())
//                .error(status.getReasonPhrase())
//                .message(message)
//                .path(request.getRequestURI())
//                .build();
//
//        return ResponseEntity.status(status).body(response);
//    }
//}
