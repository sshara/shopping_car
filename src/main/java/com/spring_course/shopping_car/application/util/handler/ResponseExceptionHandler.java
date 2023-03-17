package com.spring_course.shopping_car.application.util.handler;

import com.spring_course.shopping_car.application.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ResponseDto> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex) {
        ResponseDto errorResponse = new ResponseDto();
        errorResponse.setCode("03");
        errorResponse.setMessage("Error parametros de entrada");

        Map<String, String> errorsField = new HashMap<>();
        for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
            errorsField.put(fieldError.getField(), fieldError.getDefaultMessage());
            errorResponse.setData(errorsField);
        }
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
