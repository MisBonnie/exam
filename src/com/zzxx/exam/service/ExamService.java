package com.zzxx.exam.service;

import com.zzxx.exam.entity.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 所有的业务模型: 登录, 开始考试, 查看规则, 交卷, 上一题, 下一题...
 */
public class ExamService {
    private EntityContext entityContext;

    public User login(String id, String password) throws IdOrPwdException {
        // 在这里写登录的过程
        // 1.获得用户输入的账号, 密码
        // 2.在模拟数据库中的users 查找有没有对应的User对象
        User user = entityContext.findUserById(Integer.valueOf(id));
        // 3.如果有user, 密码正确, 登录成功, 界面跳转
        if (user != null) {
            // 判断密码
            if (password.equals(user.getPassword())) {
                return user;
            }
        }
        // 4.如果有user, 密码不正确, 提示信息
        // 5.没有user, 提示信息
        throw new IdOrPwdException("编号/密码错误");
    }

    public void setEntityContext(EntityContext entityContext) {
        this.entityContext = entityContext;
    }

    public ExamInfo startExam(User user) {
        ExamInfo info = new ExamInfo();
        info.setQuestionCount(entityContext.getQuestionCount());
        info.setTimeLimit(entityContext.getTimeLimit());
        info.setTitle(entityContext.getTitle());
        info.setUser(user);// 当前系统登陆用户

        // 生成一套试卷
        createExamPaper();
        return info;
    }

    // 定义一套试卷
    private List<QuestionInfo> paper = new ArrayList<>();

    /**
     * 创建考卷
     * 规则: 每个难度级别两道题
     */
    private void createExamPaper() {
        Random r = new Random();
        int index = 0; // 记录题号
        for (int level = Question.LEVEL1; level <= Question.LEVEL10; level++) {
            // 获得难度级别对应的所有试题
            List<Question> list = entityContext.findQuestionsByLevel(level);
            // 随机获得两个试题对象, 并且加入到paper中
            // 从list中取出(remove)一道题
            Question q1 = list.remove(r.nextInt(list.size()));
            Question q2 = list.remove(r.nextInt(list.size()));
            paper.add(new QuestionInfo(index++, q1));
            paper.add(new QuestionInfo(index++, q2));
        }
    }

    public QuestionInfo getQuestionFormPaper(int i) {
        return paper.get(i);
    }
}
