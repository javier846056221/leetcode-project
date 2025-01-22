package com.leecode.leetcodeproject.question.carl.BackTrack;
//46 全排列
//todo used数组 去除同层重复
//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
// 示例 1：
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 示例 2：
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 提示：
// 1 <= nums.length <= 8
// -10 <= nums[i] <= 10
// Related Topics 数组 回溯 👍 1642 👎 0
//leetcode submit region begin(Prohibit modification and deletion)
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q47AllSort2 {
     ArrayList<List<Integer>> ans=new ArrayList<>();
     ArrayList<Integer>path=new ArrayList<>();
     boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums);
        return ans;
    }
    void backtracking(int [ ]nums){
        if (path.size()== nums.length){
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i =0 ; i < nums.length; i++) {
            if (used[i] == true) {
                continue;
            }
            if (i>0&&nums[i]==nums[i-1]&&used[i-1]==false)continue;
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1};
       List ans = new Q47AllSort2().permute(nums);
        System.out.println(ans);

    }
}
