package com.codecool.snake.entities.powerups;

import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.Globals;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.SnakeHead;
import javafx.scene.layout.Pane;

import java.util.Random;

// a simple powerup that makes the snake grow TODO make other powerups
public class SimplePowerup extends GameEntity implements Interactable {

    public SimplePowerup(Pane pane, int xc, int yc) {
        super(pane);
        setImage(Globals.powerupBerry);
        pane.getChildren().add(this);

        setX(xc);
        setY(yc);

//        Random rnd = new Random();                            disabled to make regular 10*10 berry table
//        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
//        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(SnakeHead snakeHead) {
        // snakeHead.addPart(4);                        apply gets triggered in SnakeHead. Disabled for trials
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
