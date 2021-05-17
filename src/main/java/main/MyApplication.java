package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * A {@code MyApplication} oszttályban az első képernyő megjelenítése, launch.fxml -t betöltjük, adunk neki címet beállítjuk, hogy ne lehessen
 * átméretezni, illetve megjelenítjük.
 *
 */
public class MyApplication extends Application {

    /**
     * A {@code start} felelős a primaryStage megjelenítéséért.
     * @param primaryStage Rajta történik a megjelenítés.
     * @throws Exception Továbbdobjuk a keletkezett kivételt.
     */
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/launch.fxml"));
        primaryStage.setTitle("Quiz");
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

}
