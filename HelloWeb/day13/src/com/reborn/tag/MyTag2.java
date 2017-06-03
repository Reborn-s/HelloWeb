package com.reborn.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

/**
 * Created by Reborn。 on 2017/5/9.
 */
public class MyTag2 extends SimpleTagSupport
{
    @Override
    public void doTag() throws JspException, IOException
    {
        this.getJspContext().getOut().print("Hello I'm tag2!");
    }
}
