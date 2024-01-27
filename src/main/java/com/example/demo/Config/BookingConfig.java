package com.example.demo.Config;

public class BookingConfig {
    public static class UpdateNotAllowedException extends RuntimeException {
        public UpdateNotAllowedException(String message) {
            super(message);
        }
    }
}
