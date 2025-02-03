package com.leecode.leetcodeproject.question.carl.DP;
//给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
//
// 每个元素 nums[i] 表示从索引 i 向后跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
//
//
// 0 <= j <= nums[i]
// i + j < n
//
//
// 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
//
//
//
// 示例 1:
//
//
//输入: nums = [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
//
//
// 示例 2:
//
//
//输入: nums = [2,3,0,1,4]
//输出: 2
//
//
//
//
// 提示:
//
//
// 1 <= nums.length <= 10⁴
// 0 <= nums[i] <= 1000
// 题目保证可以到达 nums[n-1]
//
//
// Related Topics 贪心 数组 动态规划 👍 2734 👎 0
//todo dp[i]表示到达下标i最少跳跃次数 不可达默认100000
//Q55跳跃游戏 贪心

////给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
////
//// 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
////
////
////
//// 示例 1：
////
////
////输入：nums = [2,3,1,1,4]
////输出：true
////解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
////
////
//// 示例 2：
////
////
////输入：nums = [3,2,1,0,4]
////输出：false
////解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
////
////
////
////
//// 提示：
////
////
//// 1 <= nums.length <= 10⁴
//// 0 <= nums[i] <= 10⁵
////
////
//// Related Topics 贪心 数组 动态规划 👍 2966 👎 0
//
//
/// /leetcode submit region begin(Prohibit modification and deletion)
//class Solution {
//    public boolean canJump(int[] nums) {
//        int max=0;
//        for (int i=0;i<=max;i++){
//            if (i<=max){
//                max=Math.max(max,i+nums[i]);
//                if (max>= nums.length-1)return true;
//            }
//
//        }
//
//        return false;
//
//    }
//}

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int jump(int[] nums) {
        int []dp=new int[nums.length];
        Arrays.fill(dp,100000);
        dp[0]=0;
        for (int i=1;i< nums.length;i++){
            for (int j=0;j<i;j++){
                if (j+nums[j]>=i){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }

        }
        return dp[nums.length-1];

    }
}
public class Q45JumpGame2 {
    public static void main(String[] args) {
        System.out.println(new Solution().jump(new int[]{2, 3, 1, 1, 4}));

    }
}
