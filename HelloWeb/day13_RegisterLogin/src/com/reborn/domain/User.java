package com.reborn.domain;

/**
 * Created by Reborn。 on 2017/5/10.
 */
public class User
{
    private String username;
    private String password;
    private int age;
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String verifyCode;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public User()
    {
    }

    public User(String password, String username)
    {
        this.password = password;
        this.username = username;
    }

    @Override
    public String toString()
    {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
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
