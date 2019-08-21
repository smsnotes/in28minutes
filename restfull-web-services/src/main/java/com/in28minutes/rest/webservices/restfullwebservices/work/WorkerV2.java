package com.in28minutes.rest.webservices.restfullwebservices.work;

import com.in28minutes.rest.webservices.restfullwebservices.user.User;

import java.util.Date;

public class WorkerV2 extends Worker {

    public WorkerV2() {
        super();
    }

    public WorkerV2(long salary, Integer id, String name, Date birthDate) {
        super(salary,id, name, birthDate);
    }

    public WorkerV2(Level level,long salary, Integer id, String name, Date birthDate) {
        super(salary, id, name, birthDate);
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    private  Level level;

    public WorkerV2(Integer id, String name, Date birthDate) {
        super(id, name, birthDate);
    }
}
