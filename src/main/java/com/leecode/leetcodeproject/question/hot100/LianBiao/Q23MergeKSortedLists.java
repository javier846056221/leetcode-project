package com.leecode.leetcodeproject.question.hot100.LianBiao;
//23 hard 合并K个升序链表
//todo 优先级队列+尾插
//给你一个链表数组，每个链表都已经按升序排列。
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。
// 示例 1：
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
//
//
import com.leecode.leetcodeproject.question.carl.LianBiao.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//类放到外面

//leetcode submit region begin(Prohibit modification and deletion)
public class Q23MergeKSortedLists {


    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> listNodePriorityQueue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        ListNode vh= new ListNode(0);
        ListNode tail=vh;
        for (ListNode a:lists){
            while (a!=null){
                listNodePriorityQueue.add(a);
                a=a.next;
            }
        }
        while (!listNodePriorityQueue.isEmpty()){
            ListNode a=listNodePriorityQueue.poll();
            tail.next=a;
            tail=a;
        }
        tail.next=null;
        return vh.next;


    }

    public static void main(String[] args) {
        new ListNode(1);
    }

//leetcode s
}
