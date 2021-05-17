package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.tinylog.Logger;
import java.io.IOException;



import lombok.extern.slf4j.Slf4j;


/**
 * {@code EndController}Ebben az osztályban az eredmény megjelenítés, a kilépő fukció, illetve a korábbi eredmények megtekintése opciója van lekezelve.
 *
 */
@Slf4j
public class EndController {


    /**
     * {@code STANDARD,scorevalue}Osztályváltozók, végleges változók létrehozása.
     */
    private static final String STANDARD = "-fx-background-color: transparent; -fx-border-color: black;";
    private String scorevalue;

    /**
     * {@code score,quitButton,dataBaseButton}Az fxml-ben szereplő vizuálisan látható osztályok példányosítása.
     */
    @FXML
    private Label score;

    @FXML
    private Button quitButton;

    @FXML
    private Button dataBaseButton;

    /**
     * {@code setScorevalue()}Setter metódus a score értékének beállításához, erre van szükség, hogy az előző kontrollerben szereplő adatot
     * megjelenítsünk ezen a képernyőn is.
     *
     */

    public void setScorevalue(String scorevalue) {
        this.scorevalue = scorevalue;
        score.setText(scorevalue);
    }

    /**
     * {@code quitGame()}A kilépő  funkciónak a megvalósítása.
     * @param actionEvent Esemény hatására lefutnak a benne szereplő utasytások.
     * @throws IOException IO kivételt dobhat.
     */
    @FXML
    public void quitGame(ActionEvent actionEvent) throws IOException{
        Logger.info("Bezáródik a Quiz.");
        Platform.exit();

    }

    /**
     * Átvált az adatbázist megjelenítő képernyőre.
     * @param actionEvent Esemény hatására történik a cselekvés.
     * @throws IOException IO kivétel dobódhat.
     */
    @FXML
    public void swichDataBase(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/score.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("Az adatbázis megjelenítő képernyő betöltődik.");

    }

    /**
     * {@code initialize()}Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize(){
        quitButton.setStyle(STANDARD);
        dataBaseButton.setStyle(STANDARD);
        Logger.info("Betöltődik az EndController initialize() függvényben szereplő Button vizuális beállítás.");

    }





}
