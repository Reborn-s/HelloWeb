package com.reborn.database;


import org.apache.commons.io.IOUtils;
import org.junit.Test;

import javax.sql.rowset.serial.SerialBlob;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

/**
 * Created by Reborn。 on 2017/5/13.
 * 将mp3这种大数据保存到数据库
 */
public class Bigdata {
    //向数据库中保存mp3文件
    @Test
    public void insertMp3()
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        try {
             con = JdbcUtils.getConnection();

             //创建sql模板,得到pstmt对象
            String sql = "insert into tab_bin values(?,?,?)";
            pstmt = con.prepareStatement(sql);

            //设置参数
            pstmt.setInt(1,1);
            pstmt.setString(2,"你就不要想起我.mp3");
            byte[] bytes = IOUtils.toByteArray(new FileInputStream("D:\\music\\田馥甄\\你就不要想起我.mp3"));
            Blob blob = new SerialBlob(bytes);
            pstmt.setBlob(3,blob);

            pstmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            try {
                if(pstmt!=null) pstmt.close();
                if(con!=null)   con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Test
    public void selectMp3()
    {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            con = JdbcUtils.getConnection();
            String sql = "select * from tab_bin";
            pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if(rs.next())
            {
                //获取rs中名为filedata的列数据
                Blob blob = rs.getBlob(3);
                /**
                 * 把blob变为硬盘上的文件！
                 * 1. 通过Blob得到输入流对象
                 * 2. 自己创建输出流对象
                 * 3. 把输入流的数据写入到输出流中
                 */
                InputStream in = blob.getBinaryStream();
                OutputStream out = new FileOutputStream("E:\\hebe.mp3");
                IOUtils.copy(in,out);
            }
        }catch (Exception e)
        {
            throw new RuntimeException(e);
        }finally {
            try {
                if(rs!=null)    rs.close();
                if(pstmt!=null) pstmt.close();
                if(con!=null)   con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
