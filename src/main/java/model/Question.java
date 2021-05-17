package model;
import lombok.AllArgsConstructor;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import lombok.extern.slf4j.Slf4j;

/**
 * Kérdés felépítését megvalósító osztály.
 */

@Slf4j
public class Question {

    /**
     * Kérdést felépítő adattagokat tároló változók.
     */
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String result;

    /**
     * Az osztály konstruktora példány létrehozásakor a felsorolt paramétereket várja.
     * @param question Kérdés.
     * @param answer1 Első válasz.
     * @param answer2 Második válasz.
     * @param answer3 Harmadik válasz.
     * @param answer4 Negyedik válasz.
     * @param result Eredmény.
     */
    public Question(String question, String answer1,String answer2,String answer3,String answer4,String result){
        this.question  = question;
        this.answer1  = answer1;
        this.answer2  = answer2;
        this.answer3  = answer3;
        this.answer4  = answer4;
        this.result  = result;

    }
    /**
     *  {@code Question()}Üres konstruktor.
     */
    public Question() {

    }

    /**
     *{@code getoneQuestion(), getAnswer1(),getAnswer2(),getAnswer3(),getAnswer4(),getResult}Getter metódusok az osztályváltozókhoz.
     *{@code setoneQuestion(), setAnswer1(),setAnswer2(),setAnswer3(),setAnswer4(),setResult}Setter metódusok az osztályváltozókhoz.
     */

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    /**
     * {@code getoneQuestion()}Kérdéslistából kisorsol egy random elemet.
     */
    public static Question getoneQuestion(ArrayList<Question>questionarray){
        Random random = new Random();
        int rand = random.nextInt(3);
        return questionarray.get(rand);


    }

}
    
    

