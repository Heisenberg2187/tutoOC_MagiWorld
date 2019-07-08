package com.ocr.max;

public abstract class Character {

    private int health;
    private int maxHealth;
    protected int level;
    protected int strength;
    protected int intelligence;
    protected int agility;

    public int getHealth() {
        return health;
    }

    /**
     * add (resp. remove) a quantity of health if positive (resp. negative)
     * @param health quantity of health
     */
    public void addHealth(int health) {
        this.health += health;
        if (this.health > this.maxHealth)
            this.health = this.maxHealth;
        else if (this.health < 0)
            this.health = 0;
    }

    public Character(int level, int strength, int intelligence, int agility){
        this.maxHealth = 5 * level;
        this.health = this.maxHealth;
        this.level = level;
        this.strength = strength;
        this.intelligence = intelligence;
        this.agility = agility;
    }

    abstract Attack attack(int value);


}
