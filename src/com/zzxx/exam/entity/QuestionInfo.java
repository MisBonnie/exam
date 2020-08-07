package com.zzxx.exam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * 问题和用户答案的值对象,
 * 表示界面上的一道题和对应的用户答案
 * 是值对象
 *
 * @author Bonnie
 */
public class QuestionInfo implements Serializable {
    // 考题
    private Question question;
    // 在试卷(paper)中的序号 0,1,2
    private int questionIndex;
    // 用户答案
    private List<Integer> userAnswers = new ArrayList<Integer>();

    public QuestionInfo() {
    }

    public QuestionInfo(int questionIndex, Question question) {
        this.question = question;
        this.questionIndex = questionIndex;
    }

    public QuestionInfo(int questionIndex, Question question, List<Integer> userAnswers) {
        super();
        this.question = question;
        this.userAnswers = userAnswers;
        this.questionIndex = questionIndex;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public List<Integer> getUserAnswers() {
        return userAnswers;
    }

    public void setUserAnswers(List<Integer> userAnswers) {
        this.userAnswers = userAnswers;
    }

    public int getQuestionIndex() {
        return questionIndex;
    }

    public void setQuestionIndex(int questionIndex) {
        this.questionIndex = questionIndex;
    }

    @Override
    public String toString() {
        return question.toString();
    }
}