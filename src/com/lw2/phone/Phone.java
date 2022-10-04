package com.lw2.phone;

public class Phone {
    private int id;
    private String name;
    private String surname;
    private int accountNumber;
    private MyTime localTalkTime;
    private MyTime longDistanceTalkTime;

    public Phone(int id, String name, String surname, int accountNumber, MyTime localTalkTime, MyTime longDistanceTalkTime) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.accountNumber = accountNumber;
        this.localTalkTime = localTalkTime;
        this.longDistanceTalkTime = longDistanceTalkTime;
    }

    @Override
    public String toString() {
        return
                "\tid =" + id +
                        ",\t Ім'я ='" + name + '\'' +
                        ",\t Прізвище = '" + surname + '\'' +
                        ",\t Номер рахунку =" + accountNumber +
                        ",\t Час міських розмов =" + localTalkTime +
                        ",\t Час міжміських розмов =" + longDistanceTalkTime +
                        '}';
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public MyTime getLocalTalkTime() {
        return localTalkTime;
    }

    public void setLocalTalkTime(MyTime localTalkTime) {
        this.localTalkTime = localTalkTime;
    }

    public MyTime getLongDistanceTalkTime() {
        return longDistanceTalkTime;
    }

    public void setLongDistanceTalkTime(MyTime longDistanceTalkTime) {
        this.longDistanceTalkTime = longDistanceTalkTime;
    }
}
