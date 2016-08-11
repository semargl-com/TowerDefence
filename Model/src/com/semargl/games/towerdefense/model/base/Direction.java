package com.semargl.games.towerdefense.model.base;

public class Direction {

    public static final double DEFAULT_THRESHOLD = 0.02;

    public double angle;

    public Direction(double angle) {
        this.angle = angle;
    }

    public Direction(Point from, Point to) {
        this.angle = Math.atan2(from.y - to.y, from.x - to.x) - Math.PI / 2;
    }

    public Direction() {}

    public boolean approxEquals(Point from, Point to) {
        return approxEquals(new Direction(from, to).angle, DEFAULT_THRESHOLD);
    }

    public boolean approxEquals(double angle) {
        return approxEquals(angle, DEFAULT_THRESHOLD);
    }

    public boolean approxEquals(double angle, double threshold) {
        return Math.abs(this.angle - angle) < threshold; // TODO case when over Pi
    }

}
