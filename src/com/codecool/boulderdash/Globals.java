package com.codecool.boulderdash;

import com.codecool.boulderdash.entities.GameEntity;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 800;
    public static final double WINDOW_HEIGHT = 800;


    public static String[] levelPattern = {
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg",
            "ggddssgggggggggggggggggg"
    };

    public static Image player = new Image("DiggerRight.png",38,38,true,true);
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image ground = new Image("RockyGround.png");
    public static Image diamond = new Image("Diamond.png");
    public static Image stone = new Image("Stone.png");
    //.. put here the other images you want to use

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static boolean downKeyDown;
    public static List<GameEntity> gameObjects;
    public static List<GameEntity> newGameObjects; // Holds game objects crated in this frame.
    public static List<GameEntity> oldGameObjects; // Holds game objects that will be destroyed this frame.
    public static GameLoop gameLoop;

    static {
        gameObjects = new LinkedList<>();
        newGameObjects = new LinkedList<>();
        oldGameObjects = new LinkedList<>();
    }

    public static void addGameObject(GameEntity toAdd) {
        newGameObjects.add(toAdd);
    }

    public static void removeGameObject(GameEntity toRemove) {
        oldGameObjects.add(toRemove);
    }

    public static List<GameEntity> getGameObjects() {
        return Collections.unmodifiableList(gameObjects);
    }
}
