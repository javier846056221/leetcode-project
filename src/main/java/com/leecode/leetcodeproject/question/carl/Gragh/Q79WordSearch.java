package com.leecode.leetcodeproject.question.carl.Gragh;
//78 子集
//todo DFS 回溯函数的参数：坐标：i，j，当前匹配的字符位置k
//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
// 示例 1：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCCED"
//输出：true
// 示例 2：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"SEE"
//输出：true
// 示例 3：
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word =
//"ABCB"
//输出：false
// 提示
// m == board.length
// n = board[i].length
// 1 <= m, n <= 6
// 1 <= word.length <= 15
// board 和 word 仅由大小写英文字母组成
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
// Related Topics 深度优先搜索 数组 字符串 回溯 矩阵 👍 1927 👎 0

//leetcode submit region begin(Prohibit modification and deletion)
public class Q79WordSearch {
    int [][]fangxiang={{0,1},{0,-1},{-1,0},{1,0}};

    boolean[][] used;

    public boolean exist(char[][] board, String word) {
        used=new boolean[board.length][board[0].length];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                boolean result = dfs(board,i,j,0,word);
                if (result)return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, int i,int j,int k, String word) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] != word.charAt(k)) return false;
        if (used[i][j]) return false;
        if (k == word.length() - 1) return true;
        used[i][j] = true;
        boolean res = false;
        for (int a = 0; a < 4; a++) {
            int nextx = i + fangxiang[a][0];
            int nexty = j + fangxiang[a][1];
           res= dfs(board, nextx, nexty, k + 1, word);
            if (res==true)return true;


        }
        used[i][j] = false;
        return res;
    }

    public static void main(String[] args) {
        char[][]board=new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String abcced = new String("ABCCED");
        System.out.println(new Q79WordSearch().exist(board,abcced));
    }
}
