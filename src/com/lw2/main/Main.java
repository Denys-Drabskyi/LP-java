package com.lw2.main;

import com.lw2.phone.MyTime;
import com.lw2.phone.Phone;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArrayList<Phone> phones = dataPreparation();
        task1(phones);
        task2(phones);
        task3(phones);
    }

    /**
     * generating users, setting some of them longDistanceTalkTime to 0
     */
    static ArrayList<Phone> dataPreparation (){
        Random random = new Random();
        String[] names = {"Olha", "Tania", "Oleh", "Anna", "Sophi", "Nazar", "Vira", "Nadia", "Ben", "Bob"};
        String[] surnames = {"Adams", "Wilson", "Burton", "Harris", "Stevens", "Lewis", "Walker", "Payne", "Baker"};
        ArrayList<Phone> phones = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            phones.add(new Phone(
                    i,
                    names[random.nextInt(names.length)],
                    surnames[random.nextInt(surnames.length)],
                    i+1000,
                    new MyTime(random.nextLong(0,10000)),
                    new MyTime(random.nextLong(0,10000))
            ));
        }
        int counter = random.nextInt(0,3);
        while (counter<30){
            phones.get(counter).setLongDistanceTalkTime(new MyTime(0L));
            counter += random.nextInt(0,10);
        }
        return phones;
    }

    static void task1(ArrayList<Phone>phones){
        System.out.println("Відомості про абонентів, у яких час міських розмов перевищує заданий;");
        List<Phone> phones1 = phones.stream().filter(phone -> phone.getLocalTalkTime().getSeconds() > 3600L).toList();
        phones1.forEach(System.out::println);
        System.out.printf("Кількість абонентів у яких час міських розмов перевищує заданий %d", phones1.size());

    }
    static void task2(ArrayList<Phone>phones){
        System.out.println("\n\nВідомості про абонентів, які користувались міжміським зв'язком;");
        phones.stream().filter(phone -> phone.getLongDistanceTalkTime().getSeconds()>0L).forEach(System.out::println);
        System.out.printf("Кількість абонентів, які користувались міжміським зв'язком %d",phones.stream().filter(phone -> phone.getLongDistanceTalkTime().getSeconds()>0L).count());
    }

    static void task3(ArrayList<Phone>phones){
        System.out.println("\n\nВідомості про абонентів чий номер рахунку знаходиться в діапазоні 1010 - 1015");
        phones.stream().filter(phone -> phone.getAccountNumber()>=1010 && phone.getAccountNumber()<=1015).forEach(System.out::println);
    }
}