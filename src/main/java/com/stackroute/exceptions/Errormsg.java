package com.stackroute.exceptions;
import lombok.Data;
//This class format the Exception in the form of Error Message and RequestedURI
@Data
public class Errormsg {

    private String errormessage;

    private String requestedURI;

    public void setErrormessage(String message) {
    }

    public void setRequestedURI(String requestURI) {
    }
}