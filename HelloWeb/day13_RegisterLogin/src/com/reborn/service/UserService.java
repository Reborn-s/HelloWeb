package com.reborn.service;

import com.reborn.dao.DaoFactory;
import com.reborn.dao.UserDao;
import com.reborn.domain.User;

/**
 * Created by Reborn。 on 2017/5/10.
 */
public class UserService
{
    //把具体的实现类的创建，隐藏到工厂中
    private UserDao userDao = DaoFactory.getUserDao();

    public UserService() {
    }

    public void register(User user) throws UserException
    {
        String name = user.getUsername();
        if(userDao.findUserByName(name)==null)
        {
            userDao.addUser(user);
        }else
            throw new UserException("用户名"+user.getUsername()+"已经注册过啦！");
    }

    public User login(User form) throws UserException
    {
        User user = userDao.findUserByName(form.getUsername());
        if(user==null)
        {
            throw new UserException("用户名不存在！");
        }else if(!user.getPassword().equals(form.getPassword()))
            throw new UserException("密码错误！");

        //因为数据库中的user信息可能不止用户名和密码，所以返回的是数据库中的user，而不是表单传递进来的user
        return user;
    }
}
