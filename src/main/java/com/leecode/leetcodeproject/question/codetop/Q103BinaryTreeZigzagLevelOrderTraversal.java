package com.leecode.leetcodeproject.question.codetop;
//Q103二叉树锯齿层次遍历 一左一右 Collections.reverse
//给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
//
//
//
// 示例 1：
//
//
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[20,9],[15,7]]
//
//
// 示例 2：
//
//
//输入：root = [1]
//输出：[[1]]
//
//
// 示例 3：
//
//
//输入：root = []
//输出：[]
//
//
//
//
// 提示：
//
//
// 树中节点数目在范围 [0, 2000] 内
// -100 <= Node.val <= 100
//
//
// Related Topics 树 广度优先搜索 二叉树 👍 947 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

import java.sql.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        ArrayDeque<TreeNode> arrayDeque=  new ArrayDeque<TreeNode>();
        ArrayList <List<Integer>> ans= new ArrayList<List<Integer>>();
        if (root==null)return ans;
        arrayDeque.addLast(root);
        while (!arrayDeque.isEmpty()){
            int size=arrayDeque.size();
            ArrayList<Integer> arrayList=  new ArrayList<Integer>();
            for (int i=0;i<size;i++){
                TreeNode cur= arrayDeque.pop();
                arrayList.add(cur.val);
                if (cur.left!=null)arrayDeque.addLast(cur.left);
                if (cur.right!=null)arrayDeque.addLast(cur.right);
            }
            ans.add(arrayList);
        }
        for (int i=0;i<ans.size();i++){
            if (i%2==1){
                List cur=   ans.get(i);
                Collections.reverse(cur);
            }
        }
        return ans;

    }
}
//leetc