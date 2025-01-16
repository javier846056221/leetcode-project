package com.leecode.leetcodeproject.question.hot100.hash;
//128.最长连续序列
//todo看官方题解，模拟每次起始位置的解法
//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
// 请你设计并实现时间复杂度为 O(n) 的算法解决此问题。
// 示例 1：
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
// 示例 2：
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 提示：
// 0 <= nums.length <= 10⁵
// -10⁹ <= nums[i] <= 10⁹
// Related Topics 并查集 数组 哈希表 👍 2328 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        int ans=0;
        HashSet<Integer>set=new HashSet<>();
        for (int a:nums){
            set.add(a);
        }
        for (int a:set){
            if (set.contains(a-1))continue;
            int num=a;
            int length=1;
            while (set.contains(num+1)){
                num++;
                length++;
                ans=Math.max(ans,length);
            }

        }
        return ans;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int arr = new Q128LongestConsecutiveSequence().longestConsecutive(nums);
        System.out.println(arr);

    }
}
