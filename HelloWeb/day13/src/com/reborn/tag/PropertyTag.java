package com.reborn.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/9.
 * 自定义带属性的标签
 */
public class PropertyTag extends SimpleTagSupport
{
    private boolean test;

    public boolean isTest()
    {
        return test;
    }

    //这个方法由Tomcat来调用，并且在doTag()之前调用
    public void setTest(boolean test)
    {
        this.test = test;
    }

    @Override
    public void doTag() throws JspException, IOException
    {
        if(test)
        {
            /*
            执行标签体
             */
            this.getJspBody().invoke(null);//如果传递的输出流为null,表示使用的就是当前页面的out
            //和使用this.getJspContext().getOut()一样的效果
        }
    }
}
