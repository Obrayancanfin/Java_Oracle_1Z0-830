package org.example.demojee;

import java.util.Arrays;
import java.util.HashMap;

public class Question {
    private HashMap<String,String> question;
    private String[] answer ;
    private boolean isCorrect = false;
    private String proposedAnswer="";

    public Question(HashMap<String, String> question , String answer,boolean isCorrect) {
        this.question = question;
        this.answer = new String[]{answer};
        this.isCorrect = isCorrect;
    }

    public String getQuestion() {
        String statement = "";
        for ( String key : this.question.keySet() ) {
            statement = key;
        }
        return statement;

    }

    public void setQuestion(HashMap<String, String> question) {
        this.question = question;
    }

    public String[] getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = new String[]{answer};
    }

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public void answeringQuestion(String proposedAnswer){
        if (this.question.get(getQuestion()).equals(proposedAnswer)){
            this.setCorrect(true);
        }


    }

    public String getProposedAnswer() {
        return proposedAnswer;
    }

    public void setProposedAnswer(String proposedAnswer) {
        this.proposedAnswer = proposedAnswer;
    }

    @Override
    public String toString() {
        return getQuestion()+
                "\n reponse : " + Arrays.toString(answer) +
                "Reponse ? ";
    }
}
