package com.leecode.leetcodeproject.question.hot100.Tree;
//Q543二叉树直径
//给你一棵二叉树的根节点，返回该树的 直径 。
// 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
// 两节点之间路径的 长度 由它们之间边数表示。
// 示例 1：
//输入：root = [1,2,3,4,5]
//输出：3
//解释：3 ，取路径 [4,2,1,3] 或 [5,2,1,3] 的长度。
// 示例 2：
//输入：root = [1,2]
//输出：1
// 提示：
// 树中节点数目在范围 [1, 10⁴] 内
// -100 <= Node.val <= 100
// Related Topics 树 深度优先搜索 二叉树 👍 1650 👎 0


//todo 返回当前子树到叶子节点的最大深度（左，右）+1
// 遍历过程 ans是左 + 右 +1取max

//leetcode submit region begin(Prohibit modification and deletion)



//leetcode submit region end(Prohibit modification and deletion)

public class Q543DiameterBinaryTree{
    int ans=0;

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return ans-1;
    }
    public int depth(TreeNode root){
        if (root==null)return 0;
        int left=depth(root.left);
        int right=depth(root.right);
        ans=Math.max(ans,left+right+1);
        return Math.max(left,right)+1;

    }

}