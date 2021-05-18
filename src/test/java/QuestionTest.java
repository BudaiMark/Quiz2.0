import model.Question;
import model.Quiz;
import model.XmlReader;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;



import static org.junit.jupiter.api.Assertions.*;



public class QuestionTest {

    private int random = Question.generateRandomNumber();
    Quiz quiz = new Quiz();


    @Test
    void isChildrenOfArray(){

        assertTrue(quiz.getQuestionarray().get(0) instanceof Question);

    }

    @Test
    void questionArrayNotNull(){
        assertNotNull(quiz.getQuestionarray());

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
        assertTrue(random< quiz.getQuestionarray().size());
    }

    @Test
    public void isItTrueSize() {
        assertFalse(0>quiz.getQuestionarray().size());
    }






}