package com.leecode.leetcodeproject.question.hot100.BackTrack;
//39 组合总和
//todo used数组，或者path.contain去除同一路径的节点
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
// 示例 1：
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。
// 示例 2：
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q39CombinationSum {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> path = new ArrayList<>();
    int sum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtracking(candidates, 0, target);
        return ans;
    }

    void backtracking(int[] nums, int start, int target) {
        if (sum > target) return;

        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            sum += nums[i];
            if (sum == target) {
                ans.add(new ArrayList<>(path));
            }
            backtracking(nums, i,target);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,6,7};
       List ans = new Q39CombinationSum().combinationSum(nums,7);
        System.out.println(ans);

    }
}
