package test.dao;

import cn.itcast.jdbc.TxQueryRunner;
import org.apache.commons.dbutils.QueryRunner;
import test.Column;
import test.ID;
import test.Table;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.SQLException;

/**
 * Created by Reborn。 on 2017/5/31.
 */
public class BaseDao<T> {
    private QueryRunner qr = new TxQueryRunner();
    private Class<T> beanClass;
    private Table table;
    private ID primaryKey;
    private Column[] columns;

    public BaseDao()
    {
        //通过反射注解得到表名和字段名
        beanClass = (Class<T>) ((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        table = beanClass.getAnnotation(Table.class);
        primaryKey = beanClass.getAnnotation(ID.class);
        Field[] fields = beanClass.getFields();
        columns = new Column[fields.length];
        for(int i=0;i<fields.length;i++)
            columns[i] = fields[i].getAnnotation(Column.class);

    }
    public void add(T bean)
    {
        String sql = "insert into " + table.value() + " values(";
        for(int i=0;i<columns.length;i++)
        {
            if(i==columns.length-1)
                sql += "?";
            else
                sql += "?,";
        }
        sql += ")";

        Object[] params = columns;
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
