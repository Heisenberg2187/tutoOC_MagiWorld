package com.ocr.max;

public class Rodeur extends Character {

    public Rodeur(int player, int level, int strength, int intelligence, int agility) {
        super(level, strength, intelligence, agility);
        System.out.println("Shhhh je suis le Rôdeur Joueur " + (player+1) + " niveau " + level + " je possède " + (5*level) + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !");
    }

    public Attack attack(int value) {
        String attackName = null;
        int damage = 0, health = 0;
        switch (value){
            case 1 :
                attackName = "Tir à l'Arc";
                damage = agility;
                break;
            case 2 :
                attackName = "Concentration";
                agility += (int) Math.floor(level * 0.5);
                break;
        }
        return new Attack(attackName,damage,health);
    }
}
