import model.Question;
import model.XmlReader;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;



import static org.junit.jupiter.api.Assertions.*;



public class QuestionTest {
    private XmlReader reader = new XmlReader();
    private ArrayList<Question>questionarray;
    private int random = Question.generateRandomNumber();




    @BeforeEach
    void setup() throws Exception{

        questionarray =reader.XmlRead();

    }

    @Test
    void isChildrenOfArray(){

        assertTrue(questionarray.get(0) instanceof Question);

    }

    @Test
    void questionArrayNotNull(){
        assertNotNull(questionarray);

    }

    @Test
    public void isAnInteger() {
        assertTrue(((Integer) random) instanceof Integer );
    }

    @Test
    public void isNegative() {
        assertFalse(random<0 );
    }

    @Test
    public void isItChoosable() {
        assertTrue(random< questionarray.size());
    }






}