package com.ocr.max;

public class Guerrier extends Character {

    public Guerrier(int player, int level, int strength, int intelligence, int agility) {
        super(level, strength, intelligence, agility);
        System.out.println("Woarg je suis le Guerrier Joueur " + (player+1) + " niveau " + level + " je possède " + (5*level) + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !");
    }

    public Attack attack(int value) {
        String attackName = null;
        int damage = 0, health = 0;
        switch (value){
            case 1 :
                attackName = "Coup d'Epée";
                damage = strength;
                break;
            case 2 :
                attackName = "Coup de Rage";
                damage = strength * 2;
                health = (int) -Math.floor(strength * 0.5);
                break;
        }
        return new Attack(attackName,damage,health);
    }
}
