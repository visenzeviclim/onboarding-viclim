package com.happy.exception;

public class EmptyQuantityException extends RuntimeException{
    public EmptyQuantityException(){
        super("Must Not Be Empty Value !!!");
    }
}
