package model;

import java.util.ArrayList;

public class Quiz {
    ArrayList<Question>questionarray;
    private int numberofscore;
    private int questionnumber ;
    private final int QUESTION_LIMIT = 5;
    private final int STARTINGTIME = 2;


    public Quiz(){
        XmlReader reader = new XmlReader();
        questionarray= reader.XmlRead();
        numberofscore=0;
        questionnumber= 1;
    }

    public ArrayList<Question> getQuestionarray() {
        return questionarray;
    }



    public int getNumberofscore() {
        return numberofscore;
    }



    public int getQuestionnumber() {
        return questionnumber;

    }
    public int getQUESTION_LIMIT() {
        return QUESTION_LIMIT;
    }

    public int getSTARTINGTIME() {
        return STARTINGTIME;
    }

    public int incQuestionNumber(int questionnumber){
        return questionnumber+= 1;


    }
    public int incScore(int numberofscore){

        return numberofscore+= 1;

    }

}
