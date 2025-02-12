package com.leecode.leetcodeproject.question.hot100.Tree;
//Q124 二叉树最大路径和 与二叉树直径类似 递归
//二叉树中的 路径 被定义为一条节点序列，序列中每对相邻节点之间都存在一条边。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定
//经过根节点。
// 路径和 是路径中各节点值的总和。
// 给你一个二叉树的根节点 root ，返回其 最大路径和 。
// 示例 1：
//
//
//输入：root = [1,2,3]
//输出：6
//解释：最优路径是 2 -> 1 -> 3 ，路径和为 2 + 1 + 3 = 6
//
// 示例 2：
//
//
//输入：root = [-10,9,20,null,null,15,7]
//输出：42
//解释：最优路径是 15 -> 20 -> 7 ，路径和为 15 + 20 + 7 = 42
// 提示：
// 树中节点数目范围是 [1, 3 * 10⁴]
// -1000 <= Node.val <= 1000
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 2341 👎 0


//todo 左子树往深处走查 最大的路径和（叶子节点是<0 与0取max 可能不走到叶子） +右子树最大的路径和 +当前节点的val 不断更新ans
// 递归函数返回当前子树最大的路径和 （左，右）取max +当前节点 与0取max

//leetcode submit region begin(Prohibit modification and deletion)



//leetcode submit region end(Prohibit modification and deletion)
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Q124BinaryTreeMaximumPathSum{
    int ans=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }
    public  int dfs(TreeNode root){
        if (root==null)return 0;
        int left=dfs(root.left);
        int right=dfs(root.right);
        ans=Math.max(ans,left+right+root.val);
        return Math.max(Math.max(left, right) + root.val, 0);
    }

    public  int dfs1(TreeNode root) {
        if (root==null)return 0;
        int leftval=Math.max(dfs(root.left),0);
        int rightval=Math.max(dfs(root.right),0);
        ans=Math.max(ans,leftval+rightval+root.val);
        return Math.max(leftval,rightval)+root.val;

    }

//    public int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        //计算左边分支最大值，左边分支如果为负数还不如不选择
//        int leftMax = Math.max(0, dfs(root.left));
//        //计算右边分支最大值，右边分支如果为负数还不如不选择
//        int rightMax = Math.max(0, dfs(root.right));
//        //left->root->right 作为路径与已经计算过历史最大值做比较
//        max = Math.max(max, root.val + leftMax + rightMax);
//        // 返回经过root的单边最大分支给当前root的父节点计算使用
//        return root.val + Math.max(leftMax, rightMax);
//    }

}