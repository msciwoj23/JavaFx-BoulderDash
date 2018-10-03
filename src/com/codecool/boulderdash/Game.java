package com.codecool.boulderdash;

import com.codecool.boulderdash.entities.fields.Diamond;
import com.codecool.boulderdash.entities.fields.Ground;
import com.codecool.boulderdash.entities.fields.Stone;
import com.codecool.boulderdash.entities.player.Player;
import com.codecool.boulderdash.entities.fields.Door;
import com.codecool.boulderdash.entities.fields.Key;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        new Player(this, 1 , 1);
        int firstFieldFromTop = 40;
        int firstFieldFromLeft = 0;

        int myXc = firstFieldFromLeft;
        int myYc = firstFieldFromTop;
        for (int it = 0; it < Globals.levelPattern.length; it++) {
            for (char ch : Globals.levelPattern[it].toCharArray()) {
                if (ch == ' ') {
                    continue;
                } else if (ch == 'd') {
                    new Diamond(this, myXc , myYc);
                } else if (ch == 'k') {
                    new Key(this, myXc , myYc);
                } else if (ch == 'X') {
                    new Door(this, myXc , myYc);
                } else if (ch == 's') {
                    new Stone(this, myXc , myYc);
                } else {
                    new Ground(this, myXc , myYc);
                }
                myXc += 40;
            }
            myXc = firstFieldFromLeft;
            myYc += 40;
        }
    }

    /*
    this is called in Main
     */
    public void start() {
        Scene scene = getScene();
        scene.setOnKeyPressed(event -> {  // ok so setOnKeyPressed is a method of Scene class
            switch (event.getCode()) {          // don't know how many values event.getCode() can get
                case LEFT:  Globals.leftKeyDown  = true; break;
                case RIGHT: Globals.rightKeyDown  = true; break;
                case DOWN: Globals.downKeyDown = true; break;
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case LEFT:  Globals.leftKeyDown  = false; break;
                case RIGHT: Globals.rightKeyDown  = false; break;
                case DOWN: Globals.downKeyDown = false; break;
            }
        });
        /*
        GameLoop is our Class, it inherits from AnimationTimer the start() method.
        Once start is called, GameLoop.handle() is called once every frame.
         */
        Globals.gameLoop = new GameLoop();
        Globals.gameLoop.start();
    }
}
