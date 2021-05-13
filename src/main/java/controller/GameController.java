package controller;
import javafx.event.ActionEvent;
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

public class GameController {

    private final int startingTime = 5;
    private int seconds = startingTime;
    private int questionCount;
    private Instant beginGame;
    XmlReader reader = new XmlReader();
    ArrayList<Question>questionarray =reader.XmlRead();

    @FXML
    private Label questionLabel;


    @FXML
    private Label score;

    @FXML
    private Label questionnum;

    @FXML
    private Button answer1;

    @FXML
    private Button answer2;

    @FXML
    private Button answer3;

    @FXML
    private Button answer4;


    public int numberofscore= 0;
    public int questionnumber = 1;

    public Question newQuestion(){
        return Question.getoneQuestion(questionarray);
    }

    public void answerclick(MouseEvent mouseEvent) {
        try {
            Thread.sleep(2000);
        }catch(InterruptedException e){
            e.getMessage();
        }
        Question question = newQuestion();
        questionLabel.setText(question.getQuestion());
        answer1.setText(question.getAnswer1());
        answer2.setText(question.getAnswer2());
        answer3.setText(question.getAnswer3());
        answer4.setText(question.getAnswer4());
        score.setText(Integer.toString(numberofscore));
        questionnum.setText(Integer.toString(questionnumber));
        questionnumber++;


    }

    public void initData(){

        Question question = Question.getoneQuestion(questionarray);
        questionLabel.setText(question.getQuestion());
        answer1.setText(question.getAnswer1());
        answer2.setText(question.getAnswer2());
        answer3.setText(question.getAnswer3());
        answer4.setText(question.getAnswer4());
        score.setText(Integer.toString(numberofscore));
        questionnum.setText(Integer.toString(questionnumber));


    }


    @FXML
    public void initialize() {

        initData();

    }




}
