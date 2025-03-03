package com.leecode.leetcodeproject.question.hot100.Tree;
//q437路劲总和3
//
// 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
// 示例 1
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 示例 2：
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 2
// 提示:
// 二叉树的节点个数的范围是 [0,1000]
// -10⁹ <= Node.val <= 10⁹
// -1000 <= targetSum <= 1000
// Related Topics 树 深度优先搜索 二叉树 👍 1997 👎 0
//todo dfs是从根节点往下路径加和 找路径个数
//todo 本函数是本数所有路径个数，要递归左+右+从根往下找
class Solution {
    int ans=0;
    public int pathSum(TreeNode root, int targetSum) {
        if (root==null)return 0;
        dfs(root,targetSum,0);
        pathSum(root.left,targetSum);
        pathSum(root.right,targetSum);
        return ans;

    }
    public void dfs(TreeNode cur,int targetSum,long curSum){
        if (cur==null)return;
        curSum+=cur.val;
        if (curSum==targetSum)ans++;
        dfs(cur.left,targetSum,curSum);
        dfs(cur.right,targetSum,curSum);
        curSum-=cur.val;

    }

}
