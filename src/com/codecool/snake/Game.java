package com.codecool.snake;

import com.codecool.snake.entities.enemies.SimpleEnemy;
import com.codecool.snake.entities.powerups.SimplePowerup;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

public class Game extends Pane {

    public Game() {
        new SnakeHead(this, 100, 40);

//        new SimpleEnemy(this);
//        new SimpleEnemy(this);
//        new SimpleEnemy(this);
//        new SimpleEnemy(this);


        // this is what I injected
        int myXc = 100;
        int myYc = 100;

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                new SimplePowerup(this, myXc , myYc);
                myXc += 60;
            }
            myXc = 100;
            myYc += 60;
        }


//        new SimplePowerup(this);
//        new SimplePowerup(this);
//        new SimplePowerup(this);
//        new SimplePowerup(this);
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