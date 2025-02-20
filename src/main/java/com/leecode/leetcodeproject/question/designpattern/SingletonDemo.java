package com.leecode.leetcodeproject.question.designpattern;

public class SingletonDemo {
    public static void main(String[] args) {
       // SingletonObject singletonObject=   new SingletonObject();
        SingletonObject instance = SingletonObject.getInstance();
        instance.message();

        SingletonObject2 instance1 = SingletonObject2.getInstance();
        instance1.message();
    }
}
