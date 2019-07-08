package com.ocr.max;

public class Mage extends Character {

    public Mage(int player, int level, int strength, int intelligence, int agility) {
        super(level, strength, intelligence, agility);
        System.out.println("Abracadabra je suis le Mage Joueur " + (player+1) + " niveau " + level + " je possède " + (5*level) + " de vitalité, " + strength + " de force, " + agility + " d'agilité et " + intelligence + " d'intelligence !");
    }

    public Attack attack(int value) {
        String attackName = null;
        int damage = 0, health = 0;
        switch (value){
            case 1 :
                attackName = "Boule de feu";
                damage = intelligence;
                break;
            case 2 :
                attackName = "Soin";
                health = (int) Math.floor(intelligence * 2);
                break;
        }
        return new Attack(attackName,damage,health);
    }
}
