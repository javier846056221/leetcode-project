package com.leecode.leetcodeproject.interview.mianjing;
//字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没
//有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
//
// 示例 1：
//
//
//输入："aabcccccaaa"
//输出："a2b1c5a3"
//
//
// 示例 2：
//
//
//输入："abbccd"
//输出："abbccd"
//解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
//
//
// 提示：
//
//
// 字符串长度在 [0, 50000] 范围内。
//
//
// Related Topics 双指针 字符串 👍 189 👎 0


public class Q0106CompressString {
    public String compressString(String S) {
        char []chars= S.toCharArray();
        StringBuffer ans=  new StringBuffer();
        int left=0;
        int right=0;
        while (right< chars.length){
            int num=0;
            char start=chars[left];
            while (right< chars.length&&chars[right]==chars[left]){//todo 注意顺序 right不越界先到&&前面
                right++;
                num++;
            }
            left=right;
            ans.append(start);
            ans.append(String.valueOf(num));
        }
        if (ans.length()<S.length()){
            return ans.toString();
        }
        else return S;
    }
    public static void main(String[] args) {
        System.out.println(new Q0106CompressString().compressString("aabcccccaaa"));

    }
}
