package com.codelogic.MultiUserAuth.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.ALREADY_REPORTED)
public class JobAlreadyExistsException extends Exception{


}
