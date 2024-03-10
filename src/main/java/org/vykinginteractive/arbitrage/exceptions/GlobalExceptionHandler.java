package org.vykinginteractive.arbitrage.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.vykinginteractive.arbitrage.models.responses.GeneralErrorResponse;

import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //general exception
    @ExceptionHandler(GeneralErrorResponse.class)
    @ResponseBody
    public ResponseEntity<Object> handleException(GeneralErrorResponse ex) {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", ex.isStatus());
        map.put("message", ex.getMessage());
        map.put("errors", ex.getErrors() != null ? ex.getErrors() : new String[]{});

        return new ResponseEntity<Object>(map, ex.getCode());
    }

    //server error exception
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ResponseEntity<Object> handleDefaultException(Exception ex) {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", false);
        map.put("message", ex.getMessage());

        return new ResponseEntity<Object>(map, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //authentication exception
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleAuthException(AccessDeniedException ex) {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", false);
        map.put("message", ex.getMessage());

        return new ResponseEntity<Object>(map, HttpStatus.UNAUTHORIZED);
    }

    //authentication exception
    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleUnauthorizedException(HttpClientErrorException.Unauthorized ex) {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", false);
        map.put("message", ex.getMessage());

        return new ResponseEntity<Object>(map, HttpStatus.UNAUTHORIZED);
    }

    //forbidden exception
    @ExceptionHandler(HttpClientErrorException.Forbidden.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ResponseBody
    public ResponseEntity<Object> handleForbiddenException(HttpClientErrorException.Forbidden ex) {

        Map<String, Object> map = new LinkedHashMap<>();
        map.put("status", false);
        map.put("message", ex.getMessage());

        return new ResponseEntity<Object>(map, HttpStatus.UNAUTHORIZED);
    }

    //validation exception
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> notValid(MethodArgumentNotValidException ex, HttpServletRequest request) {
        List<String> errors = new ArrayList<>();

        ex.getAllErrors().forEach(err -> errors.add(err.getDefaultMessage()));

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("status", false);
        result.put("message", "Validation error");
        result.put("errors", errors);

        return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
    }

}
