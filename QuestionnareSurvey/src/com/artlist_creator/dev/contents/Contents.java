/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.artlist_creator.dev.contents;

import com.artlist_creator.dev.model.*;
import java.util.ArrayList;

/**
 *
 * @author Camer
 */
public class Contents {
    
    public ArrayList<Question> getData()
    {
        ArrayList<Question> questions = new ArrayList<>();
        Question q1 = new Question();
        q1.setId(1);
        q1.setContent("Who is the most handsome guy in the school?");
        Answer q1_a1 = new Answer();
        q1_a1.setContent("Mr Son");
        q1_a1.setCorrect(true);
        q1.getAnswers().add(q1_a1);
        Answer q1_a2 = new Answer();
        q1_a2.setContent("Mr Long");
        q1_a2.setCorrect(false);
        q1.getAnswers().add(q1_a2);
        Answer q1_a3 = new Answer();
        q1_a3.setContent("Mr Nam");
        q1_a3.setCorrect(false);
        q1.getAnswers().add(q1_a3);
        questions.add(q1);
        
        Question q2 = new Question();
        q2.setId(2);
        q2.setContent("Who have more than one million dollar in the school?");
        Answer q2_a1 = new Answer();
        q2_a1.setContent("Mr Son");
        q2_a1.setCorrect(true);
        q2.getAnswers().add(q2_a1);
        Answer q2_a2 = new Answer();
        q2_a2.setContent("Mr Long");
        q2_a2.setCorrect(true);
        q2.getAnswers().add(q2_a2);
        Answer q2_a3 = new Answer();
        q2_a3.setContent("Mr Nam");
        q2_a3.setCorrect(false);
        q2.getAnswers().add(q2_a3);
        Answer q2_a4 = new Answer();
        q2_a4.setContent("Mr Tung");
        q2_a4.setCorrect(false);
        q2.getAnswers().add(q2_a4);
        questions.add(q2);

        return questions;
    }   
}
