package com.leecode.leetcodeproject.question.carl.DP.multidp;

public class Q63 {
    //给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][
//n - 1]）。机器人每次只能向下或者向右移动一步。
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
//
// 返回机器人能够到达右下角的不同路径数量。
//
// 测试用例保证答案小于等于 2 * 10⁹。
//
//
//
// 示例 1：
//
//
//输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
//输出：2
//解释：3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右
//
//
// 示例 2：
//
//
//输入：obstacleGrid = [[0,1],[0,0]]
//输出：1
//
//
//
//
// 提示：
//
//
// m == obstacleGrid.length
// n == obstacleGrid[i].length
// 1 <= m, n <= 100
// obstacleGrid[i][j] 为 0 或 1
//
//
// Related Topics 数组 动态规划 矩阵 👍 1357 👎 0


    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int m=obstacleGrid.length;
            int n=obstacleGrid[0].length;
            int [] [] dp=new int[m][n];
            for (int i=0;i<obstacleGrid[0].length;i++){
                if (obstacleGrid[0][i]!=1) {
                    dp[0][i] = 1;
                }
                else break;
            }
            for (int j=0;j<obstacleGrid.length;j++){
                if (obstacleGrid[j][0]!=1) {
                    dp[j][0] = 1;
                } else break;

            }
            for (int i=1;i<obstacleGrid.length;i++){
                for (int j=1;j<obstacleGrid[0].length;j++){
                    if (obstacleGrid[i][j]==1){
                        dp[i][j]=0;
                    }
                    else dp[i][j]=dp[i][j-1]+dp[i-1][j];
                }

            }
            return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
