package com.leecode.leetcodeproject.question.carl.Queue;


import java.util.ArrayDeque;


//Q225 用队列实现栈
//请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
// 实现 MyStack 类：
// void push(int x) 将元素 x 压入栈顶。
// int pop() 移除并返回栈顶元素。
// int top() 返回栈顶元素。
// boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
// 注意：
// 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
// 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
// 示例：
//输入：
//["MyStack", "push", "push", "top", "pop", "empty"]
//[[], [1], [2], [], [], []]
//输出：
//[null, null, null, 2, 2, false]
//
//解释：
//MyStack myStack = new MyStack();
//myStack.push(1);
//myStack.push(2);
//myStack.top(); // 返回 2
//myStack.pop(); // 返回 2
//myStack.empty(); // 返回 False
// 提示：
// 1 <= x <= 9
// 最多调用100 次 push、pop、top 和 empty
// 每次调用 pop 和 top 都保证栈不为空
// 进阶：你能否仅用一个队列来实现栈。
//
// Related Topics 栈 设计 队列 👍 938 👎 0
//leetcode submit region begin(Prohibit modification and deletion)

//todo 画2个队列 一个队列进一个队列出
// 入队1个就能完成
// 但发现   出的时候第一个队列就能完成，出的时候queue1的元素从队列尾出队列，直到剩下唯一1个元素，就是pop的，其他元素保存到queue2，后面从queue2出队列到q1

class MyStack {
    ArrayDeque<Integer>queue1= new ArrayDeque<>();

    ArrayDeque<Integer> queue2= new ArrayDeque<>();
    public MyStack() {

    }

    public void push(int x) {
    queue1.addFirst(x);
    }

    public int pop() {

        int element=-1;
        while (queue1.size()>1){
            int x=queue1.removeLast();
            queue2.addFirst(x);
        }
        if (queue1.size()==1){
            element=queue1.removeLast();
        }
        while (!queue2.isEmpty()){
            int cur=queue2.removeLast();
            queue1.addFirst(cur);
        }
        return element;
    }

    public int top() {
    return queue1.getFirst();
    }

    public boolean empty() {
    return queue1.isEmpty();
    }
}

public class Q225ImplementStackUsingQueues{
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        int pop = myStack.pop();
        System.out.println(pop);

    }

}
//leetcode submit region begin(Prohibit modification and deletion)

