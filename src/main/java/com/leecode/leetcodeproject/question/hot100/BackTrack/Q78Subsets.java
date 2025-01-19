package com.leecode.leetcodeproject.question.hot100.BackTrack;
//78 子集
//todo start标记 往后找 空集单独加
//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

// 示例 1：

//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q78Subsets {
     ArrayList<List<Integer>> ans=new ArrayList<>();
     ArrayList<Integer>path=new ArrayList<>();
     boolean[] used;

    public List<List<Integer>> subsets(int[] nums) {
        ans.add(new ArrayList<>());
        backtracking(nums,0);
        return ans;

    }
    void backtracking(int []nums,int start){
        if (start>= nums.length)return;

        for (int i=start;i<nums.length;i++){
            path.add(nums[i]);
            ans.add(new ArrayList<>(path));
            backtracking(nums,i+1);
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
       List ans = new Q78Subsets().subsets(nums);
        System.out.println(ans);

    }
}
