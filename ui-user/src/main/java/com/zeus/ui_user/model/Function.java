package com.zeus.ui_user.model;

import java.io.Serializable;

/**
 * Created by zeus_coder on 2015/12/28.
 */
public class Function implements Serializable {

    private int icon;

    private String name;

    private String title;

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
