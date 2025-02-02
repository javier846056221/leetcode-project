package com.leecode.leetcodeproject.question.everyday;//给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
//Q541反转字符串
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "abcdefg", k = 2
//输出："bacdfeg"
// 
//
// 示例 2： 
//
// 
//输入：s = "abcd", k = 2
//输出："bacd"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 10⁴ 
// s 仅由小写英文组成 
// 1 <= k <= 10⁴ 
// 
//
// Related Topics 双指针 字符串 👍 643 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
public class Q541ReverseString2 {

    public String reverseStr(String s, int k) {
        StringBuffer ans=new StringBuffer();
       double reversenum=s.length()/(2.0*k);
       int num=0;
       while (reversenum>1){
           String operator=s.substring(num*2*k,num*2*k+2*k);
           String temp=reverseString(operator,k);
           ans.append(temp);
           reversenum--;
           num++;
       }
           String operator=s.substring(num*2*k,s.length());
           ans.append(reverseString(operator,k));
           return ans.toString();


    }
    public  String reverseString(String setence,int k){
      char []chars = setence.toCharArray();
     int i=0;int j=Math.min(k-1,setence.length()-1);;
      while (i<j){
         char x= chars[i];
         chars[i]=chars[j];
         chars[j]=x;
         i++;
         j--;
      }
      return String.copyValueOf(chars);
    }

    public static void main(String[] args) {
      String  s = "abcdefg";
        System.out.println(new Q541ReverseString2().reverseStr(s,2));
    }
}