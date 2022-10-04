package com.lw1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class for looking for a prime numbers in Luke numbers line
 */
public class TaskIncorrectImpl {
    private int firstNLukeNumber;
    private ArrayList<Long> ints;

    {
        setNewLength();
    }

    /**
     * Looking for a prime numbers in Luke numbers line
     */
    public void doTask(){
        System.out.printf("Простими серед %d чисел Люка є:\n",firstNLukeNumber);
        ints.stream().filter(x -> {
            for (int i = 2; i <= Math.sqrt(x); i++) if (x % i == 0) return false;
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
        ints = new ArrayList<>();
        if (firstNLukeNumber >= 1)
            ints.add(1L);
        if (firstNLukeNumber >= 2)
            ints.add(3L);
        for (int i = 2; i <= firstNLukeNumber; i++) {
            ints.add(ints.get(i-1)+ints.get(i-2));
        }
        System.out.println(ints);
    }
}
