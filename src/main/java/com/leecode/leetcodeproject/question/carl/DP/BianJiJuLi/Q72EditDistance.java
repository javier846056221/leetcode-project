package com.leecode.leetcodeproject.question.carl.DP.BianJiJuLi;
//72编辑距离
//给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数 。
// 你可以对一个单词进行如下三种操作：
// 插入一个字符
// 删除一个字符
// 替换一个字符
// 示例 1：
//输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 示例 2：
//输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 提示：
// 0 <= word1.length, word2.length <= 500
// word1 和 word2 由小写英文字母组成
// Related Topics 字符串 动态规划 👍 3571 👎 0
//todo dp[i][j]A以下标i-1为结尾的 B以j-1结尾的 字符串的最近编辑距离
//递推公式
//根据dp[i][j]的定义
//主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
//
//如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
//
//如果text1[i - 1] 与 text2[j - 1]不相同，
//三种情况，删，加，替换，1个串加相当于另一个串删；两个依次删除，+替换；
//text1删尾部 text1[0, i - 2]与text2[0, j - 1]的距离+1（删除操作）
//text2删尾部 text1[0, i - 1]与text2[0, j - 2]的距离+1（删除操）
//替换   text1[0, i - 2]与text2[0, j - 2]的距离+1（替换）
//leetcode submit region begin(Prohibit modification and deletion)
public class Q72EditDistance {
    public int minDistance(String word1, String word2) {
        int [][]dp=new int[word1.length()+1][word2.length()+1];
        for (int i=1;i<=word1.length();i++){
            dp[i][0]=i;
        }
        for (int j=1;j<=word2.length();j++){
            dp[0][j]=j;
        }
        for (int i=1;i<=word1.length();i++){
            for (int j=1;j<=word2.length();j++){
                if (word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.min(dp[i - 1][j],  Math.min(dp[i][j - 1],dp[i-1][j-1]))+1;
                }
            }

        }
        for (int i=0;i<dp.length;i++){
            for (int j=0;j<dp[0].length;j++){
                System.out.println(dp[i][j]);
            }
        }
        return dp[word1.length()][word2.length()];
    }


    public static void main(String[] args) {
        String t1="";
        String t2="a";
        int arr = new Q72EditDistance().minDistance(t1,t2);
        System.out.println(arr);

    }
}
