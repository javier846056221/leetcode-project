package com.leecode.leetcodeproject.question.hot100.Tree;
//Q101 对称二叉树
//给你一个二叉树的根节点 root ， 检查它是否轴对称。
//
//
//
// 示例 1：
//
//
//输入：root = [1,2,2,3,4,4,3]
//输出：true
//
//
// 示例 2：
//
//
//输入：root = [1,2,2,null,3,null,3]
//输出：false
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [1, 1000] 内
// -100 <= Node.val <= 100
//
//
//
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2876 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

//todo 递归法：设置boolean函数  判断两个树 是否是可翻转一致的 参数是2个子树
// 迭代 队列 同时操作2个结点 见随想录
public class Q101SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return ifreverse(root.left,root.right);
    }
    // 判断两个树 是否是可翻转一致的 参数是2个子树
    public  boolean ifreverse(TreeNode x1,TreeNode x2){

        if (x1==null&&x2!=null)return false;
        if (x1!=null&&x2==null)return false;
        if (x1==null&&x2==null)return true;
        if (x1.val!=x2.val)return false;
        boolean result1=ifreverse(x1.left,x2.right);
        boolean result2=ifreverse(x1.right,x2.left);
        return  result1&&result2;
    }

}
