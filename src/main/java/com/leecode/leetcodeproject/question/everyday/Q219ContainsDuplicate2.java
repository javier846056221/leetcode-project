package com.leecode.leetcodeproject.question.everyday;

//219存在重复元素
//给你一个整数数组 nums 和一个整数 k ，判断数组中是否存在两个 不同的索引 i 和 j ，满足 nums[i] == nums[j] 且 abs(i
//- j) <= k 。如果存在，返回 true ；否则，返回 false 。
// 示例 1：
//输入：nums = [1,2,3,1], k = 3
//输出：true
// 示例 2：
//输入：nums = [1,0,1,1], k = 1
//输出：true
// 示例 3：
//输入：nums = [1,2,3,1,2,3], k = 2
//输出：false
// 提示：
// 1 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// 0 <= k <= 10⁵
// Related Topics 数组 哈希表 滑动窗口 👍 761 👎 0
//todo  哈希map 先把窗口初始化 每次遍历先移走 再新加
import java.util.Arrays;
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q219ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<=k&&i< nums.length;i++){
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], i);
            }
            else return true;
        }
        for (int i=k+1;i<nums.length;i++){
            hashMap.remove(nums[i-k-1]);
            if (!hashMap.containsKey(nums[i])) {
                hashMap.put(nums[i], i);
            }
            else return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        boolean arr = new Q219ContainsDuplicate2().containsNearbyDuplicate(nums,2);
        System.out.println(arr);

    }
}
