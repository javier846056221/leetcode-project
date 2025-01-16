package com.leecode.leetcodeproject.question.hot100.DoublePointer;
//283.移动0
//给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
//
//        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
//
//
//
//        示例 1:
//
//        输入: nums = [0,1,0,3,12]
//        输出: [1,3,12,0,0]
//        示例 2:
//
//        输入: nums = [0]
//        输出: [0]



//leetcode submit region begin(Prohibit modification and deletion)
public class Q283MoveZero {
    public void moveZeroes(int[] nums) {
        int num=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]!=0){
                nums[num++]=nums[i];
            }
        }
        for (int j=num;j<nums.length;j++){
            nums[j]=0;
        }
    }

    public static void main(String[] args) {
        int[] nums=new int[]{0,1,0,3,12};
       new Q283MoveZero().moveZeroes(nums);
      for (int a:nums){
          System.out.println(a);
      }

    }
}
