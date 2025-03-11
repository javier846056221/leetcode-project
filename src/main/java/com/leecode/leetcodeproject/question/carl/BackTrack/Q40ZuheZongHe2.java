package com.leecode.leetcodeproject.question.carl.BackTrack;
//40 组合总和2 去重
//todo used数组-- 去同层重复的节点
//todo 每次找的起始位置 --从头从当前位置往后 int start
//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
// candidates 中的每个数字在每个组合中只能使用 一次 。
// 注意：解集不能包含重复的组合。
// 示例 1:

//输入: candidates = [10,1,2,7,6,1,5], target =8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//]
// 示例 2:
//输入: candidates = [2,5,2,1,2], target =5,
//输出:
//[1,2,2],
//[5]
// 提示:
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30
// Related Topics 数组 回溯 👍 1617 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q40ZuheZongHe2 {
    ArrayList<List<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> arrayList = new ArrayList<>();
    boolean[] used;
    int sum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        used = new boolean[candidates.length];
        backtracking(candidates, target, 0);
        return ans;
    }

    public void backtracking(int[] candidates, int target, int start) {
        if (sum > target) return;
        if (sum == target) {
            ans.add(new ArrayList(arrayList));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) continue;
            sum += candidates[i];
            used[i] = true;
            arrayList.add(candidates[i]);
            backtracking(candidates, target, i + 1);
            sum -= candidates[i];
            arrayList.remove(arrayList.size() - 1);
            used[i] = false;
        }

    }
    public static void main(String[] args) {
        int[] nums = new int[]{10,1,2,7,6,1,5};
        List ans = new Q40ZuheZongHe2().combinationSum2(nums,8);
        System.out.println(ans);

    }
}


