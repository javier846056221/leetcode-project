package com.leecode.leetcodeproject.question.carl.LianBiao;
//24 22交换链表节点

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q19RemoveNthNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode vh=new ListNode(0,head);
        ListNode fast=vh;
        ListNode slow=vh;
        int k=n;
        while(k>=0){
            fast=fast.next;
            k--;
        }
        while (fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return vh.next;
    }

    public static void main(String[] args) {
        new ListNode(1);
    }

//leetcode s
}
