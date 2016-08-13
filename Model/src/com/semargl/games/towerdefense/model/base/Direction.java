package com.semargl.games.towerdefense.model.base;

public class Direction {

    public static final double DEFAULT_THRESHOLD = 0.02;

    public static final double UP_RIGHT = Math.PI / 4;
    public static final double DOWN_RIGHT = -Math.PI * 5 / 4;
    public static final double DOWN_LEFT = -Math.PI * 3 / 4;
    public static final double UP_LEFT = -Math.PI / 4;

    public double angle;

    public Direction() {}

    public Direction(double angle) {
        this.angle = angle;
    }

    public Direction(Point from, Point to) {
        this.angle = Math.atan2(from.y - to.y, from.x - to.x) - Math.PI / 2;
    }

    public boolean approxEquals(Point from, Point to) {
        return approxEquals(new Direction(from, to).angle, DEFAULT_THRESHOLD);
    }

    public boolean approxEquals(double angle) {
        return approxEquals(angle, DEFAULT_THRESHOLD);
    }

    public boolean approxEquals(double angle, double threshold) {
        return Math.abs(this.angle - angle) < threshold; // TODO case when over Pi
    }

//    public Point getOffsetCoord(int offset) {
//
//    }
//
    public boolean isMostlyVertical() {
        return (angle > UP_LEFT && angle < UP_RIGHT) || (angle > DOWN_RIGHT && angle < DOWN_LEFT);
    }

    public boolean isGrowingX() {
        return angle > 0 || angle < -Math.PI;
    }

    public boolean isGrowingY() {
        return angle < (-Math.PI / 2);
    }

    @Override
    public String toString() {
        return "<" + angle + '>';
    }
}
