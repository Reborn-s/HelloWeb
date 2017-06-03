package com.reborn.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.SkipPageException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/9.
 */
public class SkipTag extends SimpleTagSupport
{
    @Override
    public void doTag() throws JspException, IOException
    {
        this.getJspContext().getOut().print("只看得到我！");
        throw new SkipPageException();
    }
}
