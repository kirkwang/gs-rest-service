package com.example.hello;

public class RandomNumber {

    private final long id;
    private final String content;

    public RandomNumber(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
