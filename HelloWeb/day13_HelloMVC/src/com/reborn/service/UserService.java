package com.reborn.service;

import com.reborn.dao.UserDao;
import com.reborn.domain.User;

/**
 * Created by Reborn。 on 2017/5/10.
 */
public class UserService
{
    //service层依赖于dao层
    private UserDao userDao = new UserDao();

    /*
    service的查询依赖于dao层
     */
    public User find()
    {
        return userDao.find();
    }
}
