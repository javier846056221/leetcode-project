package com.leecode.leetcodeproject.question.carl.LianBiao;
//24 22交换链表节点

import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q24SwapNodesPairs{
    public ListNode swapPairs(ListNode head) {
        Stack<ListNode> stack=new Stack<ListNode>();
        ListNode vh =new ListNode(0,head);
        ListNode tail =vh;
        ListNode cur =head;
        while (true){
            ListNode start=cur;

            while (cur!=null&&stack.size()<2){
                stack.push(cur);
                cur=cur.next;
            }
            if (stack.size()<2){
                tail.next=start;
                break;
            }
            while (!stack.isEmpty()){
                tail.next= stack.pop();
                tail=tail.next;
            }
        }
        return vh.next;

    }

    public static void main(String[] args) {
        new ListNode(1);
    }

//leetcode s
}
