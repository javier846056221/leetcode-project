package com.leecode.leetcodeproject.interview;


import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素
//
//题目描述
//示例 1:​
//输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]​
//示例 2:​
//输入: nums = [1], k = 1​
//输出: [1]
public class ByteDance {
    public  int [] findk(int  []num,int k){
        HashMap<Integer,Integer>map=new HashMap<>();
        for (int a:num){
            map.put(a,map.getOrDefault(a,0)+1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return -(o1.getValue()-o2.getValue());
            }
        });

        for (Map.Entry<Integer, Integer> integerIntegerEntry : map.entrySet()) {
            queue.add(integerIntegerEntry);
        }
        int []ans=new int[k];
        for (int i=0;i<k;i++){
            ans[i]=queue.poll().getKey();
        }
        return ans;


    }

    public static void main(String[] args) {
        int []arr={1,1,1,2,2,3};
        int []ans=new ByteDance().findk(arr,2);
        for (int i=0;i<2;i++){
            System.out.println(ans[i]);

        }

    }
}
