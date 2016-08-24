package com.semargl.games.towerdefense.test;

import com.semargl.games.towerdefense.Log;
import com.semargl.games.towerdefense.model.base.Direction;

public class DirectionTest {

    public static void main(String[] args) {
        Log.debug("\n");

        //testOffsetCoord();
        testRotate();
        //testAlmostEquals();

        Log.debug("");
    }

    public static void testDirection() {
//        Log.debug("direction 0.23: " + new Direction(0.23).at(p1, p2));
//        Log.debug("direction 0.252: " + new Direction(0.252).at(p1, p2));
//        Log.debug("direction 0.27: " + new Direction(0.27).at(p1, p2));
//        Log.debug("direction 0.29: " + new Direction(0.29).at(p1, p2));
//        Log.debug("direction 0.31: " + new Direction(0.31).at(p1, p2));
        Log.debug("");
    }
    public static void testOffsetCoord() {
        //Coord p = new Coord();
        Log.debug("DOWN_RIGHT x: " + new Direction(Direction.DOWN_RIGHT).xCoef());
        Log.debug("DOWN_RIGHT y: " + new Direction(Direction.DOWN_RIGHT).yCoef());
        Log.debug("UP_LEFT x: " + new Direction(Direction.UP_LEFT).xCoef());
        Log.debug("UP_LEFT y: " + new Direction(Direction.UP_LEFT).yCoef());
        Log.debug("UP_RIGHT x: " + new Direction(Direction.UP_RIGHT).xCoef());
        Log.debug("UP_RIGHT y: " + new Direction(Direction.UP_RIGHT).yCoef());
        Log.debug("DOWN_LEFT x: " + new Direction(Direction.DOWN_LEFT).xCoef());
        Log.debug("DOWN_LEFT y: " + new Direction(Direction.DOWN_LEFT).yCoef());
        //Log.debug("distance p1 p2: " + p.getOffsetCoord(new Direction(Direction.DOWN_RIGHT), 10));
    }

    public static void testRotate() {
        Direction d = new Direction();
        Log.debug("d: " + d);
        d.rotate(1, 0.2);
        Log.debug("after rotate to: " + 1 + " at angle: " + 0.2 + " :" + d);
        d.rotate(-1, 0.3);
        Log.debug("after rotate to: " + -1 + " at angle: " + 0.3 + " :" + d);

        //d.rotate();
    }

    public static void testAlmostEquals() {

    }

//    public static void testAngleMostlyVertical() {
//        Log.debug("angle p1 p2 vert: " + new Direction(p1.angle(p2)).isMostlyVertical());
//        Log.debug("angle p2 p1 vert: " + new Direction(p2.angle(p1)).isMostlyVertical());
//        Log.debug("angle p1 p1x vert: " + new Direction(p1.angle(p1x)).isMostlyVertical());
//        Log.debug("angle p1x p1 vert: " + new Direction(p1x.angle(p1)).isMostlyVertical());
//        Log.debug("angle p1 p1y vert: " + new Direction(p1.angle(p1y)).isMostlyVertical());
//        Log.debug("angle p1y p1 vert: " + new Direction(p1y.angle(p1)).isMostlyVertical());
//        Log.debug("angle p2 p1y vert: " + new Direction(p2.angle(p1y)).isMostlyVertical());
//    }
//
//    public static void testAngleGrowing() {
//        Log.debug("angle p1 p2 grow x y: " + new Direction(p1.angle(p2)).isGrowingX() + " " + new Direction(p1.angle(p2)).isGrowingY());
//        Log.debug("angle p2 p1 grow x y: " + new Direction(p2.angle(p1)).isGrowingX() + " " + new Direction(p2.angle(p1)).isGrowingY());
//        Log.debug("angle p1 p1x grow x y: " + new Direction(p1.angle(p1x)).isGrowingX() + " " + new Direction(p1.angle(p1x)).isGrowingY());
//        Log.debug("angle p1x p1 grow x y: " + new Direction(p1x.angle(p1)).isGrowingX() + " " + new Direction(p1x.angle(p1)).isGrowingY());
//        Log.debug("angle p1 p1y grow x y: " + new Direction(p1.angle(p1y)).isGrowingX() + " " + new Direction(p1.angle(p1y)).isGrowingY());
//        Log.debug("angle p1y p1 grow x y: " + new Direction(p1y.angle(p1)).isGrowingX() + " " + new Direction(p1y.angle(p1)).isGrowingY());
//        Log.debug("angle p2 p1y grow x y: " + new Direction(p2.angle(p1y)).isGrowingX() + " " + new Direction(p2.angle(p1y)).isGrowingY());
//    }

}
