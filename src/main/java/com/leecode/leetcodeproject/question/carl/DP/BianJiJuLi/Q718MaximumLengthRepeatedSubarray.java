package com.leecode.leetcodeproject.question.carl.DP.BianJiJuLi;
//718.最长重复子数组 子数组是连续的！！
//给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
// 示例 1：
//输入：nums1 = [1,2,3,2,1], nums2 = [3,2,1,4,7]
//输出：3
//解释：长度最长的公共子数组是 [3,2,1] 。
// 示例 2：
//输入：nums1 = [0,0,0,0,0], nums2 = [0,0,0,0,0]
//输出：5
// 提示：
// 1 <= nums1.length, nums2.length <= 1000
// 0 <= nums1[i], nums2[i] <= 10

//todo dp[i][j]A以下标i-1为结尾的 B以j-1结尾的  最长重复子数组长度
//递推公式
//根据dp[i][j]的定义，dp[i][j]的状态只能由dp[i - 1][j - 1]推导出来。
//leetcode submit region begin(Prohibit modification and deletion)
public class Q718MaximumLengthRepeatedSubarray {
    public int findLength(int[] nums1, int[] nums2) {
        int[][]dp=new int[nums1.length+1][nums2.length+1];
        int ans=0;
        for (int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if (nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    ans= Math.max(ans,dp[i][j]);

                }
            }
        }
        return  ans;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,3,2,1};
        int[] nums2 = new int[]{3,2,1,4,7};
        int arr = new Q718MaximumLengthRepeatedSubarray().findLength(nums1,nums2);
        System.out.println(arr);

    }
}
