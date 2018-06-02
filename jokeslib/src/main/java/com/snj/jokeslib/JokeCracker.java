package com.snj.jokeslib;

import java.util.Random;

public class JokeCracker {
    private static String[] JOKES = {
            "Romantic relationships can actually be represented in algebra. You for example, have definitely at some point looked at your X and asked yourself Y.",
            "Why are astronauts always so calm and efficient?\nZero pressure in vacuum.",
            "Moses was leading his people across the dessert to the promised land for 40 years. This was possibly the start of the saying that men refuse to stop and ask for directions.",
            " Time is money. Therefore, ATMs are time machines.",
            "A fine is a tax when you’ve been doing something wrong. A tax is a fine you get when you’ve been doing something right.\n"
    };


    public String getJoke() {
        //returns random joke from array
        return JOKES[new Random(System.currentTimeMillis()).nextInt(JOKES.length)];
    }

}
