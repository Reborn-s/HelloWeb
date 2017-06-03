package com.reborn.domain;

/**
 * Created by Reborn。 on 2017/5/8.
 */
public class User
{
    private String username;
    private String password;

    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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
