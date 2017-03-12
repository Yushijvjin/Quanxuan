package com.bwie.test;

/**
 * Created by 李小兵 on 2016/12/2.
 */
public class Cargo {

    private String name;
    private String picPath;
    private boolean flag;
    private int price;


    public Cargo( String name, String picPath,boolean flag,int price) {
        this.flag = flag;
        this.name = name;
        this.picPath = picPath;
        this.price = price;
    }

    public Cargo(boolean flag, String name, String picPath ) {
        this.flag = flag;
        this.name = name;
        this.picPath = picPath;

    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean isFlag() {
        return flag;
    }

    public String getName() {
        return name;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }
}
