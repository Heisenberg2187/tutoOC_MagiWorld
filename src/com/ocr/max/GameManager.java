package com.ocr.max;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {

    private static Character[] players = new Character[2];
    private static boolean isGameOver;
    private static Scanner sc = new Scanner(System.in);

    public void runGame(){
        isGameOver = false;

        for (int i = 0; i < players.length; i++){
            createPlayer(i);
        }

        do {

        } while (!isGameOver);
    }

    public void createPlayer(int playerNumber){
        System.out.println("Création du personnage du Joueur " + (playerNumber + 1) + "");
        int character = askCharacter();
        int level = askSkill("Niveau",1,100);
        int strength = askSkill("Force",0,level);
        int agility = askSkill("Agilité",0,level-strength);
        int intelligence = askSkill("Intelligence",level-strength-agility,level-strength-agility);

        switch (character){
            case 1 :
                players[playerNumber] = new Guerrier(playerNumber,level,strength,agility,intelligence);
                break;
            case 2 :
                players[playerNumber] = new Rodeur(playerNumber,level,strength,agility,intelligence);
                break;
            case 3 :
                players[playerNumber] = new Mage(playerNumber,level,strength,agility,intelligence);
                break;
        }

        return;

    }

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

    public int askCharacter(){
        System.out.println("Veuillez choisir la classe de votre personnage (1: Guerrier, 2 : Rôdeur, 3 : Mage)");
        return askSomething(1,3);
    }
    public int askSkill(String category, int min, int max){
        System.out.println(category + " du personnage ?");
        return askSomething(min,max);
    }
}
