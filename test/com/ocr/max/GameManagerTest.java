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
    public void Given_BadValue_When_AskingForSomethingThatIsACharacter_Then_DisplayErrorSetence(){
        System.setIn(new ByteArrayInputStream(String.format("1%n").getBytes()));
        GameManager gameManager = new GameManager();
        gameManager.askSomething(1,3);
        String[] output = outContent.toString().replace("\r\n", "\n").split("\n");
        assertEquals("Ce nombre doit être compris entre 1 et 3",output[1]);
    }
}