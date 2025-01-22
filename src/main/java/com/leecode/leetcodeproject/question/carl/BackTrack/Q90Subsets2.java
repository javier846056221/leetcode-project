package com.leecode.leetcodeproject.question.carl.BackTrack;
//90 子集2
//todo used数组 去除同层重复+ start每次往后选
//给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的 子集（幂集）。
// 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
// 示例 1：
//输入：nums = [1,2,2]
//输出：[[],[1],[1,2],[1,2,2],[2],[2,2]]
// 示例 2：
//输入：nums = [0]
//输出：[[],[0]]
// 提示：
// 1 <= nums.length <= 10
// -10 <= nums[i] <= 10
// Related Topics 位运算 数组 回溯 👍 1258 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q90Subsets2 {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    boolean []used;

    public List<List<Integer>>  subsetsWithDup(int[] candidates) {
        used=new boolean[candidates.length];
        Arrays.sort(candidates);
        backtracking(candidates, 0);
        return ans;
    }

    void backtracking(int[] nums, int start) {
        ans.add(new ArrayList<>(path));
        if (start> nums.length)return;
        for (int i = start; i < nums.length; i++) {
            if (i>0&&nums[i]==nums[i-1]&&used[i-1]==false)continue;
            path.add(nums[i]);

            used[i]=true;
            backtracking(nums, i+1);
            path.remove(path.size() - 1);
            used[i]=false;

        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,2};
       List ans = new Q90Subsets2().subsetsWithDup(nums);
        System.out.println(ans);

    }
}
