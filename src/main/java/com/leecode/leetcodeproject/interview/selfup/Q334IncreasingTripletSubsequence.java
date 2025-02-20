package com.leecode.leetcodeproject.interview.selfup;

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
//todo  zuixiao记录当前遍历最小的数，dierxiao当前第二小的数，如果比这2个都大则找到了 返回
//  当前先与zuixiao比 给zuixiao赋值
// 大于zuixiao 小于dierxiao 给dierxiao赋值
// 都大于 返回true

import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q334IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int zuixiao=Integer.MAX_VALUE;
        int dierxiao=Integer.MAX_VALUE;
        for (int num:nums){
            if (num<=zuixiao){
                zuixiao=num;
            }
            else if (num<=dierxiao){
                dierxiao=num;
            }
            else return true;
        }
        return false;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        boolean arr = new Q334IncreasingTripletSubsequence().increasingTriplet(nums);
        System.out.println(arr);

    }
}
