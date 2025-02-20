package com.leecode.leetcodeproject.question.designpattern;
//懒
public class SingletonObject {
    private static SingletonObject instance;
    private SingletonObject(){}

    public static SingletonObject getInstance() {
        if (instance==null){
        instance=new SingletonObject();
        }
        return instance;
    }
    public void message(){
        System.out.println("hahaha！");
    }

}
//饿
class SingletonObject2 {
    private static SingletonObject2 instance = new SingletonObject2();

    private SingletonObject2() {
    }

    public static SingletonObject2 getInstance() {
        return instance;
    }

    public void message() {
        System.out.println("hahaha！");
    }
}