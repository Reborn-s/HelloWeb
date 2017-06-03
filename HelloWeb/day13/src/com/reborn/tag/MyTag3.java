package com.reborn.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Reborn。 on 2017/5/9.
 * 自定义有标签体的标签
 */
public class MyTag3 extends SimpleTagSupport
{
    @Override
    public void doTag() throws JspException, IOException
    {
        Writer out = this.getJspContext().getOut();
        out.write("**********<br/>");

        this.getJspBody().invoke(out);
        out.write("<br/>**********");
    }
}
