package com.leecode.leetcodeproject.Bishi.pdd.Q1;

import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num=in.nextInt();
        String LAJI = in.nextLine();
        int []door=new int[num];
        for (int i=0;i<num;i++){
            door[i]=in.nextInt();
        }
        int fanzhuanjuli=0;
        int juli=0;
        for(int i=0;i<door.length;i++){
            if (door[i]<0){
                fanzhuanjuli+=door[i];
            }
            else  juli+=door[i];
        }
        System.out.println(juli-fanzhuanjuli);
        // 注意 hasNext 和 hasNextLine 的区别

    }
}
