package com.reborn.domain;

/**
 * Created by Reborn。 on 2017/5/10.
 */
public class User
{
    private String username;
    private String password;

    public User(String name,String password)
    {
        this.username = name;
        this.password = password;
    }

    public User()
    {
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getUsername()
    {
        return username;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }
}
