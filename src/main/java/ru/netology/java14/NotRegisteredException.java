package ru.netology.java14;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String msg) {
        super(msg);
    }
}