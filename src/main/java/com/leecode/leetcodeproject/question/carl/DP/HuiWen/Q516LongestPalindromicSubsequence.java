package com.leecode.leetcodeproject.question.carl.DP.HuiWen;
//Q516最长回文子序列
//给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
//
// 回文字符串 是正着读和倒过来读一样的字符串。
//
// 子字符串 是字符串中的由连续字符组成的一个序列。
// 示例 1：
//输入：s = "abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 示例 2：
//输入：s = "aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa"

// 提示：

// 1 <= s.length <= 1000
// s 由小写英文字母组成
// Related Topics 双指针 字符串 动态规划 👍 1407 👎 0
//todo dp[i,j] 字符串s在[i, j]范围内最长的回文子序列的长度为dp[i][j]



public class Q516LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) { // 从后往前遍历 保证情况不漏
            dp[i][i] = 1; // 初始化
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], Math.max(dp[i][j], dp[i][j - 1]));
                }
            }
        }
        return dp[0][len - 1];
    }
}
