package com.ocr.max;

public class Guerrier extends Character {

    public Guerrier(int player, int level, int strength, int intelligence, int agility) {
        super("Guerrier", level, strength, intelligence, agility);
        System.out.println("Woarg je suis le Guerrier Joueur " + (player+1) + " niveau " + level + " je possède " + (5*level) + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence");
    }

}
