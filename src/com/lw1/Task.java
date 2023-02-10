package com.lw1;

import java.util.ArrayList;
import java.util.Scanner;

public class Task {
    private int firstNLukeNumber;
    private ArrayList<FNumber> numbers;

    {
        setNewLength();
    }

    /**
     * Looking for a prime numbers in Luke numbers line
     */
    public void doTask(){
        System.out.printf("Простими серед %d чисел Люка є:\n",firstNLukeNumber);
        numbers.stream().filter(x -> {
            for (int i = 2; i <= Math.sqrt(x.getValue()); i++) if (x.getValue() % i == 0) return false;
            return true;
        }).forEach(System.out::println);
    }

    /**
     * Setting a length of Luke numbers line
     */
    public void setNewLength (){
        Scanner s = new Scanner(System.in);
        System.out.println("Введіть кількість чисел у ряді Люка");
        try {
            firstNLukeNumber = s.nextInt();
            if (firstNLukeNumber <= 0)
                throw new RuntimeException("e");
            generateLine();
        } catch (Exception e){
            if (e.getMessage()!=null)
                System.out.println("Кількість повинна бути більшою за 0");
            else
                System.out.println("Кількість - це ціле невід'ємне число, в нашому випадку більше 0");
            setNewLength();
        }
    }

    /**
     *  Generating a Luke numbers line
     */
    private void generateLine (){
        numbers = new ArrayList<>();
        if (firstNLukeNumber >= 1)
            numbers.add(new FNumber(1,2L));
        if (firstNLukeNumber >= 2)
            numbers.add(new FNumber(2,1L));
        for (int i = 3; i <= firstNLukeNumber; i++) {
            numbers.add(new FNumber(i, numbers.get(i-2).getValue()+ numbers.get(i-3).getValue()));
        }
        System.out.println(numbers);
    }
}
