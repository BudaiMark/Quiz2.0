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
import javafx.stage.Stage;
import model.Question;
import model.User;
import model.XmlReader;
import org.tinylog.Logger;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.EventHandler;
import static model.Database.addUsertoDB;

/**
 * {@code GameController()}Ebben az osztályban található a játék logikájának megjelenítése.
 */

public class GameController{

    /**
     * {@code startingTime, seconds, STANDARD_BUTTON, GREEN_BUTTON, RED_BUTTON, QUESTION}Osztályváltozók, végleges változók létrehozása.
     */
    /**
     *{@code numberofscore, questionnumber}A kérdés, illetve a pont növelését elősegítő változók.
     */
    private final int STARTINGTIME = 2;
    private int seconds = STARTINGTIME;
    private static final String STANDARD_BUTTON = "-fx-background-color: transparent; -fx-border-color: black;";
    private static final String GREEN_BUTTON = "-fx-background-color: lightgreen; -fx-border-color: black";
    private static final String RED_BUTTON = "-fx-background-color: red; -fx-border-color: black";
    private final int QUESTION = 1;
    private int numberofscore= 0;
    private int questionnumber = 1;
    /**
     * {@code questionarray}Az xml fájlból beolvasott tartalom kérdéssé egyesített elemeinek listája
     */
    XmlReader reader = new XmlReader();
    ArrayList<Question>questionarray =reader.XmlRead();
    Question globalQuestion;


    /**
     * {@code questionLabel, score, questionnum, answer1, answer2, answer3, answer4}Az fxml-ben szereplő vizuálisan látható osztályok példányosítása.
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
     * {@code username} A username változó lérehozása, {@code setUsername()}beálítása.
     */
    private String username;

    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return Egy kérdést visszaadó függvény.
     */
    public Question newQuestion(){
        Logger.info("Új kérdés legenerálás.");
        return Question.getoneQuestion(questionarray);
    }


    /**
     * {@code answerclick1(), answerclick2(), answerclick3(), answerclick4()}
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
                Logger.info("Első válasz helyes.");
                answer1.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();

            }else{
                Logger.info("Első válasz helytelen.");
                answer1.setStyle(RED_BUTTON);
                getGreen();
                timer();
            }

    }
    public void answerclick2(MouseEvent mouseEvent) {
            setDisableButton();
            if(globalQuestion.getResult().equals(answer2.getId())){

                Logger.info("Második válasz helyes.");
                answer2.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();


            }else{
                Logger.info("Második válasz helytelen.");
                answer2.setStyle(RED_BUTTON);
                getGreen();
                timer();

            }

    }
    public void answerclick3(MouseEvent mouseEvent) {
            setDisableButton();

            if(globalQuestion.getResult().equals(answer3.getId())){
                Logger.info("Harmadik válasz helyes.");
                answer3.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();

            }else{
                Logger.info("Harmadik válasz helytelen.");
                answer3.setStyle(RED_BUTTON);
                getGreen();
                timer();
            }
    }
    public void answerclick4(MouseEvent mouseEvent) {
            setDisableButton();
            if(globalQuestion.getResult().equals(answer4.getId())){
                Logger.info("Negyedik válasz helyes.");
                answer4.setStyle(GREEN_BUTTON);
                numberofscore++;
                score.setText(Integer.toString(numberofscore));
                timer();

            }
            else{
                Logger.info("Negyedik válasz helytelen.");
                answer4.setStyle(RED_BUTTON);
                getGreen();
                timer();


            }
            

    }

    /**
     * {@code setScreen()}Beállítjuk minden új kérdésnél, hogy nézzen ki a képernyő.
     */
    public void setScreen(){

            if (questionnumber < QUESTION+1) {
                Logger.info("Képernyő megjelenítése.");
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
     * {@code getGreen()}Lekérdezzük a helyes választ abban az esetben, ha a játékos nem találta volna el a kérdést.
     */
    public void getGreen(){
        Logger.info("Helyes válasz lekérdezése.");
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
     *{@code standardButtonColor}Beállítjuk a gombok alap vizuális kinézetét.
     */

    public void standardButtonColor(){
        Logger.info("Button-ok vizuális megjelenítésének beállítása.");
        answer1.setStyle(STANDARD_BUTTON);
        answer2.setStyle(STANDARD_BUTTON);
        answer3.setStyle(STANDARD_BUTTON);
        answer4.setStyle(STANDARD_BUTTON);
        showscore.setStyle(STANDARD_BUTTON);
        showscore.setVisible(false);

    }

    /**
     * {@code timer()}A timer függvény segít abban hogy a kérdéések között a játkosnak legyen ideje válaszolni, ne egyben fusson le az egész programrész,
     * különben nem látnánk semmit az ereményből. Ehhez használunk egy KeyFrame-et, továbbá az utolsó válasz megadása után látható teszi
     * a gombot, aminek megnyomásával megjelenik az eredmény, a kilépő gomb, illetve egy gomb ami a játékosokat tartalmazza.
     *
     */

    public void timer(){
        Logger.info("Időzítő meghívása.");
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
                if(seconds==-1&& questionnumber<QUESTION+1) {

                    setScreen();
                    setEnableButton();
                }else if(!(questionnumber<QUESTION+1)){
                    showscore.setVisible(true);
                }

            }
        });
        time.getKeyFrames().add(frame);
        time.playFromStart();

        seconds = STARTINGTIME;
    }

    /**
     * {@code setDisableButton}A gombokat elérhetetlenné teszi a felhasználók számára(nem lehet megnyomni).
     * A válaszgomb megnyomását követően történik meg, hogy ne tudjon több scoret kapni a játékos, ugyanazon gomb megnyomásával.
     */
    public void setDisableButton(){
        Logger.info("Button-ok letiltása.");
        answer1.setDisable(true);
        answer2.setDisable(true);
        answer3.setDisable(true);
        answer4.setDisable(true);

    }
    /**
     * {@code setEnableButton}A gombokat elérhetővé teszi a felhasználók számára(meg lehet nyomni).
     * Minden új kérdés legenerálását követően elérhető a funkció.
     */
    public void setEnableButton(){
        Logger.info("Button-ok engedélyezése.");
        answer1.setDisable(false);
        answer2.setDisable(false);
        answer3.setDisable(false);
        answer4.setDisable(false);

    }

    /**
     * {@code loadEnd()}A gomb megnyomását követően betölti a következő fxml-t illetve átadja paraméterül a pontoknak a számát.
     *
     * @param actionEvent Esemény hatására lefutnak a benne szereplő utasytások.
     * @throws IOException IO kivételt dobhat a függvény.
     */
    @FXML
    public void loadEnd(ActionEvent actionEvent) throws IOException {
        addUsertoDB(new User(username,numberofscore));
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/end.fxml"));
        Parent root = fxmlLoader.load();
        EndController controller = fxmlLoader.getController();
        controller.setScorevalue(score.getText());
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
        stage.show();
        Logger.info("EndController, end.fxml betöltése");


    }

    /**
     *{@code initData()}Betölti a kezdőértékeket, kérdést, illetve a gombokon szereplő válaszokat.
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
        Logger.info("GameController kezdő értékeinek beállítása.");


    }

    /**
     * {@code initialize()}Ez a metódus fut le először, a konstruktorhoz nagyon hasonló, azonban innen elérjük az fxml fájl tagjait.
     */
    @FXML
    public void initialize() {

        initData();
        Logger.info("GameController betöltése sikeres.");

    }




}
