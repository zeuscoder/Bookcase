package com.zeus.ui_user.model;

import java.io.Serializable;

/**
 * Created by zeus_coder on 2015/12/26.
 */
public class ExpressTimeLineModel implements Serializable{

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
