package com.example.myremembrall;

import java.util.Date;

public class Tasks {
    private String taskName;
    private String day;
    private String type;
    private Date date;
    private Date time;

    public Tasks(String taskName, String day, String type, Date date, Date time) {
        this.taskName = taskName;
        this.day = day;
        this.type = type;
        this.date = date;
        this.time = time;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
