package com.zzxx.exam.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Question对象代表一道试题。
 * 包含题干和四个选项以及正确答案
 *
 * @author Bonnie
 */
public class Question implements Serializable {
    // 难度级别 1~10
    public static final int LEVEL1 = 1;
    public static final int LEVEL2 = 2;
    public static final int LEVEL3 = 3;
    public static final int LEVEL4 = 4;
    public static final int LEVEL5 = 5;
    public static final int LEVEL6 = 6;
    public static final int LEVEL7 = 7;
    public static final int LEVEL8 = 8;
    public static final int LEVEL9 = 9;
    public static final int LEVEL10 = 10;
    // 单选题
    public static final int SINGLE_SELECTION = 0;
    // 多选题
    public static final int MULTI_SELECTION = 1;

    private int id;
    private String title;// 题干
    private List<String> options = new ArrayList<String>();// 若干选项
    private List<Integer> answers = new ArrayList<Integer>();// 正确答案
    private int score;// 分数
    private int level;// 难度级别
    private int type; // 类型: 单选 SINGLE_SELECTION /多选 MULTI_SELECTION

    public Question() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Integer> getAnswers() {
        return answers;
    }

    public List<String> getOptions() {
        return options;
    }

    public void setOptions(List<String> options) {
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setAnswers(List<Integer> answers) {
        this.answers = answers;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(title + "\n");
        for (int i = 0; i < options.size(); i++) {
            sb.append((char) (i + 'A') + "." + options.get(i) + "\n");
        }

        sb.append("\n");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return id == question.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
