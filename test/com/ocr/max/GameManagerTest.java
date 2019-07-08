package com.ocr.max;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameManagerTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(System.out);
    }

    @Test
    public void Given_BadValue_When_AskingForSomethingThatIsACharacter_Then_DisplayErrorSentence(){
        System.setIn(new ByteArrayInputStream(String.format("0%n2%n").getBytes()));
        GameManager gameManager = new GameManager();
        gameManager.askSomething(1,3);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Ce nombre doit être compris entre 1 et 3",output[0]);
    }
    @Test
    public void Given_BadValue_When_AskingForFirstSkill_Then_DisplayErrorSentence(){
        System.setIn(new ByteArrayInputStream(String.format("100%n10%n").getBytes()));
        GameManager gameManager = new GameManager();
        gameManager.askSomething(0,20);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Ce nombre doit être compris entre 0 et 20",output[0]);
    }
    @Test
    public void Given_BadValue_When_AskingForLastSkill_Then_DisplayErrorSentence(){
        System.setIn(new ByteArrayInputStream(String.format("0%n20%n").getBytes()));
        GameManager gameManager = new GameManager();
        gameManager.askSomething(20,20);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Ce nombre doit être égal à 20 (la somme des compétences doit être égale au niveau)",output[0]);
    }
    @Test
    public void Given_Responses_When_CreatingPlayer_Then_DisplaySuccessSentence(){
        System.setIn(new ByteArrayInputStream(String.format("1%n10%n10%n0%n0%n").getBytes()));
        GameManager gameManager = new GameManager();
        gameManager.createPlayer(0);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Woarg je suis le Guerrier Joueur 1 niveau 10 je possède 50 de vitalité, 10 de force, 0 d'agilité et 0 d'intelligence !",output[6]);
    }
    @Test
    public void Given_BasicAttackChoice_When_Player1AttacksWithGuerrier_Then_RemoveHealthPlayer2EqualToStrength(){
        System.setIn(new ByteArrayInputStream(String.format("1%n10%n10%n0%n0%n3%n10%n0%n0%n10%n1%n").getBytes()));
        GameManager gameManager = new GameManager();
        for (int i = 0; i < 2; i++)
            gameManager.createPlayer(i);
        gameManager.playRoundPlayer(0);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        System.out.println(output);
        assertEquals("Joueur 1 utilise Coup d'Epée et inflige 10 dommages.",output[15]);
        assertEquals("Joueur 2 perd 10 points de vie",output[16]);
    }
}