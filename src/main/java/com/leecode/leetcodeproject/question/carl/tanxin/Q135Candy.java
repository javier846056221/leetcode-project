package com.leecode.leetcodeproject.question.carl.tanxin;
//Q135分发糖果
// n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
// 你需要按照以下要求，给这些孩子分发糖果：
// 每个孩子至少分配到 1 个糖果。
// 相邻两个孩子评分更高的孩子会获得更多的糖果。
// 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
// 示例 1：
//输入：ratings = [1,0,2]
//输出：5
//解释：你可以分别给第一个、第二个、第三个孩子分发 2、1、2 颗糖果。
// 示例 2：
//输入：ratings = [1,2,2]
//输出：4
//解释：你可以分别给第一个、第二个、第三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这满足题面中的两个条件。
// 提示：
// n == ratings.length
// 1 <= n <= 2 * 10⁴
// 0 <= ratings[i] <= 2 * 10⁴
//
//
// Related Topics 贪心 数组 👍 1627 👎 0
//todo 同时顾两端太难，1.先从左到右看 当前cur比左侧大 =左侧+1
// 从右到左侧 cur比右侧大 当前和右侧+1取max
import com.leecode.leetcodeproject.Main;

public class Q135Candy {
    public int candy(int[] ratings) {
        int []tangguo=new  int [ratings.length];
        int ans=0;
        tangguo[0]=1;
        for (int i=1;i<ratings.length;i++){
            if (ratings[i]>ratings[i-1]){
                tangguo[i]=tangguo[i-1]+1;
            }else tangguo[i]=1;
        }
        for (int i=ratings.length-2;i>=0;i--){
            if (ratings[i]>ratings[i+1]){
                tangguo[i]=Math.max(tangguo[i+1]+1,tangguo[i]);
            }
        }
        for (int a:tangguo){
            ans+=a;
        }
        return ans;

    }

    public static void main(String[] args) {
        int []arr=new int[]{1,0,2};
        System.out.println(new Q135Candy().candy(arr));
    }
}
