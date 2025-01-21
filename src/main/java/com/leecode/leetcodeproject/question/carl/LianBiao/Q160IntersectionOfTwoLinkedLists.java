package com.leecode.leetcodeproject.question.carl.LianBiao;
//160两个相交链表
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
public class Q160IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA;
        int sumA = 0;
        int sumB = 0;
        ListNode nodeA;
        ListNode nodeB;
        nodeA = headA;
        nodeB = headB;
        while (p != null) {
            sumA++;
            p = p.next;
        }
        p = headB;
        while (p != null) {
            sumB++;
            p = p.next;
        }
        int x = sumA - sumB;
        if (x > 0) {
            for (int i = 0; i < x; i++) {
                nodeA = nodeA.next;
            }
        } else if (x < 0) {
            x *= -1;
            for (int i = 0; i < x; i++) {
                nodeB = nodeB.next;
            }

        }
        while (nodeA != nodeB) {
            nodeA = nodeA.next;
            nodeB = nodeB.next;
        }
        if (nodeA != null && nodeA == nodeB) {
            return nodeA;
        } else return null;
    }

    public static void main(String[] args) {
        new ListNode(1);
    }

//leetcode s
}
