package com.ocr.max;

public class Mage extends Character {


    public Mage(int player, int level, int strength, int intelligence, int agility) {
        super("Mage", level, strength, intelligence, agility);
        System.out.println("Abracadabra je suis le Mage Joueur " + (player+1) + " niveau " + level + " je possède " + (5*level) + " de vitalité, " + strength + " de force, " + agility + " d'agilité, et " + intelligence + " d'intelligence");
    }
}
