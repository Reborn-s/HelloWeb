package com.reborn.domain;

/**
 * Created by Reborn。 on 2017/5/8.
 */
public class Employee
{
    private String name;
    private double salary;
    private Address address;

    @Override
    public String toString()
    {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", address=" + address +
                '}';
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public double getSalary()
    {

        return salary;
    }

    public void setSalary(double salary)
    {
        this.salary = salary;
    }

    public String getName()
    {

        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
