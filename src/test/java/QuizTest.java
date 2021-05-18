
import model.Quiz;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTest {
    Quiz quiz = new Quiz();

    @Test
    public void isItTrueSize() {
        assertFalse(0>quiz.getQuestionarray().size());
    }

    @Test
    public void isItIncrement() {
        assertTrue(1==quiz.incScore(quiz.getNumberofscore()));
    }

    @Test
    public void isItQuestionNumber() {
        assertTrue(2==quiz.incQuestionNumber(quiz. getQuestionnumber()));
    }
    @Test
    void questionArrayNotNull(){
        assertNotNull(quiz.getQuestionarray());

    }
    @Test
    void numberOfScoreNotNull(){
        assertNotNull(quiz.getNumberofscore());

    }

    @Test
    void numberOfQuestions(){
        assertNotNull(quiz.getQuestionnumber());

    }
    @Test
    public void isNegativeScore() {
        assertFalse(quiz.getNumberofscore()<0 );
    }
    @Test
    public void isNegativeQuestionNumber() {
        assertFalse(quiz.getQuestionnumber()<0 );
    }





}
