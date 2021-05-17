package model;

import org.tinylog.Logger;
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
     */

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }


    public String getAnswer3() {
        return answer3;
    }


    public String getAnswer4() {
        return answer4;
    }


    public String getResult() {
        return result;
    }



    /**
     * {@code getoneQuestion()}Kérdéslistából kisorsol egy random elemet.
     */
    public static Question getoneQuestion(ArrayList<Question>questionarray){
        Logger.info("Kérdés legenerálása.");
        Random random = new Random();
        int rand = random.nextInt(3);
        return questionarray.get(rand);


    }


}
    
    

