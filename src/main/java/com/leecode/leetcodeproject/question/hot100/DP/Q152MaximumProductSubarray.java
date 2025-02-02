package com.leecode.leetcodeproject.question.hot100.DP;
//152.乘积最大子数组
//给你一个整数数组 nums ，请你找出数组中乘积最大的非空连续 子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
// 测试用例的答案是一个 32-位 整数。
// 示例 1:
//输入: nums = [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 示例 2:
//输入: nums = [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。
// 提示:
// 1 <= nums.length <= 2 * 10⁴
// -10 <= nums[i] <= 10
// nums 的任何子数组的乘积都 保证 是一个 32-位 整数
// Related Topics 数组 动态规划 👍 2364 👎 0
import java.util.Arrays;
//todo 维护2个dp[num] 分别表示以i结尾的最大 和最小 因为max可能由当前num[i]*dpmax或者dpmin得到
//todo不断维护ans，dpmax，dpmin

//leetcode submit region begin(Prohibit modification and deletion)
public class Q152MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int []dpmax=new int[nums.length];
        int []dpmin=new int[nums.length];
        int ans=nums[0];
        dpmax[0]=nums[0];
        dpmin[0]=nums[0];
        for (int i=1;i< nums.length;i++){
            dpmax[i]= Math.max(Math.max(nums[i],dpmax[i-1]*nums[i]),dpmin[i-1]*nums[i]);
            dpmin[i]= Math.min(Math.min(nums[i],dpmax[i-1]*nums[i]),dpmin[i-1]*nums[i]);
            ans=Math.max(ans,dpmax[i]);
        }
        return ans;


    }
    public static void main(String[] args) {
        int[] nums = new int[]{2,3,-2,4};
        int arr = new Q152MaximumProductSubarray().maxProduct(nums);
        System.out.println(arr);

    }
}
