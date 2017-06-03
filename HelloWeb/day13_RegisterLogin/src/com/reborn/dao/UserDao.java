package com.reborn.dao;

import com.reborn.domain.User;

/**
 * Created by Reborn。 on 2017/5/12.
 * UserDao接口，所有的dao都要实现此接口
 * java.sql下的东西决不能出现在dao以外的地方，不然就会感染dao以外的代码
 */
public interface UserDao {
    void addUser(User form);
    User findUserByName(String username);
}
