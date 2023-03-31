package org.trivial.vector;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.trivial.view.Window;

public class App extends Application {

    @Override
    public void start(Stage stage) {
        setStageSettings(stage);
        stage.show();
    }

    private static Scene getScene() {
        return new Scene(new Window(), Constants.WINDOW_WIDTH, Constants.WINDOW_HEIGHT);
    }

    private static void setStageSettings(Stage stage) {
        stage.setScene(getScene());
        stage.setMinWidth(Constants.WINDOW_WIDTH);
        stage.setMinHeight(Constants.WINDOW_HEIGHT);
    }

    public static void main(String[] args) {
        launch();
    }

}
