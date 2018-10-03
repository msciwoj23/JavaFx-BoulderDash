package com.codecool.snake.entities.powerups;

import com.codecool.snake.Globals;
import com.codecool.snake.entities.GameEntity;
import com.codecool.snake.entities.Interactable;
import com.codecool.snake.entities.snakes.Player;
import javafx.scene.layout.Pane;

public class Diamond extends GameEntity implements Interactable {

    public Diamond(Pane pane, int xc, int yc) {
        super(pane);
        setImage(Globals.powerupDiamond);
        pane.getChildren().add(this);
        setX(xc);
        setY(yc);
    }

    @Override
    public void apply(Player player) {
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got Diamond :)";
    }
}
