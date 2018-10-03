package com.codecool.boulderdash;

import com.codecool.boulderdash.entities.fields.Ground;
import com.codecool.boulderdash.entities.player.Player;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        new Player(this, 101, 61);



        // this is what I injected
        int myXc = 100;
        int myYc = 100;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                new Ground(this, myXc , myYc);
                myXc += 40;
            }
            myXc = 100;
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
