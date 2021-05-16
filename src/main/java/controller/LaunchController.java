package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
/**
 *
 * A screen-en meggjelenő vizuális eszközökkel történő műveletek, események itt történnek kezelésre(eventek), továbbá
 * itt tudunk módosítani a képernyő tartalmán
 *
 */

@Slf4j
public class LaunchController {
    /**
     * Alapvető érték definiálása a gombok számára
     */
    private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black;";

    /**
     * A képernyőn látható vizuális eszközök példányosítása, az fxml-ből érjük el id alapján
     */


    @FXML
    private TextField playerTextfield;


    @FXML
    private Label errorLabel;

    @FXML
    private Button startButton;


    /**
     * Egy gomb megnyomásának hatására lefut a metódus amiben egy mezőt vizsgálunk, hogy üres-e,
     * illetve betöltjük az új fxml-t.
     * @param actionEvent
     * @throws IOException
     */

    public void startAction(ActionEvent actionEvent) throws IOException {
        if (playerTextfield.getText().isEmpty()) {
            errorLabel.setText("Játékos neve üres");
        }


        if (!playerTextfield.getText().isEmpty()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
            Parent root = fxmlLoader.load();
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }

    /**
     * Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize(){


        startButton.setStyle(STANDARD_BUTTON);


    }

}
