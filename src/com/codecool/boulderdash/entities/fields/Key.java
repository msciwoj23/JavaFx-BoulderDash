package com.codecool.boulderdash.entities.fields;

import com.codecool.boulderdash.Globals;
import com.codecool.boulderdash.entities.GameEntity;
import com.codecool.boulderdash.entities.Interactable;
import com.codecool.boulderdash.entities.player.Player;
import javafx.scene.layout.Pane;

public class Key extends GameEntity implements Interactable {
    public Key (Pane pane, int xc, int yc) {
        super(pane);
        setImage(Globals.key);
        pane.getChildren().add(this);

        setX(xc);
        setY(yc);

    }

    @Override
    public void apply(Player player) {
        player.setKeyPossesed(true);
        destroy();
    }

    @Override
    public String getMessage() {
        return "Got key :)";
    }
}
