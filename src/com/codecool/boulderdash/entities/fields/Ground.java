package com.codecool.boulderdash.entities.fields;

import com.codecool.boulderdash.entities.GameEntity;
import com.codecool.boulderdash.Globals;
import com.codecool.boulderdash.entities.Interactable;
import com.codecool.boulderdash.entities.player.Player;
import javafx.scene.layout.Pane;

// a simple powerup that makes the boulderdash grow TODO make other fields
public class Ground extends GameEntity implements Interactable {

    public Ground(Pane pane, int xc, int yc) {
        super(pane);
        setImage(Globals.ground);
        pane.getChildren().add(this);

        setX(xc);
        setY(yc);

//        Random rnd = new Random();                            disabled to make regular 10*10 berry table
//        setX(rnd.nextDouble() * Globals.WINDOW_WIDTH);
//        setY(rnd.nextDouble() * Globals.WINDOW_HEIGHT);
    }

    @Override
    public void apply(Player player) {
        // player.addPart(4);                        apply gets triggered in Player. Disabled for trials
        destroy();
    }

    
    @Override
    public String getMessage() {
        return "Got power-up :)";
    }
}
