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
import java.net.URL;
import java.util.ArrayList;

/**
 * Az Xml beolvasást végző osztály.
 */
public class XmlReader {

    /**
     * Itt történik a tényleges beolvasás egy ArrayList-el térünk vissza, ami a kérdéseket tartalmazza.
     * Tag-ek illetve id-k alapján történik az adatok szétválasztása.
     * @return
     */

    public ArrayList<Question> XmlRead(){
        ArrayList<Question>questionlist = new ArrayList<Question>();
        try {


            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            dbf.setFeature(XMLConstants.FEATURE_SECURE_PROCESSING, true);

            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(getClass().getResourceAsStream("/xml/questions.xml"));

            doc.getDocumentElement().normalize();



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


                    questionlist.add(new Question(question, answer1,answer2,answer3,answer4,result));

                }
            }


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

        return questionlist;
    }

}
