package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * Az első képernyő megjelenítése, launch.fxml -t betöltjük, adunk neki címet beállítjuk, hogy ne lehessen
 * átméretezni, illetve megjelenítjük.
 *
 */
public class MyApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/launch.fxml"));
        primaryStage.setTitle("Quiz");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
