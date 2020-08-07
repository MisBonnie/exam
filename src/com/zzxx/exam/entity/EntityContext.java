package com.zzxx.exam.entity;

import com.zzxx.exam.util.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体数据管理, 用来读取数据文件放到内存集合当中
 * 模拟数据库
 */
public class EntityContext {
    private Config config;
    // key - 用户的编号id, value - 用户对象
    private Map<Integer, User> users = new HashMap<>();
    // key - 试题的难度级别, value-难度级别对应的所有试题
    private Map<Integer, List<Question>> questions = new HashMap<>();

    public EntityContext() {
        this.config = new Config("config.properties");
        loadUsers(config.getString("UserFile"));
        loadQuestions(config.getString("QuestionFile"));
    }

    /**
     * 读取user.txt文件, 将其中的数据, 封装为用户对象, 然后存储到集合中
     */
    private void loadUsers(String filename) {

    }

    /**
     * 读取corejava.txt文件, 将其中的数据封装为Question对象, 存储到集合中
     * Map<Integer, List<Question>> questions
     */
    private void loadQuestions(String filename) {
        // 6行是一个试题对象 Question  question.getLevel()
        Question question = new Question();
        // 解析文件 字符串, 将question属性赋值
        int level = question.getLevel();
        List<Question> list = this.questions.get(level);
        // 说明难度级别的试题是第一次出现, 创建一个新的列表
        if (list == null) {
            list = new ArrayList<>();
            questions.put(level, list);
        }
        list.add(question);
    }
    // 根据用户id, 从数据库中查询用户对象
    public User findUserById(Integer id) {
        return users.get(id);
    }
    // 根据试题的难度级别, 获得对应难度级别的试题列表
    public List<Question> findQuestionsByLevel(int level) {
        return null;
    }
}
