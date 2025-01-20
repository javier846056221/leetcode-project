package com.leecode.leetcodeproject.question.hot100.DP;
//70爬楼梯
//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

// 示例 1：
//
//
//输入：n = 2
//输出：2
//解释：有两种方法可以爬到楼顶。
//1. 1 阶 + 1 阶
//2. 2 阶
//
// 示例 2：
//
//
//输入：n = 3
//输出：3
//解释：有三种方法可以爬到楼顶。
//1. 1 阶 + 1 阶 + 1 阶
//2. 1 阶 + 2 阶
//3. 2 阶 + 1 阶
//leetcode submit region begin(Prohibit modification and deletion)
public class Q70ClimbingStairs {
    public int climbStairs(int n) {
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i=2;i<dp.length;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];


    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int arr = new Q70ClimbingStairs().climbStairs(10);
        System.out.println(arr);

    }
}
