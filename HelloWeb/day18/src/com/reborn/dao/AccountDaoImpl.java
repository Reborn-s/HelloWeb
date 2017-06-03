package com.reborn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/13.
 */
public class AccountDaoImpl implements AccountDao {
    @Override
    public void updateBalance(Connection con, String name, double balance) {
        PreparedStatement pstmt = null;
        try {

            String sql = "update account set balance = balance+? where name=?";
            pstmt  = con.prepareStatement(sql);
            pstmt.setDouble(1,balance);
            pstmt.setString(2,name);
            pstmt.executeUpdate();

        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            if(pstmt!=null) try {
                pstmt.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
