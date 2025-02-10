package com.leecode.leetcodeproject.question.hot100.DP;
//32最长有效括号
//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
// 示例 1：
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
// 示例 2：
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
// 示例 3：
//输入：s = ""
//输出：0
// 提示：
// 0 <= s.length <= 3 * 10⁴
// s[i] 为 '(' 或 ')'
//
//
// Related Topics 栈 字符串 动态规划 👍 2623 👎 0
//todo dp[i]以i位置结尾的最长有效括号子串长度
//根据上面的分析，我们得到了如下两个计算公式：
//
//dp[i]=dp[i−2]+2
//
//dp[i]=dp[i−1]+dp[i−dp[i−1]−2]+2
//
//那么，求dp[i]就变成了求dp[i−1]、 dp[i−2]、dp[i−dp[i−1]−2]的子问题。
//
//这样状态也明确了：
//
//设 dp 数组，其中第 i 个元素表示以下标为 i 的字符结尾的最长有效子字符串的长度。
//
//作者：zhanganan0425
//链接：https://leetcode.cn/problems/longest-valid-parentheses/solutions/206995/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

import org.springframework.util.StringUtils;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q32LongestValidParentheses {
    public int longestValidParentheses(String s) {
        if (s==null|| s.isEmpty())return 0;
        int []dp=new int[s.length()];
        int ans=0;

        for (int  i=0;i<s.length();i++){
                if (i>0&&s.charAt(i)==')'){
                    if (i>=2&&s.charAt(i-1)=='('){
                        dp[i]=dp[i-2]+2;
                    }
                    if (i<2&&s.charAt(i-1)=='('){
                        dp[i]=2;
                    }
                    // 当前为） 前一个i-1也为） 要看与i ）对应的i-1-dp[i-1]是否是(
                    if (s.charAt(i-1)==')'){
                        //要看与i ）对应的i-1-dp[i-1]是(  ,进一步将 i-1-dp[i-1]前面的dp[i-2-dp[i-1]]加入 添加的时候判断合法性
                        if (i-1-dp[i-1]>=0&&s.charAt(i-1-dp[i-1])=='('){
                            if (i-2-dp[i-1]>=0) {
                                dp[i] = dp[i - 1] + 2 + dp[i - 2 - dp[i - 1]];
                            }
                            //不合法 直接 dp[i] = dp[i - 1] + 2;
                            else  dp[i] = dp[i - 1] + 2;
                        }
                        //默认不做处理 说明i ：）没有前面与他匹配的（ 为0
                    }
                }
            ans=Math.max(dp[i],ans);

        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,3,7,2,5,8,4,6,0,1};
        int arr = new Q32LongestValidParentheses().longestValidParentheses("()(())");
        System.out.println(arr);

    }
}
