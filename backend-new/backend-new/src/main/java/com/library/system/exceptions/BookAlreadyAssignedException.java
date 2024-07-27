package com.library.system.exceptions;

public class BookAlreadyAssignedException extends RuntimeException{
    public BookAlreadyAssignedException() {
        super("Book Already Assigned to this User");
    }

}
