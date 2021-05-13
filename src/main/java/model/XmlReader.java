package model;

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

public class XmlReader {

    private ArrayList<Question>questionlist = new ArrayList<Question>();
    private static final String FILENAME = "/home/budai/Projects/Quiz/Questions.xml";

    public XmlReader() {
        this.questionlist = questionlist;

    }

    public ArrayList<Question> getQuestionlist() {
        return questionlist;
    }


    public ArrayList<Question> XmlRead(){
        ArrayList<Question>questionlist = new ArrayList<Question>();
        try {


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

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

                    String id = element.getAttribute("id");


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

        return questionlist;
    }

}
