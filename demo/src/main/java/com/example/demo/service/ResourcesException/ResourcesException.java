package com.example.demo.service.ResourcesException;

public class ResourcesException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourcesException(Object id){
        super("Resource Not Found. ID " + id);
    }
    
}
