package com.codecool.boulderdash;

import com.codecool.boulderdash.entities.GameEntity;
import javafx.scene.image.Image;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// class for holding all static stuff
public class Globals {

    public static final double WINDOW_WIDTH = 1360;
    public static final double WINDOW_HEIGHT = 768;

    public static final int stepMove = 40;


    public static String[] levelPattern = {
            "ggggggggggggggggggggsggggggggggggs",
            "ggggggsgsggggggggggdgggsgggsgggggs",
            "gggsssgggggggggggggggggggggggggggs",
            "ggsgggggggggggdggggggggsgggsgggggs",
            "gggsgggggsggsggggsgggggggggggggggs",
            "ggsdggsgggggggggggggggdsgggsgggggs",
            "ggggggggsgggsggggggggggsgggsgggggs",
            "ggsgggggggggsgggggggsggsgggsgggggs",
            "ggggggggggggsgdgggggssssssssssssss",
            "ggggggggsgggsgsgggggsggsgggsgggggs",
            "ggggkgggggggggggggggsggsgggsggddgs",
            "ggggggggsgggggggggggsggsgggsggddgs",
            "ggggggggggggggggggggsgdgggggggddgs",
            "ggggggggggggggggggggsggsgggsggddgs",
            "ggggggggggggggggggggsggsgggsgggggs",
            "ggggggggggggggggggggsggsgggsgggggs",
            "gdggggssssggggggggggXggsgggsgggggs",
            "ssssssssssssssssssssssssssssssssss"
    };

    public static Image player = new Image("DiggerRight.png",38,38,true,true);
    public static Image simpleEnemy = new Image("simple_enemy.png");
    public static Image ground = new Image("RockyGround.png");
    public static Image diamond = new Image("Diamond.png");
    public static Image stone = new Image("Stone.png");
    public static Image door = new Image("Door.png");
    public static Image key = new Image("Key.png");
    //.. put here the other images you want to use

    public static boolean leftKeyDown;
    public static boolean rightKeyDown;
    public static boolean downKeyDown;
    public static boolean upKeyDown;
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
