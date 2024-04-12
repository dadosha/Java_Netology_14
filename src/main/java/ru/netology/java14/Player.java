package ru.netology.java14;

public class Player {
    private int id;
    private int strength;


    public Player(int id, int strength) {
        this.id = id;
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
