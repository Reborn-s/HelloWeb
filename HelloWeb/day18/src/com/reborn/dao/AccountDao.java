package com.reborn.dao;

import java.sql.Connection;

/**
 * Created by Reborn。 on 2017/5/13.
 */
public interface AccountDao {
    void updateBalance(Connection con,String name,double balance);
}
