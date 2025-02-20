package com.leecode.leetcodeproject.question.carl.DP.BianJiJuLi;
//1143.最长公共子序列 子序列不连续
//给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
// 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
// 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
// 示例 1：
//输入：text1 = "abcde", text2 = "ace"
//输出：3
//解释：最长公共子序列是 "ace" ，它的长度为 3 。
// 示例 2：
//输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc" ，它的长度为 3 。
// 示例 3：
//输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0 。
// 提示：
// 1 <= text1.length, text2.length <= 1000
// text1 和 text2 仅由小写英文字符组成。
// Related Topics 字符串 动态规划 👍 1675 👎 0
//todo dp[i][j]A以下标i-1为结尾的 B以j-1结尾的  最长重复子序列长度
//递推公式
//确定递推公式
//主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
//
//如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
//
//如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
//
//即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);

//leetcode submit region begin(Prohibit modification and deletion)
public class Q1143LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int [][]dp=new int[text1.length()+1][text2.length()+1];
        for (int i=1;i<=text1.length();i++){
            for (int j=1;j<=text2.length();j++){
                if (text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }

        }
        return dp[text1.length()][text2.length()];
    }

    public static void main(String[] args) {
       String a1="";
       String a2="";
        int arr = new Q1143LongestCommonSubsequence().longestCommonSubsequence(a1,a2);
        System.out.println(arr);

    }
}
