package com.leecode.leetcodeproject.question.codetop;
//给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略
//前导零。
//
// 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
//
// 返回规则如下：
//
//
// 如果 version1 < version2 返回 -1，
// 如果 version1 > version2 返回 1，
// 除此之外返回 0。
//
//
//
//
// 示例 1：
//
//
// 输入：version1 = "1.2", version2 = "1.10"
//
//
// 输出：-1
//
// 解释：
//
// version1 的第二个修订号为 "2"，version2 的第二个修订号为 "10"：2 < 10，所以 version1 < version2。
//
// 示例 2：
// 输入：version1 = "1.01", version2 = "1.001"
// 输出：0
//
// 解释：
// 忽略前导零，"01" 和 "001" 都代表相同的整数 "1"。
//
// 示例 3：
// 输入：version1 = "1.0", version2 = "1.0.0.0"
// 输出：0
// 解释：
//
// version1 有更少的修订号，每个缺失的修订号按 "0" 处理。
// 提示：
// 1 <= version1.length, version2.length <= 500
// version1 和 version2 仅包含数字和 '.'
// version1 和 version2 都是 有效版本号
// version1 和 version2 的所有修订号都可以存储在 32 位整数 中

// Related Topics 双指针 字符串 👍 445 👎 0
//todo 双指针 遇到.将数字存到integer 数组 最后比较两个数组的元素
import java.util.ArrayList;

public class Q165CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        int i=0;int  j=0;
        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer>arr2=new ArrayList<>();
        //todo 分割的逻辑  j停留在. 或者字符串末尾+1   [i,j-1]存到数组  j赋值i，重新移动j
        while (i<version1.length()){
            while (j<version1.length()&&version1.charAt(j)!='.'){
                j++;
            }
            String cur=  version1.substring(i,j);
            Integer num1= Integer.valueOf(cur);
            arr1.add(num1);
            i=j+1;
            j=i;
        }
        i=0;
        j=0;
        while (i<version2.length()){
            while (j<version2.length()||version2.charAt(j)!='.'){
                j++;
            }
            String cur=  version2.substring(i,j);
            Integer num2= Integer.valueOf(cur);
            arr2.add(num2);
            i=j+1;
            j=i;
        }

        int a=0;
        int b=0;
        Integer compnum1=0;
        Integer compnum2=0;
        while (a<arr1.size()||b<arr2.size()){
            if (a<arr1.size()){
                compnum1=arr1.get(a);
            }
            if (a>=arr1.size()){
                compnum1=0;
            }
            if (b<arr2.size()){
                compnum2=arr2.get(b);
            }
            if (b>=arr2.size()){
                compnum2=0;
            }
            if (compnum1.compareTo(compnum2)<0)return -1;
            else if (compnum1.compareTo(compnum2)>0)return 1;
            a++;
            b++;
        }
        return 0;

    }

    public static void main(String[] args) {
        System.out.println(new Q165CompareVersionNumbers().compareVersion("1.5","1.20"));
    }
}
