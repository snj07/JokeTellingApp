package com.snj.jokeslib;

import java.util.Random;

public class JokeCracker {
    private static String[] JOKES = {
            "Romantic relationships can actually be represented in algebra. You for example, have definitely at some point looked at your X and asked yourself Y.",
            "Why are astronauts always so calm and efficient?\nZero pressure in vacuum.",
            "Moses was leading his people across the dessert to the promised land for 40 years. This was possibly the start of the saying that men refuse to stop and ask for directions.",
            " Time is money. Therefore, ATMs are time machines.",
            "Q: Why is beer never served at a math party? \n" +
                    "A: Because you can't drink and derive. ",
            "Q: What do you get if you take your computer to an ice rink? \n" +
                    "A: A slipped disk ",
            "Windows Vista supports real multitasking - it can boot and crash simultaneously. ",
            "Programming is like sex, one mistake and you have to support it for the rest of your life.",
            "Unix is user friendly. It's just selective about who its friends are. ",
            "Artificial intelligence usually beats real stupidity. ",
            "If you think patience is a virtue, try surfing the net on a 14.4k dial up connection.",
            "A computer once beat me at chess, but it was no match for me at kick boxing."
    };


    public String getJoke() {
        //returns random joke from array
        return JOKES[new Random(System.currentTimeMillis()).nextInt(JOKES.length)];
    }

}
