package com.ltp.contacts.exception;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

public class ErrorResponse {
    
    private List<String> message;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timeStamp;


    public ErrorResponse(List<String> message) {
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }


    public List<String> getMessage() {
        return message;
    }


    public void setMessage(List<String> message) {
        this.message = message;
    }


    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }


    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    

    
}
