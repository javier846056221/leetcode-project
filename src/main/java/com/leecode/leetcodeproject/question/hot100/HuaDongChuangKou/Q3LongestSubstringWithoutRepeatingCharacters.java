package com.leecode.leetcodeproject.question.hot100.HuaDongChuangKou;
//3.无重复最长子串
// 示例 1:
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 示例 2:
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 示例 3:

//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 提示：
// 0 <= s.length <= 5 * 10⁴
// s 由英文字母、数字、符号和空格组成
// Related Topics 哈希表 字符串 滑动窗口 👍 10531 👎 0


import java.util.HashSet;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        char []chars=s.toCharArray();
        int left=0;int right=0;
        int maxlegth=0;
        HashSet<Character>set=new HashSet<>();
        for (right=0;right<chars.length;right++){
            if (!set.contains(chars[right])){
                set.add(chars[right]);
                maxlegth=Math.max(right-left+1,maxlegth);
            }
            else {
                while (set.contains(chars[right])){
                    set.remove(chars[left++]);
                }
                set.add(chars[right]);
            }
        }
        return maxlegth;

    }
    public int lengthOfLongestSubstring2(String s) {
        char []chars=s.toCharArray();
        int left=0;int right=0;
        int maxlegth=0;
        HashSet<Character>set=new HashSet<>();
        for (left=0;left<chars.length;left++){
            if (left>0){
                set.remove(chars[left]);
            }
            while (right<chars.length&&!set.contains(chars[right])){
                set.add(chars[right++]);
            }
            maxlegth=Math.max(right-left,maxlegth);
        }
        return maxlegth;

    }

    public static void main(String[] args) {
        String x="abcabcbb";
        System.out.println(new Q3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(x));
        System.out.println(new Q3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring2(x));

    }
}
