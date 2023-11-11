package com.bujosa.beid.common.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bujosa.beid.common.dto.MessageDto;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<MessageDto> notFoundException(NotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessageDto(HttpStatus.NOT_FOUND, ex.getMessage()));
    }

    @ExceptionHandler(AttributeException.class)
    public ResponseEntity<MessageDto> attributeException(AttributeException ex) {
        return ResponseEntity.badRequest()
                .body(new MessageDto(HttpStatus.BAD_REQUEST, ex.getMessage()));
    }

}
