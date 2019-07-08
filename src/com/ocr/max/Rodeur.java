package com.ocr.max;

public class Rodeur extends Character {


    public Rodeur(int player, int level, int strength, int intelligence, int agility) {
        super("Rôdeur", level, strength, intelligence, agility);
        System.out.println("Shhhh je suis le Rôdeur Joueur " + (player+1) + " niveau " + level + " je possède " + (5*level) + " de vitalité, " + strength + " de force, " + agility + " d'agilité, et " + intelligence + " d'intelligence");

    }
}
