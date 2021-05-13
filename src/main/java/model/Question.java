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
    /*public Question XmlRead(){
        ArrayList<Question>questionlist = new ArrayList<Question>();
        Random random = new Random();
        int rand = random.nextInt(3);
        System.out.println("A random generált szám: "+rand);
        try {

            // optional, but recommended
            // process XML securely, avoid attacks like XML External Entities (XXE)
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            // parse XML file
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document doc = db.parse(new File(FILENAME));
            doc.getDocumentElement().normalize();

            System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
            System.out.println("------");


            NodeList list = doc.getElementsByTagName("questions");

            for (int temp = 0; temp < list.getLength(); temp++) {

                Node node = list.item(temp);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;

                    // get staff's attribute
                    String id = element.getAttribute("id");

                    // get text
                    String question = element.getElementsByTagName("question").item(0).getTextContent().trim();
                    String answer1 = element.getElementsByTagName("answer1").item(0).getTextContent().trim();;
                    String answer2 = element.getElementsByTagName("answer2").item(0).getTextContent().trim();;
                    String answer3 = element.getElementsByTagName("answer3").item(0).getTextContent().trim();;
                    String answer4 = element.getElementsByTagName("answer4").item(0).getTextContent().trim();;
                    String result = element.getElementsByTagName("result").item(0).getTextContent().trim();;


                    System.out.println("Current Element :" + node.getNodeName());
                    System.out.println("Question Id : " + id);
                    System.out.println("Question : " + question);
                    System.out.println("Answer 1: " + answer1);
                    System.out.println("Answer 2: " + answer2);
                    System.out.println("Answer 3: " + answer3);
                    System.out.println("Answer 4: " + answer4);
                    System.out.println("Result: " + result);
                    questionlist.add(new Question(question, answer1,answer2,answer3,answer4,result));

                }
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        System.out.println("A választott kérdés" + questionlist.get(rand).question);
        System.out.println("ans1  " + questionlist.get(rand).answer1);
        System.out.println("ans2  " + questionlist.get(rand).answer2);
        System.out.println("ans3  " + questionlist.get(rand).answer3);
        System.out.println("ans4  " + questionlist.get(rand).answer4);
        System.out.println("res  " + questionlist.get(rand).result);

        return questionlist.get(rand);
    }*/
}
    
    

