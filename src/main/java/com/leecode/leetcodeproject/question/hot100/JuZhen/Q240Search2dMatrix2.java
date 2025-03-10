package com.leecode.leetcodeproject.question.hot100.JuZhen;
//Q240 搜索二维矩阵 2
//编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
// 每行的元素从左到右升序排列。
// 每列的元素从上到下升序排列。
// 示例 1：
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 5
//输出：true
// 示例 2：
//输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21
//,23,26,30]], target = 20
//输出：false
// 提示：
// m == matrix.length
// n == matrix[i].length
// 1 <= n, m <= 300
// -10⁹ <= matrix[i][j] <= 10⁹
// 每行的所有元素从左到右升序排列
// 每列的所有元素从上到下升序排列
// -10⁹ <= target <= 10⁹
// Related Topics 数组 二分查找 分治 矩阵 👍 1597 👎 0
//todo 从右上角开始 起始matrix[x][y]是这行最大的元素了 <target 说 往下找 x++；
//                  matrix>target 往左找 左边是小的方向 y--；


//leetcode submit region begin(Prohibit modification and deletion)
public class Q240Search2dMatrix2 {




    public boolean searchMatrix(int[][] matrix, int target) {
        int x=0;int y=matrix[0].length-1;
        boolean ans=false;
        while (x< matrix.length&&y>=0){
            if (matrix[x][y]==target){
                ans=true;
                break;
            }
            else if (matrix[x][y]<target){
                x++;
            }
            else y--;

        }
    return ans;
    }


//leetcode s
}
