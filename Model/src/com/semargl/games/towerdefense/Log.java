package com.semargl.games.towerdefense;

public class Log {

    private static final boolean LOG_LEVEL_DEBUG = true;

    public static void debug(String s) {
        if (LOG_LEVEL_DEBUG) {
            System.out.println(s);
        }
    }
}
