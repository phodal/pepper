package com.phodal.pepper.normal.date.mockito;

public class MyCalenderClass {
    private final DateTime dateTime;

    public MyCalenderClass(final DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public long getDoubleTime() {
        return dateTime.getDate().getTime() * 2;
    }
}
