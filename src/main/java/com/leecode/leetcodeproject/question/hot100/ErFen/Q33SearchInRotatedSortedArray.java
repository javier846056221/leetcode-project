package com.leecode.leetcodeproject.question.hot100.ErFen;
//Q33搜索旋转排序数组
//整数数组 nums 按升序排列，数组中的值 互不相同 。
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
//
// 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
// 示例 1：
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 示例 2：
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1
//
// 示例 3：
//输入：nums = [1], target = 0
//输出：-1
// 提示：

// 1 <= nums.length <= 5000
// -10⁴ <= nums[i] <= 10⁴
// nums 中的每个值都 独一无二
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转
// -10⁴ <= target <= 10⁴
//
//
// Related Topics 数组 二分查找 👍 3102 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//md

//找到山峰的位置 当前位置mid num[mid]>num[mid-1]&&num[mid]>num[mid+1]
// 然后 数组可从mid分为左右两段 在单独一段2分

//定理一：只有在顺序区间内才可以通过区间两端的数值判断target是否在其中。
//
//定理二：判断顺序区间还是乱序区间，只需要对比 left 和 right 是否是顺序对即可，left <= right，顺序区间，否则乱序区间。
//
//定理三：每次二分都会至少存在一个顺序区间。
//



//通过不断的用Mid二分，根据定理二，将整个数组划分成顺序区间和乱序区间，然后利用定理一判断target是否在顺序区间，如果在顺序区间，下次循环就直接取顺序区间，如果不在，那么下次循环就取乱序区间。·
//leetcode submit region begin(Prohibit modification and deletion)
public class Q33SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }
            if (nums[left] <= nums[mid]) {
                //[left,mid]是有序的
                if (target >= nums[left] && target < nums[mid]) {
                    //target属于[left,mid]
                    right = mid - 1;
                }//下一次区间[mid+1,right]
                else left = mid + 1;
            } else {
                //[mid,right]是有序的
                if (target > nums[mid] && target <= nums[right]) {
                    //target属于[mid,right]
                    left = mid + 1;
                }//[left,mid-1]里面找
                else right = mid - 1;

            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,4,5,6,7,0,1};
        int arr=  new Q33SearchInRotatedSortedArray().search(nums,1);
        System.out.println(arr);

    }
//leetcode s
}
