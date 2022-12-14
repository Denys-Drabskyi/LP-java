package com.lw3.game;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class Main {
    public static void main(String[] args) {

        LocalDateTime time = LocalDateTime.now();
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm")));
    }
}

