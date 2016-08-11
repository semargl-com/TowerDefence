package com.semargl.games.towerdefense.model.base;

public class Point {
    public int x;
    public int y;

    public Point() {
    }

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point p) {
        return Math.hypot(x - p.x, y - p.y);
    }

    public double angle(Point p) {
        return Math.atan2(y - p.y, x - p.x) - Math.PI / 2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return y * 10_000 + x;
    }
}
