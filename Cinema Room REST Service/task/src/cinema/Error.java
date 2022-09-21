package cinema;

import org.springframework.http.HttpStatus;

public class Error {



    private final int status;
    private final HttpStatus httpStatus;
    private final String error;

    Error(int status, HttpStatus httpStatus, String message){
        this.status = status;
        this.httpStatus = httpStatus;
        this.error = message;
    }
    public int getStatus() {
        return status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public String getError() {
        return error;
    }
}
