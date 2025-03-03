package com.leecode.leetcodeproject.interview.kuaishou;
//Q61旋转链表
//给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
//
//
//
// 示例 1：
//
//
//输入：head = [1,2,3,4,5], k = 2
//输出：[4,5,1,2,3]
//
//
// 示例 2：
//
//
//输入：head = [0,1,2], k = 4
//输出：[2,0,1]
//
//
//
//
// 提示：
//
//
// 链表中节点的数目在范围 [0, 500] 内
// -100 <= Node.val <= 100
// 0 <= k <= 2 * 10⁹
//
//
// Related Topics 链表 双指针 👍 1123 👎 0





import com.leecode.leetcodeproject.question.carl.LianBiao.ListNode;

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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head==null)return head;
        ListNode vh=new ListNode();
        ListNode tail=vh;
        ListNode cur=head;
        int num=0;
        while(cur!=null){
            num++;
            cur=cur.next;
        }
        if (num==0)return head;
        k=k%num;
        ListNode []arr=new ListNode[num];
        cur=head;
        int i=0;
        while(cur!=null){
            arr[i++]=cur;
            cur=cur.next;
        }

        int j=arr.length-k;
        for (int a=0;a< arr.length;a++){
            tail.next=arr[j%num];
            j++;
            tail=tail.next;
        }
        tail.next=null;
        return vh.next;

    }
}
