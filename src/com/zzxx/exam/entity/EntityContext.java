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
        try {
            InputStream inputStream = EntityContext.class.getClassLoader().getResourceAsStream(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = in.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("#") || line.equals("")) {
                    continue;// 忽略空行和注释(#)
                }
                User one = parseUser(line);
                users.put(one.getId(), one);
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 将读取的用户信息，解析成用户对象
     * 1001:陈贺贺:1234:13810381038:chenhh@zzxx.com.cn
     */
    private User parseUser(String line) {
        String[] data = line.split(":");
        User user = new User();
        user.setId(Integer.parseInt(data[0]));
        user.setName(data[1]);
        user.setPassword(data[2]);
        user.setPhone(data[3]);
        user.setEmail(data[4]);
        return user;
    }

    /**
     * 读取corejava.txt文件, 将其中的数据封装为Question对象, 存储到集合中
     * Map<Integer, List<Question>> questions
     */
    private void loadQuestions(String filename) {
        // 6行是一个试题对象 Question  question.getLevel()
        try {
            InputStream inputStream = EntityContext.class.getClassLoader().getResourceAsStream(filename);
            BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            while ((str = in.readLine()) != null) {
                str = str.trim();
                if (str.equals("") || str.startsWith("#")) {
                    continue;
                }
                // 解析文件 字符串, 将question属性赋值
                // 解析流信息到 Question 对象
                Question q = parseQuestion(str, in);
                addQuestion(q); // 添加到集合
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    /**
     * 向questions集合中，添加试题
     */
    private void addQuestion(Question q) {
        int level = q.getLevel();
        List<Question> list = questions.get(level);
        // 说明难度级别的试题是第一次出现, 创建一个新的列表
        if (list == null) {
            list = new ArrayList<Question>();
            questions.put(level, list);
        }
        list.add(q);
    }

    /**
     * 将读取的试题信息，解析成试题对象
     *
     * @answer=2/3,score=5,level=5 指出下面语句没有编译错误的是:
     * long n = 999999999999;
     * int n = 999999999999L;
     * long n = 999999999999L;
     * double n = 999999999999;
     */
    private Question parseQuestion(String str, BufferedReader in) throws IOException {
        String[] data = str.split("[@,][a-z]+=");
        // str: @answer=2/3,score=5,level=5
        // 以上字符串 切为: 如下结果
        // data:{"","2/3","5","5"}
        Question q = new Question();
        q.setAnswers(parseAnswer(data[1]));
        q.setScore(Integer.parseInt(data[2]));
        q.setLevel(Integer.parseInt(data[3]));
        q.setTitle(in.readLine());// 读取题干
        List<String> options = new ArrayList<>();
        options.add(in.readLine());// 连续读取4个选项
        options.add(in.readLine());
        options.add(in.readLine());
        options.add(in.readLine());
        q.setOptions(options);
        q.setType(q.getAnswers().size() == 1 ? Question.SINGLE_SELECTION : Question.MULTI_SELECTION);
        return q;
    }

    /**
     * 解析正确答案
     * answer: "2/3"
     */
    private List<Integer> parseAnswer(String answer) {
        List<Integer> list = new ArrayList<>();
        String[] data = answer.split("/");
        for (String s : data) {
            list.add(Integer.parseInt(s));
        }
        return list;
    }

    // 根据用户id, 从数据库中查询用户对象
    public User findUserById(Integer id) {
        return users.get(id);
    }

    // 根据试题的难度级别, 获得对应难度级别的试题列表
    public List<Question> findQuestionsByLevel(int level) {
        return new ArrayList<>(questions.get(level));
    }

    public int getQuestionCount() {
        return config.getInt("QuestionNumber");
    }

    public int getTimeLimit() {
        return config.getInt("TimeLimit");
    }

    public String getTitle() {
        return config.getString("PaperTitle");
    }
}
