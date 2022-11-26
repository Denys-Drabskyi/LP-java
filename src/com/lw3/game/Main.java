package com.lw3.game;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

class Main {
    public static void main(String[] args) {
//        Game game = new GameImpl();
//        game.run();
        LocalDateTime time = LocalDateTime.now();
//        time.format(DateTimeFormatter.ofPattern("dd/MM/jj hh:mm"));
        System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yy hh:mm")));
    }
}

