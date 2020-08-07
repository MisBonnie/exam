package com.zzxx.exam.service;

import com.zzxx.exam.entity.*;

import java.util.List;
import java.util.Map;

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
//        info.setTimeLimit(文件中读取的);
//        info.setQuestionCount(文件中读取的);
//        info.setTitle(文件中读取的);
        info.setUser(user);

        // 生成一套试卷
        createExamPaper();
        return info;
    }
    // 定义一套试卷
    private List<QuestionInfo> paper;

    private void createExamPaper() {
        for (int i = Question.LEVEL1; i <= Question.LEVEL10 ; i++) {
            // 获得难度级别对应的所有试题
            List<Question> questions = entityContext.findQuestionsByLevel(i);
            // 随机获得两个试题对象, 并且加入到paper中
        }
    }

    public Question getQuestionFormPaper(int i) {
        return paper.get(i).getQuestion();
    }
}
