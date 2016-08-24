package com.semargl.games.towerdefense.test;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.base.Coord;

public class CoordTest {

    static Coord p1 = new Coord(10, 20);
    static Coord p2 = new Coord(15, 2);
    static Coord p1x = new Coord(10, 30);
    static Coord p1y = new Coord(30, 20);

    public static void main(String[] args) {
        Log.debug("\n");

        //testDistance();
        //testAngle();
        //testDirection();

        Log.debug("");
    }

    public static void testDistance() {
        Log.debug("distance p1 p2: " + p1.distance(p2));
        Log.debug("distance p1 p1x: " + p1.distance(p1x));
        Log.debug("distance p1 p1y: " + p1.distance(p1y));
        Log.debug("");
    }

    public static void testAngle() {
        Log.debug("angle p1 p2: " + p1.angle(p2));
        Log.debug("angle p2 p1: " + p2.angle(p1));
        Log.debug("angle p1 p1x: " + p1.angle(p1x));
        Log.debug("angle p1x p1: " + p1x.angle(p1));
        Log.debug("angle p1 p1y: " + p1.angle(p1y));
        Log.debug("angle p1y p1: " + p1y.angle(p1));
        Log.debug("angle p2 p1y: " + p2.angle(p1y));

//        Coord p31 = new Coord(10, 10);
//        Coord p32 = new Coord(30, 10);
//        Coord p33 = new Coord(30, 30);
//        Coord p34 = new Coord(10, 30);
//        Log.debug("angle p34 p32: " + p34.angle(p32));
//        Log.debug("angle p31 p33: " + p31.angle(p33));
//        Log.debug("angle p32 p34: " + p32.angle(p34));
//        Log.debug("angle p33 p31: " + p33.angle(p31));
        Log.debug("");
    }


}
