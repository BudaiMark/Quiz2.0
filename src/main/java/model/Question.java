package model;
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

@Slf4j
public class Question {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String result;

    private static final String FILENAME = "/home/budai/Projects/Quiz/Questions.xml";

    public Question(String question, String answer1,String answer2,String answer3,String answer4,String result){
        this.question  = question;
        this.answer1  = answer1;
        this.answer2  = answer2;
        this.answer3  = answer3;
        this.answer4  = answer4;
        this.result  = result;

    }

    public Question() {

    }

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

    public static Question getoneQuestion(ArrayList<Question>questionarray){
        Random random = new Random();
        int rand = random.nextInt(3);
        return questionarray.get(rand);


    }

}
    
    

