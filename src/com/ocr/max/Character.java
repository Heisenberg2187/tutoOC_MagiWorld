package com.ocr.max;

public abstract class Character {

    private String name;
    private int health;
    private int level;
    private int strength;
    private int intelligence;
    private int agility;

    public Character(String name, int level, int strength, int intelligence, int agility){
        this.name = name;
        this.health = 5*level;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    private void attackSpecial(){}

    private void attackBasic(){}

}