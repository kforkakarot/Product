package com.twinleaves.products.exceptions;

public class GtinNotFoundException extends RuntimeException{

    public GtinNotFoundException(){
        super();
    }

    public GtinNotFoundException(String msg){
        super(msg);
    }
}
