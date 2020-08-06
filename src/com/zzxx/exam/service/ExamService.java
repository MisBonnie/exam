package com.zzxx.exam.service;

import com.zzxx.exam.entity.EntityContext;
import com.zzxx.exam.entity.User;

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
        Map<String, User> users = entityContext.getUsers();
        // 3.如果有user, 密码正确, 登录成功, 界面跳转
        User user = users.get(id);
        /*if (user != null) {
            // 判断密码
            if (password.equals(user.getPassword())) {
                return user;
            }
        }*/
        if (id.equals("1234") && password.equals("1111")){
            return null;
        }
        // 4.如果有user, 密码不正确, 提示信息
        // 5.没有user, 提示信息
        throw new IdOrPwdException("编号/密码错误");
    }

    public void setEntityContext(EntityContext entityContext) {
        this.entityContext = entityContext;
    }
}
