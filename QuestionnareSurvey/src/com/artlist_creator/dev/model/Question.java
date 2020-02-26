/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artlist_creator.dev.model;

import com.artlist_creator.dev.model.Answer;
import java.util.ArrayList;

/**
 *
 * @author Camer
 */
public class Question {
    private int id;
    private String content;
    private ArrayList<Answer> answers = new ArrayList<>();
    
    public boolean isMultipleChoice()
    {
        int count = 0;
        for (Answer answer : answers) {
            count+= (answer.isCorrect())?1:0;
        }
        return count > 1;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }
    
}
