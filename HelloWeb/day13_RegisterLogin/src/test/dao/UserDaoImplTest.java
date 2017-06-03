package test.dao;

import com.reborn.dao.UserDaoImpl;
import com.reborn.domain.User;
import org.junit.Test;

/**
 * Created by Reborn。 on 2017/5/10.
 */
public class UserDaoImplTest
{

    @Test
    public void testFindUserByName()
    {
        UserDaoImpl dao = new UserDaoImpl();
        User user = dao.findUserByName("张三");
        System.out.println(user);
    }

    @Test
    public void testAdd()
    {
        UserDaoImpl dao = new UserDaoImpl();
        User user = new User();
        user.setUsername("李四");
        user.setPassword("lsi");
        dao.addUser(user);
    }
}
