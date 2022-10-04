package com.lw1;

public class FNumber {
    int position;
    long value;

    public FNumber(int position, long value) {
        this.position = position;
        this.value = value;
    }

    public int getPosition() {
        return position;
    }
//
//    public void setPosition(int position) {
//        this.position = position;
//    }

    public long getValue() {
        return value;
    }
//
//    public void setValue(int value) {
//        this.value = value;
//    }

    @Override
    public String toString() {
        return "FNumber{" +
                "position=" + position +
                ", value=" + value +
                '}';
    }
}
