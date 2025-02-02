package com.leecode.leetcodeproject.question.carl.DP.HuiWen;
//Q647回文子串个数  5最长回文子串
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
//todo dp[i,j] 以i开始j为末尾的子串是否是回文子串 boolean类型



public class Q647PalindromicSubstrings {
    public int countSubstrings(String s) {
        int num = 0;
        String ans = "";
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
            ans = s.substring(i, i + 1);
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i <= 1) {
                        dp[i][j] = true;
                        num++;
                    } else {
                        dp[i][j] = dp[i + 1][j - 1];
                        if (dp[i][j]){
                            num++;
                        }
                    }
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return  num;
    }
}
