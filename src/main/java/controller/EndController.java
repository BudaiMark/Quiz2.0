package controller;
import com.sun.javafx.scene.control.Properties;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Question;
import model.XmlReader;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Element;




import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javafx.fxml.FXML;

import javax.net.ssl.X509KeyManager;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;


import org.w3c.dom.Element;
import java.io.File;
import java.util.Random;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


import lombok.extern.slf4j.Slf4j;

import java.time.Instant;

/**
 * Ebben az osztályban az eredmény megjelenítés, a kilépő fukció, illetve a korábbi eredmények megtekintése opciója van lekezelve.
 *
 */
@Slf4j
public class EndController {


    /**
     * Osztályváltozók, végleges változók létrehozása.
     */
    private static final String STANDARD = "-fx-background-color: transparent; -fx-border-color: black;";
    private String scorevalue;

    /**
     * Az fxml-ben szereplő vizuálisan látható osztályok példányosítása.
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

        Platform.exit();

    }

    @FXML
    public void swichDataBase(ActionEvent actionEvent) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/score.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();

    }

    /**
     * {@code initialize()}Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize(){
        quitButton.setStyle(STANDARD);
        dataBaseButton.setStyle(STANDARD);


    }





}
