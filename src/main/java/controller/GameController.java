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

/**
 * Ebben az osztályban található a játék logikájának megjelenítése.
 */

public class GameController{

    /**
     * Osztályváltozók, végleges változók létrehozása.
     */
    private final int startingTime = 2;
    private int seconds = startingTime;
    private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black;";
    private static final String GREEN_BUTTON = "-fx-background-color: lightgreen; -fx-border-color: black";
    private static final String RED_BUTTON = "-fx-background-color: red; -fx-border-color: black";
    /**
     * Az xml fájlból beolvasott tartalom kérdéssé egyesített elemeinek listája
     */
    XmlReader reader = new XmlReader();
    ArrayList<Question>questionarray =reader.XmlRead();
    Question globalQuestion;


    /**
     * Az fxml-ben szereplő vizuálisan látható osztályok példányosítása.
     */
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

    @FXML
    private Button showscore;

    /**
     *A kérdés, illetve a pont növelését elősegítő változók.
     */

    public int numberofscore= 0;
    public int questionnumber = 1;

    /**
     * Egy kérdést visszaadó függvény.
     * @return
     */
    public Question newQuestion(){
        return Question.getoneQuestion(questionarray);
    }


    /**
     * A következő függvények a válaszgomb megnyomását követően lefutó függvények(eventek)
     * amikben látható a gomb lekezelése(meg lehessen-e nyomni), továbbá a bizonyos esetek lekezelése
     * pl. Ha jó gombot nyomott le a felhasználó akkor zöld színnel jelezze a játékos részére
     * Ha rossz gombot nyomott meg, akkor az pirossal jelenjen meg a helyes válasz zölddel.
     * Ezt követően meghívjuk a timer függvényt.
     * @param mouseEvent
     */
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

    /**
     * Beállítjuk minden új kérdésnél, hogy nézzen ki a képernyő.
     */
    public void setScreen(){

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

    /**
     * Lekérdezzük a helyes választ abban az esetben, ha a játékos nem találta volna el a kérdést.
     */
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

    /**
     *Beállítjuk a gombok alap vizuális kinézetét.
     */

    public void standardButtonColor(){
        answer1.setStyle(STANDARD_BUTTON);
        answer2.setStyle(STANDARD_BUTTON);
        answer3.setStyle(STANDARD_BUTTON);
        answer4.setStyle(STANDARD_BUTTON);
        showscore.setStyle(STANDARD_BUTTON);
        showscore.setVisible(false);

    }

    /**
     * A timer függvény segít abban hogy a kérdéések között a játkosnak legyen ideje válaszolni, ne egyben fusson le az egész programrész,
     * különben nem látnánk semmit az ereményből. Ehhez használunk egy KeyFrame-et, továbbá az utolsó válasz megadása után látható teszi
     * a gombot, aminek megnyomásával megjelenik az eredmény, a kilépő gomb, illetve egy gomb ami a játékosokat tartalmazza.
     *
     */

    public void timer(){

        questionnumber++;
        Timeline time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        if(time!=null)
            time.stop();
        KeyFrame frame = new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (seconds<=0)
                    time.stop();
                seconds--;
                if(seconds==-1&& questionnumber<6) {

                    setScreen();
                    setEnableButton();
                }else if(!(questionnumber<6)){
                    showscore.setVisible(true);
                }

            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

        seconds = startingTime;
    }

    /**
     * A gombokat elérhetetlenné teszi a felhasználók számára(nem lehet megnyomni).
     * A válaszgomb megnyomását követően történik meg, hogy ne tudjon több scoret kapni a játékos, ugyanazon gomb megnyomásával.
     */
    public void setDisableButton(){
        answer1.setDisable(true);
        answer2.setDisable(true);
        answer3.setDisable(true);
        answer4.setDisable(true);

    }
    /**
     * A gombokat elérhetővé teszi a felhasználók számára(meg lehet nyomni).
     * Minden új kérdés legenerálását követően elérhető a funkció.
     */
    public void setEnableButton(){
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer4.setDisable(false);

    }

    /**
     * A gomb megnyomását követően betölti a következő fxml-t illetve átadja paraméterül a pontoknak a számát.
     *
     * @param actionEvent
     * @throws IOException
     */
    @FXML
    public void loadEnd(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/end.fxml"));
        Parent root = fxmlLoader.load();
        EndController controller = fxmlLoader.getController();
        controller.setScorevalue(score.getText());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();


    }

    /**
     *Betölti a kezdőértékeket, kérdést, illetve a gombokon szereplő válaszokat.
     */

    public void initData(){

        Question question = Question.getoneQuestion(questionarray);
        standardButtonColor();
        showscore.setVisible(false);
        globalQuestion = question;
        questionLabel.setText(question.getQuestion());
        answer1.setText(question.getAnswer1());
        answer2.setText(question.getAnswer2());
        answer3.setText(question.getAnswer3());
        answer4.setText(question.getAnswer4());
        score.setText(Integer.toString(numberofscore));
        questionnum.setText(Integer.toString(questionnumber));



    }

    /**
     * Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize() {

        initData();

    }




}
