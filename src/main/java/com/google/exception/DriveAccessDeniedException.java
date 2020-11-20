package com.google.exception;

public class DriveAccessDeniedException extends RuntimeException {
    public DriveAccessDeniedException(String message)  {
        super(message);
    }
}
