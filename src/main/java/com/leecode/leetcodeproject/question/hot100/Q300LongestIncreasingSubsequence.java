package com.leecode.leetcodeproject.question.hot100;
//300.最长递增子序列
//给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
//
//子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
//子序列
//todo dp[i]以i结尾!!的最长子序列长度  由[0,i-1]推出
//外层i从[1,nums.length-1] ，每次dp[i]由j从[0,i]更新dp[i] j可更改顺序 i必须从小到大

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q300LongestIncreasingSubsequence {
    public int longestConsecutive(int[] nums) {
        if (nums==null||nums.length==0)return 0;
        int []dp=new int[nums.length];
        int ans=1;
        Arrays.fill(dp,1);
        for (int i=0;i<dp.length;i++){
            for (int j=i+1;j<dp.length;j++){
                if (nums[j]>nums[i]){
                    dp[j]=Math.max(dp[i]+1,dp[j]);
                    ans=Math.max(ans,dp[j]);
                }
            }
        }
        return  ans;
    }
    public int lengthOfLIS2(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,1);
        int ans=1;
        if (nums==null||nums.length==0)return 0;
        for (int i=1;i< nums.length;i++){
            for (int j=i-1;j>=0;j--){//或者从0到i-1升序
                if (nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    ans=Math.max(ans,dp[i]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int arr = new Q300LongestIncreasingSubsequence().longestConsecutive(nums);
        System.out.println(arr);

    }
}
