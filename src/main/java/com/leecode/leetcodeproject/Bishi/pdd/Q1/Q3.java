package com.leecode.leetcodeproject.Bishi.pdd.Q1;

import java.util.Scanner;

public class Q3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int time = in.nextInt();
        String LAJI = in.nextLine();
        int[] zhishiliang = new int[num];
        for (int i = 0; i < num; i++) {
            zhishiliang[i] = in.nextInt();
        }
        if (num>2*time){
            System.out.println(-1);
        }


    }
}
