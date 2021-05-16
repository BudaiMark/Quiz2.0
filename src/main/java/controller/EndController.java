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
@Slf4j
public class EndController {
    private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black;";
    private String scorevalue;

    @FXML
    private Label score;

    @FXML
    private Button quitButton;

    @FXML
    private Button dataBaseButton;



    public String getScorevalue() {
        return scorevalue;
    }
    public void setScorevalue(String scorevalue) {
        this.scorevalue = scorevalue;
        score.setText(scorevalue);
    }

    @FXML
    public void quitGame(ActionEvent actionEvent) throws IOException{

        Platform.exit();

    }

    @FXML
    public void initialize(){
        quitButton.setStyle(STANDARD_BUTTON);
        dataBaseButton.setStyle(STANDARD_BUTTON);

    }





}
