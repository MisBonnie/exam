package com.zzxx.exam.controller;

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
    public void login() {
        // loginFrame 中获得 账号输入框 和 密码输入框的内容
        String id = loginFrame.getIdField().getText();
        String pwd = loginFrame.getPwdField().getText();
        try {
            service.login(id,pwd);
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
}
