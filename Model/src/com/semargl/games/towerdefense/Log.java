package com.semargl.games.towerdefense;

public class Log {

    private static final boolean LOG_LEVEL_DEBUG = true;

    public static void debug(String s) {
        if (LOG_LEVEL_DEBUG) {
            System.out.println(s);
        }
    }

    public static void error(String s) {
        System.out.println("[ERROR] " + s);
    }

    public static void error(String s, Throwable t) {
        error(s);
        t.printStackTrace();
    }
}
