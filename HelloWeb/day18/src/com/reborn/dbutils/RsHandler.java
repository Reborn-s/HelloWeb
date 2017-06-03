package com.reborn.dbutils;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/15.
 * 用来实现ORM：即把结果集转换成需要的类型
 */
public interface RsHandler<T> {
    T handle(ResultSet rs) throws SQLException;
}
