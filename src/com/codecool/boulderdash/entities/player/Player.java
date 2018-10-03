package com.codecool.boulderdash.entities.player;

import com.codecool.boulderdash.entities.GameEntity;
import com.codecool.boulderdash.Globals;
import com.codecool.boulderdash.entities.Animatable;
import com.codecool.boulderdash.entities.Interactable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Player extends GameEntity implements Animatable {

//    private static final double speed = 0.3;
//    private static final float turnRate = 2;
//    private GameEntity tail; // the last element. Needed to know where to add the next part.
//    private int health;
    private int stepMove = 40;


    /*
    so: Game is instantiated in Main.start() ,
    When Game is instantiated in its constructor instantiates some game entities Player included.
     */
    public Player(Pane pane, int xc, int yc) {
        super(pane);        // this calls superclass constructor and triggers [Globals.addGameObject(this);] within
        setX(xc);
        setY(yc);
//        health = 100;
//        tail = this;
        setImage(Globals.player);
        pane.getChildren().add(this);

        // addPart(4);      disabled SnakeBody init and placement
    }


    /*
    added my own method so Player moves only if key pressed
     */
    public void moveRight() {

        setX(getX() + stepMove);
    }

    public void moveLeft() {

        setX(getX() - stepMove);
    }

    public void moveDown() {

        setY(getY() + stepMove);
    }

    /*
    ok so: I can not find the source of getRotate() and setRotate()
     */
    public void step() {                // step is called in GameLoop in handle
             // great. i cant find source of getRotate() method.
        if (Globals.leftKeyDown) {

            Globals.leftKeyDown = false;
            Globals.player = new Image("DiggerLeft.png",38,38,true,true);
            setImage(Globals.player);
            this.moveLeft();
        }

        if (Globals.rightKeyDown) {

            Globals.rightKeyDown = false;
            Globals.player = new Image("DiggerRight.png",38,38,true,true);
            setImage(Globals.player);
            this.moveRight();
        }

        if (Globals.downKeyDown) {          // added for trials

            Globals.downKeyDown = false;
            this.moveDown();
        }

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {   // each Animatable has apply() method called on collision
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if (isOutOfBounds()) {
            System.out.println("Game Over");
            Globals.gameLoop.stop();
        }
    }
}

