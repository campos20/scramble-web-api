package com.alexandrecampos.scramblewebapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@SuppressWarnings("serial")
@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidParamException extends ScrambleWebApiException {
	public InvalidParamException(String message) {
		super(message);
	}
}
