import model.Question;
import model.XmlReader;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.*;



public class XmlReaderTest {
    private XmlReader reader = new XmlReader();
    private ArrayList<Question>questionarray;




    @BeforeEach
    void setup() throws Exception{


        questionarray =reader.XmlRead();


    }

    @Test
    void createQuestionList(){
        assertTrue(questionarray.get(0) instanceof Question);

    }

    @Test
    public void questionReturnsCorrectFields() {
        Question question = questionarray.get(0);
        assertNotNull(question.getQuestion());
        assertNotNull(question.getAnswer1());
        assertNotNull(question.getAnswer2());
        assertNotNull(question.getAnswer3());
        assertNotNull(question.getAnswer4());
        assertNotNull(question.getResult());
    }

    @Test
    public void questionReturnsCorrectData() {
        Question question = questionarray.get(0);
        assertEquals("Mi magyarország fövárosa?", question.getQuestion());
        assertEquals("Budapest", question.getAnswer1());
        assertEquals("Debrecen",question.getAnswer2());
        assertEquals("Mátészalka", question.getAnswer3());
        assertEquals("Balmazújváros",question.getAnswer4());
        assertEquals("answer1",question.getResult());
    }





}
