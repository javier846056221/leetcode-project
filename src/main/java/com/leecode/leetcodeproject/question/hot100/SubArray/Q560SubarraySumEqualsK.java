package com.leecode.leetcodeproject.question.hot100.SubArray;
//560.和为·K的子数组
//给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
// 子数组是数组中元素的连续非空序列。
//
// 示例 1：
//输入：nums = [1,1,1], k = 2
//输出：2
// 示例 2：
//输入：nums = [1,2,3], k = 3
//输出：2
// 提示：
// 1 <= nums.length <= 2 * 10⁴
// -1000 <= nums[i] <= 1000
// -10⁷ <= k <= 10⁷
// Related Topics 数组 哈希表 前缀和 👍 2583 👎 0
//todo  map存储每个前缀和的次数，pre当前从[0,i]前缀和， pre -(pre-k)=K,map寻找并且更新当前pre的次数，寻找pre-k的次数


import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q560SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] arr = new int[nums.length];
        map.put(0, 1);
        int ans = 0;
        arr[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];

        }
        for (int i = 0; i < nums.length; i++) {
            ans += map.getOrDefault(arr[i] - k, 0);
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int arr = new Q560SubarraySumEqualsK().subarraySum(nums, 3);
        System.out.println(arr);

    }
}
