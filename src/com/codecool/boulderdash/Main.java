package com.codecool.boulderdash;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.paint.Color;

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
        primaryStage.setTitle("Boulder Dash");
        primaryStage.setScene(new Scene(game, Globals.WINDOW_WIDTH, Globals.WINDOW_HEIGHT));
        primaryStage.setFullScreen(true);
        Label endGame = new Label();
        endGame.setFont(new Font(100));
        endGame.setTextFill(Color.web("rgb(255,255,0)"));
        endGame.setTranslateX(450);
        endGame.setTranslateY(300);
        endGame.setId("endGame");
        game.getChildren().add(endGame);
        primaryStage.show();
        game.start();               // and to call its start method
    }

}
