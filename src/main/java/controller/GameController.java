package controller;
import com.sun.javafx.scene.control.Properties;
import com.sun.javafx.stage.StageHelper;
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
import javafx.scene.layout.AnchorPane;
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

public class GameController{

    private final int startingTime = 2;
    private int seconds = startingTime;
    private int questionCount;
    private Instant beginGame;
    private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black;";
    private static final String HOVERED_BUTTON = "-fx-background-color: lightgrey; -fx-border-color: black";
    private static final String GREEN_BUTTON = "-fx-background-color: lightgreen; -fx-border-color: black";
    private static final String RED_BUTTON = "-fx-background-color: red; -fx-border-color: black";
    private Stage myStage;
    XmlReader reader = new XmlReader();
    ArrayList<Question>questionarray =reader.XmlRead();
    Question globalQuestion;

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
    public void setStage(Stage stage){
        myStage = stage;
    }


    public void answerclick1(MouseEvent mouseEvent) {
            setDisableButton();
            if(globalQuestion.getResult().equals(answer1.getId())){

                answer1.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();

            }else{
                answer1.setStyle(RED_BUTTON);
                getGreen();
                timer();
            }

    }
    public void answerclick2(MouseEvent mouseEvent) {

            setDisableButton();
            if(globalQuestion.getResult().equals(answer2.getId())){


                answer2.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();


            }else{
                answer2.setStyle(RED_BUTTON);
                getGreen();
                timer();

            }

    }
    public void answerclick3(MouseEvent mouseEvent) {
            setDisableButton();
            if(globalQuestion.getResult().equals(answer3.getId())){

                answer3.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();

            }else{
                answer3.setStyle(RED_BUTTON);
                getGreen();
                timer();
            }
    }
    public void answerclick4(MouseEvent mouseEvent) {
            setDisableButton();
            if(globalQuestion.getResult().equals(answer4.getId())){
                answer4.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();

            }
            else{
                answer4.setStyle(RED_BUTTON);
                getGreen();
                timer();


            }
            

    }

    public void setScreen(){

        questionnumber++;
            if (questionnumber < 6) {
                Question question = newQuestion();
                standardButtonColor();
                globalQuestion = question;
                questionLabel.setText(question.getQuestion());
                answer1.setText(question.getAnswer1());
                answer2.setText(question.getAnswer2());
                answer3.setText(question.getAnswer3());
                answer4.setText(question.getAnswer4());
                questionnum.setText(Integer.toString(questionnumber));

            }

    }

    public void getGreen(){
        if(globalQuestion.getResult().equals("answer1")){
            answer1.setStyle(GREEN_BUTTON);}
        else if(globalQuestion.getResult().equals("answer2")){
            answer2.setStyle(GREEN_BUTTON);}
        else if(globalQuestion.getResult().equals("answer3")){
            answer3.setStyle(GREEN_BUTTON);}
        else {
            answer4.setStyle(GREEN_BUTTON);}



    }


    public void standardButtonColor(){
        answer1.setStyle(STANDARD_BUTTON);
        answer2.setStyle(STANDARD_BUTTON);
        answer3.setStyle(STANDARD_BUTTON);
        answer4.setStyle(STANDARD_BUTTON);
    }


    public void timer(){


        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if(time!=null)
            time.stop();
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                //timeDisplay.setText(String.valueOf(seconds));
                if (seconds<=0)
                    time.stop();
                seconds--;
                if(seconds==-1) {
                    setScreen();
                    setEnableButton();
                }
            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

        seconds = startingTime;
    }

    public void setDisableButton(){
        answer1.setDisable(true);
        answer2.setDisable(true);
        answer3.setDisable(true);
        answer4.setDisable(true);

    }
    public void setEnableButton(){
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer4.setDisable(false);

    }

    public void initData(){

        Question question = Question.getoneQuestion(questionarray);
        standardButtonColor();
        globalQuestion = question;
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
