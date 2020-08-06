package com.zzxx.exam;

import com.zzxx.exam.controller.ClientContext;
import com.zzxx.exam.entity.EntityContext;
import com.zzxx.exam.service.ExamService;
import com.zzxx.exam.ui.LoginFrame;
import com.zzxx.exam.ui.MenuFrame;

// 程序入口
public class Main {
    public static void main(String[] args) {
        LoginFrame loginFrame = new LoginFrame();
        MenuFrame menuFrame = new MenuFrame();
        ClientContext controller = new ClientContext();
        ExamService service = new ExamService();
        EntityContext entityContext = new EntityContext();

        // 注入依赖
        controller.setLoginFrame(loginFrame);
        controller.setMenuFrame(menuFrame);
        loginFrame.setController(controller);
        controller.setService(service);
        service.setEntityContext(entityContext);

        controller.startShow();
    }
}
