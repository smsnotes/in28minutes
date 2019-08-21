package com.in28minutes.rest.webservices.restfullwebservices.work;

import com.in28minutes.rest.webservices.restfullwebservices.user.User;

import java.util.Date;

public class Worker extends User {

    public Worker() {
        super();
    }

    public Worker(long salary, Integer id, String name, Date birthDate) {
        super(id, name, birthDate);
        this.salary = salary;
    }


    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    private  long salary;

    public Worker(Integer id, String name, Date birthDate) {
        super(id, name, birthDate);
    }
}
