package com.in28minutes.rest.webservices.restfulwebservices.exception;

import java.util.Date;

/** Creating a Response for the httpstatus response (basic structure)
 * I want to create a message to return on a specific format */
public class ExceptionResponse {

    private Date timestamp;
    private String message;
    private String details;


    public ExceptionResponse(Date timestamp, String message, String details) {
        super();
        this.timestamp = timestamp;
        this.message = message;
        this.details = details;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
