package com.example.demo.service.ResourcesException;

public class ResourcesNotFoundException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ResourcesNotFoundException(Object id){
        super("Resource Not Found. ID " + id);
    }
    
}
