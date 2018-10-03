package com.codecool.snake.entities;

import com.codecool.snake.entities.snakes.Player;

// interface that all game objects that can be interacted with must implement.
public interface Interactable {

    void apply(Player player);

    String getMessage();

}
