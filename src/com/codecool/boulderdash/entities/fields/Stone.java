package com.codecool.boulderdash.entities.fields;

import com.codecool.boulderdash.Globals;
import com.codecool.boulderdash.entities.GameEntity;
import com.codecool.boulderdash.entities.Interactable;
import com.codecool.boulderdash.entities.player.Player;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Stone extends GameEntity implements Interactable  {



    public Stone(Pane pane, int xc, int yc) {
        super(pane);
        setImage(new  Image("Stone.png",38,38,true,true));
        pane.getChildren().add(this);

        setX(xc);
        setY(yc);

    }



    @Override
    public void apply(Player player) {
        // getPushed(player.getMovementDirection());
        player.reverse();
    }

    public void getPushed(char direction) {
        if (direction == 'l') {
            setX(getX() - Globals.stepMove);
        } else if (direction == 'r') {
            setX(getX() + Globals.stepMove);
        }
    }


    @Override
    public String getMessage() {
        return "Got stone :)";
    }
}
