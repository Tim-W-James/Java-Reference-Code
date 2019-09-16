package JavaExamples.JavaFX;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class SimpleWindow extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // create the root stack pane
        primaryStage.setTitle("Hello world!");
        StackPane root = new StackPane();

        // create label and add to root
        Label helloLabel = new Label("Hello world!");
        root.getChildren().add(helloLabel);

        // set scene of stage with size 300x300 and show the stage
        primaryStage.setScene(new Scene(root, 300, 300));
        primaryStage.show();
    }
}

