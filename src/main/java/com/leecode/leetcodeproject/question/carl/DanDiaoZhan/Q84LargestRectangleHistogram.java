package com.leecode.leetcodeproject.question.carl.DanDiaoZhan;
//84柱状图最大矩形
//给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
//
// 求在该柱状图中，能够勾勒出来的矩形的最大面积。
//
//
//
// 示例 1:
//输入：heights = [2,1,5,6,2,3]
//输出：10
//解释：最大的矩形为图中红色区域，面积为 10
//
//
// 示例 2：
//
//
//
//
//输入： heights = [2,4]
//输出： 4
// 提示：
//
//
// 1 <= heights.length <=10⁵
// 0 <= heights[i] <= 10⁴
//
//
// Related Topics 栈 数组 单调栈 👍 2864 👎 0

//TODO 最大矩形的面积 当前元素i为基准  出栈mid mid左侧第一个小的下表l，右侧小的下标r=i w=r-l-1 h=height[mid] 计算面积 当前以mid位置高度 往左侧和右侧拓展 形成面积 与接雨水相反
// 细节  拓展数组 左右加0 保证每个元素左右可以找到比它小的位置

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q84LargestRectangleHistogram {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer>stack=  new Stack<Integer>();
        stack.push(0);
        int ans=0;
        int []arr=new int[heights.length+2];
        for (int i=0;i<heights.length;i++){
            arr[i+1]=heights[i];
        }
        for (int i=1;i<arr.length;i++){
            if (arr[i]>=arr[stack.peek()]){
                stack.push(i);
            }
            else {
                while (arr[i]<arr[stack.peek()]){
                    int cur=stack.pop();
                    if (!stack.isEmpty()){
                        int left=stack.peek();
                        int right=i;
                        int w=right-left-1;
                        ans=Math.max(w*arr[cur],ans);
                    }
                }
                stack.push(i);
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums=new int[]{2,1,5,6,2,3};
        System.out.println(new Q84LargestRectangleHistogram().largestRectangleArea(nums));


    }
//leetcode s
}
