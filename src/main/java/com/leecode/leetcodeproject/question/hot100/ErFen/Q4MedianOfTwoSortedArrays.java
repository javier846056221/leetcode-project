package com.leecode.leetcodeproject.question.hot100.ErFen;
//Q4 2个有序数组的中位数
//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
// 算法的时间复杂度应该为 O(log (m+n)) 。
// 示例 1：
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 提示：
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -10⁶ <= nums1[i], nums2[i] <= 10⁶
// Related Topics 数组 二分查找 分治 👍 7388 👎 0




//leetcode submit region begin(Prohibit modification and deletion)

//TODO 限制了时间复杂度log，2分 hard抄的
//方法三 https://leetcode.cn/problems/median-of-two-sorted-arrays/solutions/8999/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-2

//leetcode submit region begin(Prohibit modification and deletion)
public class Q4MedianOfTwoSortedArrays {
//    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int n = nums1.length;
//        int m = nums2.length;
//        int left = (n + m + 1) / 2;
//        int right = (n + m + 2) / 2;
//        //将偶数和奇数的情况合并，如果是奇数，会求两次同样的 k 。
//        return (getKth(nums1, 0, n - 1, nums2, 0, m - 1, left) + getKth(nums1, 0, n - 1, nums2, 0, m - 1, right)) * 0.5;
//    }

//    private int getKth(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int k) {
//        int len1 = end1 - start1 + 1;
//        int len2 = end2 - start2 + 1;
//        //让 len1 的长度小于 len2，这样就能保证如果有数组空了，一定是 len1
//        if (len1 > len2) return getKth(nums2, start2, end2, nums1, start1, end1, k);
//        if (len1 == 0) return nums2[start2 + k - 1];
//
//        if (k == 1) return Math.min(nums1[start1], nums2[start2]);
//
//        int i = start1 + Math.min(len1, k / 2) - 1;
//        int j = start2 + Math.min(len2, k / 2) - 1;
//
//        if (nums1[i] > nums2[j]) {
//            return getKth(nums1, start1, end1, nums2, j + 1, end2, k - (j - start2 + 1));
//        }
//        else {
//            return getKth(nums1, i + 1, end1, nums2, start2, end2, k - (i - start1 + 1));
//        }
//    }
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int m= nums1.length;;
    int n=nums2.length;
    int []arr=new int[m+n];
    int cur=0;
    int left=0;
    int right=0;
    double ans=0.0;
    while (cur<m+n){
        if (left<m&&right<n){
            if (nums1[left]<=nums2[right]){
                arr[cur++]=nums1[left++];
            }
            else { arr[cur++]=nums2[right++];}
        }
        if (left==m&&right<n){
            arr[cur++]=nums2[right++];
        }
        if (right==n&&left<m){
            arr[cur++]=nums1[left++];
        }
    }

    if ((m+n)%2==1){
        ans=arr[(m+n-1)/2];
    }
    else ans=(arr[(m+n)/2]+arr[(m+n)/2-1])/2.0;
    return ans;
}

    public static void main(String[] args) {
        int[] nums1=new int[]{1,3};
        int[] nums2=new int[]{2};
       double arr=  new Q4MedianOfTwoSortedArrays().findMedianSortedArrays(nums1,nums2);
        System.out.println(arr);

    }
//leetcode s
}
