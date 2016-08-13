package com.semargl.games.towerdefense.model.weapon;

public class WeaponLevel {
    public int price;
    public int power;
    public int speed;
    public double distance;
    public int special;

    public WeaponLevel(int price, int power, int speed, double distance, int special) {
        this.price = price;
        this.power = power;
        this.speed = speed;
        this.distance = distance;
        this.special = special;
    }
}
