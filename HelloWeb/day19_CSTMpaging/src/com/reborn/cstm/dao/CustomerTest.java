package com.reborn.cstm.dao;

import com.reborn.cstm.domain.Customer;
import com.rebornJar.commons.CommonUtils;
import org.junit.Test;

/**
 * Created by Reborn。 on 2017/5/24.
 */
public class CustomerTest {

    @Test
    public void fun()
    {
        CustomerDao dao = new CustomerDao();
        for(int i=1;i<=300;i++)
        {
            Customer c = new Customer();
            c.setCid(CommonUtils.getUuid());
            c.setCname("cstm_"+i);
            c.setBirthday("2014-07-13");
            c.setGender((i&1)==1?"male":"female");
            c.setCellphone("139"+i);
            c.setEmail("cstm_"+i+"@163.com");
            c.setDescription("我是客户"+i);

            dao.add(c);
        }
    }
}
