package com.in28minutes.rest.webservices.restfullwebservices.work;

public enum Level {
    DEVELOPER(0), MANAGER(5), ARCHITECT(10);

    private final int value;

    private Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
