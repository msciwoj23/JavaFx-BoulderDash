package com.codecool.snake;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }   // launch is Application method


    /*
    standard generated code for JavaFx project. start is also a Application method.
    start behaves like main
     */
    @Override
    public void start(Stage primaryStage) {
        Game game = new Game();
        game.setStyle("-fx-background-color: gray");
                                    // ok so Game is instantiated to put it in place of root in new Scene
        primaryStage.setTitle("Snake Game");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.show();
        game.start();               // and to call its start method
    }

}
