package com.leecode.leetcodeproject.question.carl.DanDiaoZhan;
//42.接雨水
//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
// 示例 1：
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
// 示例 2：
//输入：height = [4,2,0,3,2,5]
//输出：9
// 提示：
// n == height.length
// 1 <= n <= 2 * 10⁴
// 0 <= height[i] <= 10⁵
// Related Topics 栈 数组 双指针 动态规划 单调栈 👍 5462 👎 0




import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q42TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        Stack<Integer> stack = new Stack<>();

        stack.push(0);
        int ans = 0;
        for (int i = 1; i < height.length; i++) {
            if (height[i] <= height[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                    int cur = stack.pop();
                    if (!stack.isEmpty()) {
                        int left = stack.peek();
                        int width = i - left - 1;
                        int high = Math.min(height[i], height[left]) - height[cur];
                        ans += width * high;
                    }
                }
                stack.push(i);
            }
        }
        return ans;


    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Q42TrappingRainWater().trap(nums));


    }
//leetcode s
}
