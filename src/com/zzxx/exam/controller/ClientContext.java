package com.zzxx.exam.controller;

import com.zzxx.exam.entity.ExamInfo;
import com.zzxx.exam.entity.QuestionInfo;
import com.zzxx.exam.entity.User;
import com.zzxx.exam.service.ExamService;
import com.zzxx.exam.service.IdOrPwdException;
import com.zzxx.exam.ui.*;

/**
 * 客户端控制器: 进行界面和业务模型之间的数据传递/交互
 */
public class ClientContext {
    private LoginFrame loginFrame;
    private MenuFrame menuFrame;
    private WelcomeWindow welcomeWindow;
    private ExamFrame examFrame;
    private MsgFrame msgFrame;
    private ExamService service;

    public void startShow() {
        loginFrame.setVisible(true);
    }

    private User user; // 记录登录的用户

    public void login() {
        // loginFrame 中获得 账号输入框 和 密码输入框的内容
        String id = loginFrame.getIdField().getText();
        String pwd = loginFrame.getPwdField().getText();
        try {
            user = service.login(id, pwd);
            // 更新菜单界面
            menuFrame.updateView(user);
            // 界面跳转
            loginFrame.setVisible(false);
            menuFrame.setVisible(true);
        } catch (IdOrPwdException e) {
            // 更新提示信息
            loginFrame.updateMessage(e.getMessage());
        }
    }

    public void setLoginFrame(LoginFrame loginFrame) {
        this.loginFrame = loginFrame;
    }

    public void setMenuFrame(MenuFrame menuFrame) {
        this.menuFrame = menuFrame;
    }

    public void setWelcomeWindow(WelcomeWindow welcomeWindow) {
        this.welcomeWindow = welcomeWindow;
    }

    public void setExamFrame(ExamFrame examFrame) {
        this.examFrame = examFrame;
    }

    public void setMsgFrame(MsgFrame msgFrame) {
        this.msgFrame = msgFrame;
    }

    public void setService(ExamService service) {
        this.service = service;
    }

    /*
        控制器开始考试的方法
     */
    public void start() {
        // 1.界面 菜单界面-隐藏, 考试界面-显示
        // 2.生成考试信息, 以及试卷->List<Question>
        // ExamInfo -> 业务模块生成的
        // 试卷中的一道题目 -> 第一题
        // 访问业务层开始考试
        ExamInfo examInfo = service.startExam(user);
        // 取得第一道题, 用于显示考题
        currentQuestionInfo = service.getQuestionFormPaper(0);
        // 3.更新考试界面
        examFrame.updateView(examInfo, currentQuestionInfo);
        // 关闭菜单界面
        menuFrame.setVisible(false);
        // 打开考试界面
        examFrame.setVisible(true);
    }

    // 记录正在作答的题目信息
    private QuestionInfo currentQuestionInfo;
    private int questionIndex = 0; // -- 可以使用currentQuestionInfo.getQuestionIndex()取代

    public void next() {
        questionIndex++;
        currentQuestionInfo = service.getQuestionFormPaper(questionIndex);
        // 1.更新界面
        // 2.记录当前这道题的用户答案
    }
}
