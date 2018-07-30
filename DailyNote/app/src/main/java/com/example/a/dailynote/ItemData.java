package com.example.a.dailynote;

public class ItemData {
    public String time;
    public String desc;

    public ItemData() {
    }

    public ItemData(String time, String desc) {
        this.time = time;
        this.desc = desc;
    }

    public String getName() {
        return time;
    }

    public void setName(String name) {
        this.time = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}
