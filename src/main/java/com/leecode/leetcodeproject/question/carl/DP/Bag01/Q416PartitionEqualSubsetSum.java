package com.leecode.leetcodeproject.question.carl.DP.Bag01;
//416 分割等和子集
//给你一个 只包含正整数 的非空数组nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
// 示例 1：
//输入：nums = [1,5,11,5]
//输出：true
//解释：数组可以分割成 [1, 5, 5] 和 [11] 。
// 示例 2：
//输入：nums = [1,2,3,5]
//输出：false
//解释：数组不能分割成两个元素和相等的子集。
// 提示：
// 1 <= nums.length <= 200
// 1 <= nums[i] <= 100
// Related Topics 数组 动态规划 👍 2224 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//leetcode submit region begin(Prohibit modification and deletion)
public class Q416PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i=0;i< nums.length;i++){
            sum+=nums[i];
        }
        if (sum%2!=0)return false;
        int capacity=sum/2;
        int []dp=new int[capacity+1];
        for (int i=0;i< nums.length;i++){
            for (int j=capacity;j>=nums[i];j--){
                dp[j]=Math.max(dp[j-nums[i]]+nums[i],dp[j]);
            }
        }
        return dp[capacity]==capacity?true:false;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
        boolean ans = new Q416PartitionEqualSubsetSum().canPartition(nums);
        System.out.println(ans);

    }
}
