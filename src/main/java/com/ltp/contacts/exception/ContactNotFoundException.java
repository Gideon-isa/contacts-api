package com.ltp.contacts.exception;

public class ContactNotFoundException extends RuntimeException{

    public ContactNotFoundException(String id) {
        // contrsuctor get called when exception is thrown
        //passing an error message into the parent constructor allows us to access it later...
        super("The id '" + id + " ' does not exist in our records");
    }
    
}
