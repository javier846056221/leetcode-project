package com.leecode.leetcodeproject.question.hot100.BackTrack;
//46 全排列
//todo used数组，或者path.contain去除同一路径的节点
//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
// 示例 1：
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q46AllSort {
     ArrayList<List<Integer>> ans=new ArrayList<>();
     ArrayList<Integer>path=new ArrayList<>();
     boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];

        backtracking(nums);
        return ans;
    }
    void backtracking(int [ ]nums){
        if (path.size()== nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
       List ans = new Q46AllSort().permute(nums);
        System.out.println(ans);

    }
}
