package com.zzxx.exam.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 实体数据管理, 用来读取数据文件放到内存集合当中
 * 模拟数据库
 */
public class EntityContext {
    // key - 用户的编号id, value - 用户对象
    private Map<String, User> users = new HashMap<>();
    // key - 试题的难度级别, value-难度级别对应的所有试题
    private Map<Integer, List<Question>> questions = new HashMap<>();
    /**
     * 读取user.txt文件, 将其中的数据, 封装为用户对象, 然后存储到集合中
     */
    public void loadUsers(String filename) {

    }
    /**
     * 读取corejava.txt文件, 将其中的数据封装为Question对象, 存储到集合中
     */
    public void loadQuestions(String filename) {

    }

    public Map<String, User> getUsers() {
        return users;
    }

    public Map<Integer, List<Question>> getQuestions() {
        return questions;
    }
}
