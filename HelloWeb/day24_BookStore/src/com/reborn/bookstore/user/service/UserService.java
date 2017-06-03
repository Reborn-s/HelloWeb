package com.reborn.bookstore.user.service;

import com.reborn.bookstore.user.dao.UserDao;
import com.reborn.bookstore.user.domain.User;

/**
 * Created by Reborn。 on 2017/5/27.
 */
public class UserService {
    private UserDao userDao = new UserDao();

    public User login(User form) throws UserException {
        User user = userDao.findByUsername(form.getLoginname());
        if(user==null)  throw new UserException("用户不存在！");
        if(!user.getLoginpass().equals(form.getLoginpass()))    throw new UserException("密码错误！");
        if(!user.isStatus())    throw new UserException("用户尚未激活！");
        return user;
    }

    public void activate(String activationCode) throws UserException {
        User user = userDao.findByActivationCode(activationCode);
        if(user==null)  throw new UserException("激活码错误！");
        if(user.isStatus()) throw new UserException("您已经被激活了！不要重复激活谢谢！");
        userDao.updateActivationCode(user.getUid(),true);
    }

    public void regist(User form) throws UserException {
        User user = userDao.findByUsername(form.getLoginname());
        if(user!=null)  throw new UserException("用户名已经被注册啦！");

        user = userDao.findByEmail(form.getEmail());
        if(user!=null)  throw new UserException("邮箱已经被注册啦！");

        userDao.add(form);
    }
}
