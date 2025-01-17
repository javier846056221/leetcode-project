package com.leecode.leetcodeproject.question.carl.Array;
//Q977 有序数组的平方
//TODO 有序数组的平方 双指针 平方后的数组 最大的元素在数组两侧
//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。

// 示例 1：
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]

// 提示：

// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
//
// Related Topics 数组 双指针 排序 👍 1074 👎 0
public class Q977SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int k = nums.length - 1;
        int[] ans = new int[nums.length];
        while (left <= right) {
            int rightval = nums[right] * nums[right];
            int leftval = nums[left] * nums[left];
            if (rightval >= leftval) {
                ans[k--] = rightval;
                right--;
            } else {
                ans[k--] = leftval;
                left++;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums=new int[]{-4,-1,0,3,10};
//        int []arr=new Q977SquaresOfSortedArray.sortedSquares(nums);

    }
}
