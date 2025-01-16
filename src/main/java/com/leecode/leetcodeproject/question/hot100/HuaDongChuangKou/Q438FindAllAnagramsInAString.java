package com.leecode.leetcodeproject.question.hot100.HuaDongChuangKou;
//438.字符串的所有字母异位词
//给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
// 示例 1:
//输入: s = "cbaebabacd", p = "abc"
//输出: [0,6]
//解释:
//起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
//起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。

// 示例 2:

//输入: s = "abab", p = "ab"
//输出: [0,1,2]
//解释:
//起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
//起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
//起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
// 提示:
// 1 <= s.length, p.length <= 3 * 10⁴
// s 和 p 仅包含小写字母
// Related Topics 哈希表 字符串 滑动窗口 👍 1571 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q438FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
         if (s.length()<p.length())return null;
            List<Integer> ans=new ArrayList<>();
            char[] charArray = p.toCharArray();
            Arrays.sort(charArray);
            String normal=String.valueOf(charArray);
            for (int i=0;i<s.length()-p.length()+1;i++){
                 char[] chars = s.substring(i, i + p.length()).toCharArray();
                 Arrays.sort(chars);
                 if (String.valueOf(chars).equals(normal)){
                     ans.add(i);
                 }
         }

        return ans;

    }

    public static void main(String[] args) {
        String  s = "cbaebabacd";
        String  p = "abc";
        System.out.println(new Q438FindAllAnagramsInAString().findAnagrams(s,p));


    }
}
