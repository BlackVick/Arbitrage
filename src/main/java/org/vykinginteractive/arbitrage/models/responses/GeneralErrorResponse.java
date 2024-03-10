package org.vykinginteractive.arbitrage.models.responses;

import org.springframework.http.HttpStatus;

public class GeneralErrorResponse extends RuntimeException {

    private HttpStatus code;
    private boolean status;
    private String message;
    private String[] errors;

    public GeneralErrorResponse(HttpStatus code, boolean status, String message, String[] errors) {
        this.code = code;
        this.status = status;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatus getCode() {
        return code;
    }

    public boolean isStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String[] getErrors() {
        return errors;
    }

}
