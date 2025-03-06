package com.leecode.leetcodeproject.question.codetop;
//Q415 （模拟）字符串相加
//给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
// 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
// 示例 1：
//输入：num1 = "11", num2 = "123"
//输出："134"
// 示例 2：
//输入：num1 = "456", num2 = "77"
//输出："533"
//
//
// 示例 3：
//输入：num1 = "0", num2 = "0"
//输出："0"
// 提示：
// 1 <= num1.length, num2.length <= 10⁴
// num1 和num2 都只包含数字 0-9
// num1 和num2 都不包含任何前导零
// Related Topics 数学 字符串 模拟 👍 865 👎 0

public class Q415AddStrings {
    public String addStrings(String num1, String num2) {
        char [] nums1=num1.toCharArray();
        char [] nums2=num2.toCharArray();
        String ans=new String();
        int i= nums1.length-1;
        int j=nums2.length-1;
        int addnum=0;
        int cursum=0;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && j >= 0) {
                cursum = nums1[i] - '0' + nums2[j] - '0' + addnum;
            }
            if (i >= 0 && j< 0) {
                cursum = nums1[i] - '0'  + addnum;
            }
            if (j >= 0 && i< 0) {
                cursum = nums2[j] -'0'  + addnum;

            }
            //先判断sum<0 后面再判断>0 不可颠倒 因为先大于0 sum取余会<10 还会再走sum<10的逻辑
            if (cursum<10){
                addnum=0;
            }
            if (cursum >= 10) {
                addnum = 1;
                cursum = cursum % 10;
            }


            ans = String.valueOf(cursum) + ans;
            i--;
            j--;
        }
        if (addnum!=0){
            ans=String.valueOf(addnum)+ans;
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println(new Q415AddStrings().addStrings("6", "501"));
    }

}
