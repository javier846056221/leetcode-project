package com.leecode.leetcodeproject.question.carl.Array;
//TODO 滑动窗口 单层for，指向窗口末尾，sum>=target 不断起始位置++
public class Q209MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int sum=0;
        int left=0;
        int ans=Integer.MAX_VALUE;
        for (int right=0;right< nums.length;right++){
            sum+=nums[right];
            while (sum>=target){
                ans=Math.min(ans,right-left+1);
                sum-=nums[left];
                left++;
            }
        }
        return ans==Integer.MAX_VALUE?0:ans;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{2,3,1,2,4,3};
        System.out.println(new Q209MinimumSizeSubarraySum().minSubArrayLen(7,nums));
    }
}
