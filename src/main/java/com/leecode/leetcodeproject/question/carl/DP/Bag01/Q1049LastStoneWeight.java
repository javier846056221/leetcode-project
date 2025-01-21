package com.leecode.leetcodeproject.question.carl.DP.Bag01;
//1049 最后一块石头重量
//有一堆石头，用整数数组 stones 表示。其中 stones[i] 表示第 i 块石头的重量。
// 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：
// 如果 x == y，那么两块石头都会被完全粉碎；
// 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
// 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
// 示例 1：
//输入：stones = [2,7,4,1,8,1]
//输出：1
//解释：
//组合 2 和 4，得到 2，所以数组转化为 [2,7,1,8,1]，
//组合 7 和 8，得到 1，所以数组转化为 [2,1,1,1]，
//组合 2 和 1，得到 1，所以数组转化为 [1,1,1]，
//组合 1 和 1，得到 0，所以数组转化为 [1]，这就是最优值。
// 示例 2：
//输入：stones = [31,26,33,21,40]
//输出：5
// 提示：
// 1 <= stones.length <= 30
// 1 <= stones[i] <= 100
// Related Topics 数组 动态规划 👍 939 👎 0
//todo 总容量sum 向下取整一半capacity 的背包的最大价值dp[capacity] 剩下sum-dp[capacity] 剩下的更多 大的-小的
public class Q1049LastStoneWeight {

    public int lastStoneWeightII(int[] stones) {
        int sum=0;
        for (int i=0;i< stones.length;i++){
            sum+=stones[i];
        }
        int capacity=sum/2;
        int []dp=new int[capacity+1];
        for (int i=0;i< stones.length;i++){
            for (int j=capacity;j>=stones[i];j--){
                dp[j]=Math.max(dp[j-stones[i]]+stones[i],dp[j]);
            }
        }
        return sum-dp[capacity]-dp[capacity];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,7,9,3,1};
       int ans = new Q1049LastStoneWeight().lastStoneWeightII(nums);
        System.out.println(ans);

    }
}
