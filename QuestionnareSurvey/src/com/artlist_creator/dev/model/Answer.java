/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artlist_creator.dev.model;

/**
 *
 * @author Camer
 */
public class Answer {
    private String content;
    private boolean Correct;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isCorrect() {
        return Correct;
    }

    public void setCorrect(boolean Correct) {
        this.Correct = Correct;
    }
    
}
