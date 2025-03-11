package com.leecode.leetcodeproject.Bishi.pdd.Q1;

import java.util.Scanner;

public class Q2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String LAJI = in.nextLine();
        int[] door = new int[num];
        for (int i = 0; i < num; i++) {
            door[i] = in.nextInt();
        }
        int ans=Integer.MIN_VALUE;
       int [][]dp=new int[door.length+1][2];
        for(int i=1;i<num;i++){
          //BUFAN
            dp[i][0]=dp [i-1][0]+door[i-1];
          //FAn
            dp[i][1]=Math.abs(-dp[i-1][0]+door[i-1])>=Math.abs(dp[i-1][1]+door[i-1])?
        -dp[i-1][0]+door[i-1]:dp[i-1][1]+door[i-1];
            ans=Math.max(Math.max(Math.abs(ans),Math.abs(dp[i][0])),Math.abs(dp[i][1]));

        }
        System.out.println(ans);
    }
}
