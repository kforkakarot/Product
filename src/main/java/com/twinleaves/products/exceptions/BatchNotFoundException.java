package com.twinleaves.products.exceptions;

public class BatchNotFoundException extends RuntimeException{
    public BatchNotFoundException(){
        super();
    }

    public BatchNotFoundException(String msg){
        super(msg);
    }
}
