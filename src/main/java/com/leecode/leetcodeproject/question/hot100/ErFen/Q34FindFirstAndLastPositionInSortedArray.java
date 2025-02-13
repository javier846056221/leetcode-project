package com.leecode.leetcodeproject.question.hot100.ErFen;
//Q34排序数组查找元素的第一个和最后一个位置
//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
// 示例 1：
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4]
// 示例 2：
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1]
// 示例 3：
//输入：nums = [], target = 0
//输出：[-1,-1]
// 提示：
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// nums 是一个非递减数组
// -10⁹ <= target <= 10⁹
//
//
// Related Topics 数组 二分查找 👍 2896 👎 0

import java.util.HashMap;

//TODO 只需要二分 修改 相等时的逻辑 二分查找两次
// 寻找左边界 nums[mid]==target {
//        mid==0||nums[mid-1]!=target 找到
//            else 左侧找：    right=mid-1
// }

//leetcode submit region begin(Prohibit modification and deletion)
public class Q34FindFirstAndLastPositionInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int []ans =new int[]{-1,-1};
        int left=0;
        int right= nums.length-1;
        //  寻找左边界
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                //找到该元素，mid为最左侧，或者左边的值不为target 找到
                if (mid==0||nums[mid-1]!=target){
                   ans[0]=mid;
                   break;
                }
                else right=mid-1;

            }
            else  if (nums[mid]>target){
                right=mid-1;
            }
            else left=mid+1;
        }
        left=0;
        right= nums.length-1;
        //  寻找右边界
        while (left<=right){
            int mid=(left+right)/2;
            if (nums[mid]==target){
                //todo 找到该元素，mid为最左侧，或者左边的值不为target 找到
                if (mid== nums.length-1||nums[mid+1]!=target){
                    ans[1]=mid;
                    break;
                }
                else {
                    //todo 右侧找
                    left=mid+1;
                }
            }
            else  if (nums[mid]>target){
                right=mid-1;
            }
            else left=mid+1;
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] nums=new int[]{5,7,7,8,8,10};
        int []arr=  new Q34FindFirstAndLastPositionInSortedArray().searchRange(nums,8);
        for (int i=0;i<2;i++){
            System.out.println(arr[i]);
        }

    }
//leetcode s
}
