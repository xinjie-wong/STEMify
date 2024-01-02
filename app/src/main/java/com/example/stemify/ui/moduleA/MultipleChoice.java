package com.example.stemify.ui.moduleA;

import java.util.ArrayList;
import java.util.List;

public class MultipleChoice extends Question{
    List<String> listOfAnswers;

    public MultipleChoice() {
        super();
        this.listOfAnswers = new ArrayList<String>();
    }

    public MultipleChoice(String questionDesc){
        super(questionDesc);
        this.listOfAnswers = new ArrayList<String>();
    }

    public List<String> getListOfAnswers() {
        return listOfAnswers;
    }

    public void setListOfAnswers(List<String> listOfAnswers) {
        this.listOfAnswers = listOfAnswers;
    }

    public void addAnswer(String answer){
        if (listOfAnswers != null) {
            listOfAnswers.add(answer);
        } else {
            // Handle the case where the list is null (possibly log an error)
        }
    }
}
