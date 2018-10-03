package com.codecool.boulderdash.entities;

import com.codecool.boulderdash.entities.player.Player;

// interface that all game objects that can be interacted with must implement.
public interface Interactable {

    void apply(Player player);

    String getMessage();

}
