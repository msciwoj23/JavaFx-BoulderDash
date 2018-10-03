package com.codecool.snake.entities.snakes;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Animatable;
import com.codecool.snake.Utils;
import com.codecool.snake.entities.Interactable;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SnakeHead extends GameEntity implements Animatable {

    private static final double speed = 0.3;
    private static final float turnRate = 2;
    private GameEntity tail; // the last element. Needed to know where to add the next part.
    private int health;


    /*
    so: Game is instantiated in Main.start() ,
    When Game is instantiated in its constructor instantiates some game entities SnakeHead included.
     */
    public SnakeHead(Pane pane, int xc, int yc) {
        super(pane);        // this calls superclass constructor and triggers [Globals.addGameObject(this);] within
        setX(xc);
        setY(yc);
        health = 100;
        tail = this;
        setImage(Globals.snakeHead);
        pane.getChildren().add(this);

        // addPart(4);      disabled SnakeBody init and placement
    }


    /*
    added my own method so SnakeHead moves only if key pressed
     */
    public void moveRight() {
//
        setX(getX() + 40);
//
    }

    public void moveLeft() {

        setX(getX() - 40);
    }

    public void moveDown() {

        setY(getY() + 40);
    }

    /*
    ok so: I can not find the source of getRotate() and setRotate()
     */
    public void step() {                // step is called in GameLoop in handle
             // great. i cant find source of getRotate() method.
        if (Globals.leftKeyDown) {

            Globals.leftKeyDown = false;
            Globals.snakeHead = new Image("DiggerLeft.png",38,38,true,true);
            setImage(Globals.snakeHead);
            this.moveLeft();
        }

        if (Globals.rightKeyDown) {

            Globals.rightKeyDown = false;

            Globals.snakeHead = new Image("DiggerRight.png",38,38,true,true);
            setImage(Globals.snakeHead);
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
        if (isOutOfBounds() || health <= 0) {
            System.out.println("Game Over");
            Globals.gameLoop.stop();
        }
    }
}


