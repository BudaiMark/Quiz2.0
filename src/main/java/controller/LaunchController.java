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
 * {@code LaunchController}A screen-en meggjelenő vizuális eszközökkel történő műveletek, események itt történnek kezelésre(eventek), továbbá
 * itt tudunk módosítani a képernyő tartalmán.
 *
 */

@Slf4j
public class LaunchController {
    /**
     * {@code STANDARDRD}Alapvető érték definiálása a gombok számára
     */
    private static final String STANDARD= "-fx-background-color: transparent; -fx-border-color: black;";

    /**
     * {@code playerTextfield, errorLabel, startButton} A képernyőn látható vizuális eszközök példányosítása, az fxml-ből érjük el id alapján
     */


    @FXML
    private TextField playerTextfield;


    @FXML
    private Label errorLabel;

    @FXML
    private Button startButton;

    private String username;

    public String getUsername() {
        return username;
    }

    /**
     * Egy gomb megnyomásának hatására lefut a metódus amiben egy mezőt vizsgálunk, hogy üres-e,
     * illetve betöltjük az új fxml-t.
     * @param actionEvent A gombhoz tartozó esemény.
     * @throws IOException A lefutása közben adódó Input-Output kivétel.
     */

    public void startAction(ActionEvent actionEvent) throws IOException {
        if (playerTextfield.getText().isEmpty()) {
            errorLabel.setText("Játékos neve üres");
        }


        if (!playerTextfield.getText().isEmpty()){
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/game.fxml"));
            Parent root = fxmlLoader.load();
            GameController controller = fxmlLoader.getController();
            controller.setUsername(playerTextfield.getText());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();

        }
    }

    /**
     * {@code initialize}Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize(){


        startButton.setStyle(STANDARD);
        playerTextfield.setStyle(STANDARD);


    }

}
