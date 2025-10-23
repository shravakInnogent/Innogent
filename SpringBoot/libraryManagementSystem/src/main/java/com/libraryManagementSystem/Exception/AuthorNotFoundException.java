package com.libraryManagementSystem.Exception;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(long id){
        super("No author found with id:" + id);
    }
    public AuthorNotFoundException(String message) {
        super(message);
    }
}
