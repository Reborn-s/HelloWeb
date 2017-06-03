package com.reborn.tag;

import javax.servlet.jsp.JspContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.JspFragment;
import javax.servlet.jsp.tagext.JspTag;
import javax.servlet.jsp.tagext.SimpleTag;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/9.
 * 自定义标签1
 */
public class MyTag1 implements SimpleTag
{
    private PageContext context;
    private JspFragment body;

    @Override
    public void doTag() throws JspException, IOException
    {
        context.getOut().print("Hello I'm tag1!");
    }

    @Override
    public void setParent(JspTag jspTag)
    {

    }

    @Override
    public JspTag getParent()
    {
        return null;
    }

    @Override
    public void setJspContext(JspContext jspContext)
    {
        this.context = (PageContext) jspContext;
    }

    @Override
    public void setJspBody(JspFragment jspFragment)
    {
        this.body = jspFragment;
    }
}
