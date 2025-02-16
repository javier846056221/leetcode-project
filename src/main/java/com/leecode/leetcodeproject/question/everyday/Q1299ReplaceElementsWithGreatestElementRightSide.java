package com.leecode.leetcodeproject.question.everyday;

//1299 每个元素替换为右侧最大元素
//给你一个数组 arr ，请你将每个元素用它右边最大的元素替换，如果是最后一个元素，用 -1 替换。
//
// 完成所有替换操作后，请你返回这个数组。
// 示例 1：
//输入：arr = [17,18,5,4,6,1]
//输出：[18,6,6,6,1,-1]
//解释：
//- 下标 0 的元素 --> 右侧最大元素是下标 1 的元素 (18)
//- 下标 1 的元素 --> 右侧最大元素是下标 4 的元素 (6)
//- 下标 2 的元素 --> 右侧最大元素是下标 4 的元素 (6)
//- 下标 3 的元素 --> 右侧最大元素是下标 4 的元素 (6)
//- 下标 4 的元素 --> 右侧最大元素是下标 5 的元素 (1)
//- 下标 5 的元素 --> 右侧没有其他元素，替换为 -1
// 示例 2：
//输入：arr = [400]
//输出：[-1]
//解释：下标 0 的元素右侧没有其他元素。
// 提示：
// 1 <= arr.length <= 10⁴
// 1 <= arr[i] <= 10⁵
// Related Topics 数组 👍 120 👎 0
//todo 1、ans的最后一位是-1，从数组的最后往前遍历
// 2、当前位的最大值等于 后一位数组值arr[i + 1] 和 后一位最大值ans[i + 1]   取max  ，即ans[i] = max(arr[i + 1], ans[i + 1])
//
//作者：Spectre
//链接：https://leetcode.cn/problems/replace-elements-with-greatest-element-on-right-side/solutions/3077178/jiang-mei-ge-yuan-su-ti-huan-wei-you-ce-e1ufd/
//来源：力扣（LeetCode）
//著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
import java.util.HashMap;

//leetcode submit region begin(Prohibit modification and deletion)
public class Q1299ReplaceElementsWithGreatestElementRightSide {
    public int[] replaceElements(int[] arr) {
        int []ans=new int[arr.length];
        ans[arr.length-1]=-1;
        for (int i= arr.length-2;i>=0;i--){
            ans[i]=Math.max(ans[i+1],arr[i+1]);
        }
        return ans;

    }

}
