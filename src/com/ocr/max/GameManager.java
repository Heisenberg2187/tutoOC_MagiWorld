package com.ocr.max;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {

    private Scanner sc = new Scanner(System.in);
    private Character[] players = new Character[2];
    private boolean isGameOver;

    /**
     * start the game
     */
    public void runGame(){
        isGameOver = false;
        for (int i = 0; i < players.length; i++)
            createPlayer(i);
        do {
            for (int i = 0; i < players.length; i++){
                playRoundPlayer(i);
                if (isGameOver)
                    break;
            }
        } while (!isGameOver);
        for (int i = 0; i < players.length; i++)
        {
            if (players[i].getHealth() == 0)
                System.out.println("Joueur " + ( i + 1 ) + " a perdu !");
        }
    }

    /**
     * create and assign one player to the players array
     * @param playerNumber number of the player (0 or 1)
     */
    public void createPlayer(int playerNumber){
        System.out.println("Création du personnage du Joueur " + (playerNumber + 1) + "");
        int character = askCharacter();
        int level = askSkill("Niveau",1,100);
        int strength = askSkill("Force",0,level);
        int agility = askSkill("Agilité",0,level-strength);
        int intelligence = askSkill("Intelligence",level-strength-agility,level-strength-agility);
        switch (character){
            case 1 :
                players[playerNumber] = new Guerrier(playerNumber,level,strength,intelligence,agility);
                break;
            case 2 :
                players[playerNumber] = new Rodeur(playerNumber,level,strength,intelligence,agility);
                break;
            case 3 :
                players[playerNumber] = new Mage(playerNumber,level,strength,intelligence,agility);
                break;
        }
        return;
    }

    /**
     * ask to the player a certain number (for character, skill or attack choice) that must be between min and max
     * @param min minimum of the interval
     * @param max maximum of the interval
     * @return the choice of the player
     */
    public int askSomething(int min, int max){
        boolean isAnswerGood = false;
        int value = -1;
        do {
            try {
                value = sc.nextInt();
                isAnswerGood = (value >= min && value <= max);
            } catch (InputMismatchException e){
                sc.next();
                isAnswerGood = false;
            }
            if (!isAnswerGood){
                if (min == max)
                    System.out.println("Ce nombre doit être égal à " + max + " (la somme des compétences doit être égale au niveau)");
                else
                    System.out.println("Ce nombre doit être compris entre " + min + " et " + max);
            }
        } while (!isAnswerGood);
        return value;
    }

    /**
     * ask to the player to choose a character class
     * @return the player's choice
     */
    public int askCharacter(){
        System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2 : Rôdeur, 3 : Mage)");
        return askSomething(1,3);
    }

    /**
     * ask to the player to choose a quantity (between min and max) for his or her skills
     * @param category name of the skill to assign
     * @param min minimum of the interval
     * @param max maximum of the interval
     * @return the player's choice
     */
    public int askSkill(String category, int min, int max){
        System.out.println(category + " du personnage ?");
        return askSomething(min,max);
    }

    /**
     * launch one round by asking to the player what attack he or she wants to play
     * @param player number of the player (0 or 1)
     */
    public void playRoundPlayer(int player){
        int otherPlayer = (player == 0) ? 1 : 0;
        System.out.println("Joueur " + (player+1) + " (" + players[player].getHealth() + " Vitalité) veuillez choisir votre action (1 : Attaque Basique, 2 : Attaque Spéciale)");
        int attackValue = askSomething(1,2);
        Attack attack = players[player].attack(attackValue);
        if (attack.damage != 0)
        {
            System.out.println("Joueur " + (player+1) + " utilise " + attack.name + " et inflige " + attack.damage + " dommages.");
            players[otherPlayer].addHealth(-attack.damage);
            System.out.println("Joueur " + (otherPlayer+1) + " perd " + attack.damage + " points de vie");
            if (players[otherPlayer].getHealth() == 0)
            {
                System.out.println("Joueur " + (otherPlayer+1) + " est mort");
                isGameOver = true;
            }
        }
        players[player].addHealth(attack.health);
        if (attack.health > 0)
            System.out.println("Joueur " + (player+1) + " utilise " + attack.name + " et gagne " + attack.health + " en vitalité");
        else if (attack.health < 0)
        {
            System.out.println("Joueur " + (player+1) + " perd " + Math.abs(attack.health) + " points de vie");
            if (players[player].getHealth() == 0)
            {
                System.out.println("Joueur " + (player+1) + " est mort");
                isGameOver = true;
            }
        }
        return;
    }
}
