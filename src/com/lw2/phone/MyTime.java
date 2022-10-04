package com.lw2.phone;

import java.util.Objects;

public class MyTime {
    Long seconds;

    public MyTime(Long seconds) {
        this.seconds = seconds;
    }

    public Long getSeconds() {
        return seconds;
    }

    @Override
    public String toString() {
        return String.format("%01d:%02d:%02d",seconds/3600,seconds%60,seconds%3600%60) ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyTime myTime = (MyTime) o;

        return Objects.equals(seconds, myTime.seconds);
    }

    @Override
    public int hashCode() {
        return seconds != null ? seconds.hashCode() : 0;
    }
}
