package com.reborn.domain;

/**
 * Created by Reborn。 on 2017/5/8.
 */
public class Person
{
    private String username;
    private int age;
    private String gender;
    private boolean bool;

    public boolean isBool()
    {
        return bool;
    }

    public Person()
    {
    }

    @Override
    public String toString()
    {
        return "Person{" +
                "username='" + username + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getGender()
    {

        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public int getAge()
    {

        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
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
