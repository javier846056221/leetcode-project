package com.leecode.leetcodeproject.question.hot100.BackTrack;
//22 括号生成
//todo 每次传递整个数组 不需要start 但是要used数组，或者path.contain去除同一路径的节点
//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
// 示例 1：
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 示例 2：
//输入：n = 1
//输出：["()"]
// 提示：
//
//
// 1 <= n <= 8
//
//
// Related Topics 字符串 动态规划 回溯 👍 3760 👎 0
//todo 回溯法 每层可以选择的就是(和) 记录左括号l和右括号r的个数 最终l=r=n 回溯过程必须n>=l>r



import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q22GenerateParentheses {
    StringBuffer path=new StringBuffer();
    char []chars={'(',')'};
    ArrayList<String>ans=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtracking(n,0,0);
        return ans;
    }
    // '('个数l ,  ')'个数r
    void backtracking(int n,int l,int r){
       if (r>l||l>n)return;
       if (l==r&&l==n){
           ans.add(new StringBuffer(path).toString());
           return;
       }
       for (char a:chars){
           path.append(a);
         if (a=='('){ backtracking(n,l+1,r);}
         if (a==')'){ backtracking(n,l,r+1);}
         path.deleteCharAt(path.length()-1);

       }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
       List ans = new Q22GenerateParentheses().generateParenthesis(3);
        System.out.println(ans);

    }
}
