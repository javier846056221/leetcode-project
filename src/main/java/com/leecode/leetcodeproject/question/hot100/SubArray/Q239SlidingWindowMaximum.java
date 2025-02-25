package com.leecode.leetcodeproject.question.hot100.SubArray;
//239滑动窗口最大值
//给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位

// 返回 滑动窗口中的最大值 。
// 示例 1：
//输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
//输出：[3,3,5,5,6,7]
//解释：
//滑动窗口的位置                最大值
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
// 示例 2：
//输入：nums = [1], k = 1
//输出：[1]
// 提示：
// 1 <= nums.length <= 10⁵
// -10⁴ <= nums[i] <= 10⁴
// 1 <= k <= nums.length
// Related Topics 队列 数组 滑动窗口 单调队列 堆（优先队列） 👍 2975 👎 0
//todo 随想录解法  实现单调队列
//只需要维护有可能成为窗口里最大值的元素就可以了，同时保证队列里的元素数值是由大到小的。设计单调队列的时候，pop，和push操作要保持如下规则：
//
//pop(value)：如果窗口移除的元素value等于单调队列的出口元素，那么队列弹出元素，否则不用任何操作
//push(value)：如果push的元素value大于入口元素的数值，那么就将队列入口的元素弹出，直到push元素的数值小于等于队列入口元素的数值为止 再加入
//peek 队列出口首为最大值

//保持如上规则，每次窗口移动的时候，只要问que.front()就可以返回当前窗口的最大值。


import java.util.ArrayDeque;
import java.util.HashMap;

class MyQueue{
    ArrayDeque<Integer> arrayDeque= new ArrayDeque<Integer>();

    public void  chu(int val){
        if (!arrayDeque.isEmpty()&&val==arrayDeque.getLast()){
            arrayDeque.removeLast();
        }
    }
    public void ru(int val){
        while (!arrayDeque.isEmpty()&&val>arrayDeque.getFirst()){
            arrayDeque.removeFirst();
        }
        arrayDeque.addFirst(val);

    }
    public int peek(){
        return arrayDeque.getLast();
    }
}
public class Q239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        MyQueue queue=  new MyQueue();
        int []arr=new int[nums.length-k+1];
        int num=0;
        for (int i=0;i<k;i++){
            queue.ru(nums[i]);
        }
        for (int i=k;i< nums.length;i++){
            arr[num++]=queue.peek();
            queue.chu(nums[i-k]);
            queue.ru(nums[i]);
        }
        arr[num++]=queue.peek();
        return arr;
    }
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        int []arr = new Q239SlidingWindowMaximum().maxSlidingWindow(nums, 3);
        System.out.println(arr);

    }
}
