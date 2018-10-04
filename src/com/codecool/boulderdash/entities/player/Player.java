package com.codecool.boulderdash.entities.player;

import com.codecool.boulderdash.entities.GameEntity;
import com.codecool.boulderdash.Globals;
import com.codecool.boulderdash.entities.Animatable;
import com.codecool.boulderdash.entities.Interactable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Player extends GameEntity implements Animatable {

//    private static final double speed = 0.3;
//    private static final float turnRate = 2;
//    private GameEntity tail; // the last element. Needed to know where to add the next part.
//    private int health;

    private char movementDirection;
    private boolean keyPossesed = false;

    public char getMovementDirection() {
        return movementDirection;
    }

    public void setKeyPossesed(boolean keyPossesed) {
        this.keyPossesed = keyPossesed;
    }

    public boolean isKeyPossesed() {
        return keyPossesed;
    }

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
        this.movementDirection = 'r';
        System.out.println(this.movementDirection);
        setX(getX() + Globals.stepMove);
    }

    public void moveLeft() {
        this.movementDirection = 'l';
        System.out.println(this.movementDirection);
        setX(getX() - Globals.stepMove);
    }

    public void moveDown() {
        this.movementDirection = 'd';
        System.out.println(this.movementDirection);
        setY(getY() + Globals.stepMove);
    }

    public void moveUp() {
        this.movementDirection = 'u';
        System.out.println(this.movementDirection);
        setY(getY() - Globals.stepMove);
    }


    public void reverse() {
        System.out.println(this.movementDirection);
        if (this.movementDirection == 'r') {
            this.moveLeft();
        } else if (this.movementDirection == 'l') {
            this.moveRight();
        } else if (this.movementDirection == 'd') {
            this.moveUp();
        } else if (this.movementDirection == 'u') {
            this.moveDown();
        }
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

        if (Globals.upKeyDown) {          // added for trials

            Globals.upKeyDown = false;
            this.moveUp();
        }

        // check if collided with an enemy or a powerup
        for (GameEntity entity : Globals.getGameObjects()) {
            if (getBoundsInParent().intersects(entity.getBoundsInParent())) {
                if (entity instanceof Interactable) {   // each Interactable has apply() method called on collision
                    Interactable interactable = (Interactable) entity;
                    interactable.apply(this);
                    System.out.println(interactable.getMessage());
                }
            }
        }

        // check for game over condition
        if(Globals.diamondCounter == Globals.diamondsInPocket){
                Scene scene = getScene();
                Node endGameId = ((Scene) scene).lookup("#endgame");
                Label endGameLabel = (Label) endGameId;
                System.out.println("Game Over");
                endGameLabel.setText("JOB DONE!!!");
                Globals.gameLoop.stop();

            }
    }
}


