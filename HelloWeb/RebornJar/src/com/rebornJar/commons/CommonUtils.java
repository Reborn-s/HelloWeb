package com.rebornJar.commons;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;
import java.util.UUID;

/**
 * Created by Reborn。 on 2017/5/6.
 */

public class CommonUtils
{

    //生成不重复的32位大写字符串
    public static String getUuid()
    {
        return UUID.randomUUID().toString().replace("-","").toUpperCase();
    }

    /*
    把map转换成指定类型的javaBean对象
     */
    public static <T> T toBean(Map map, Class<T> clazz)
    {
        try
        {
            //1.创建指定类型的javaBean对象
            T bean = clazz.newInstance();
            //2. 把数据封装到javaBean中
            BeanUtils.populate(bean,map);
            //3. 返回javaBean对象
            return bean;
        } catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }
}
