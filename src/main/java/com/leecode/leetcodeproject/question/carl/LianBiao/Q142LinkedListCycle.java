package com.leecode.leetcodeproject.question.carl.LianBiao;
//142 环形链表

//leetcode submit region begin(Prohibit modification and deletion)
public class Q142LinkedListCycle {
    public ListNode detectCycle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while (fast!=null&&fast.next!=null){
            //TODO  快慢指针相遇，此时从head 和 相遇点，同时查找直至相遇
            slow=slow.next;
            fast=fast.next.next;
            if (slow==fast){
                ListNode x=head;
                ListNode cur=fast;
                while (cur!=x){
                    x=x.next;
                    cur=cur.next;
                }
                return x;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new ListNode(1);
    }

//leetcode s
}
