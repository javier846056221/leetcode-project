package com.leecode.leetcodeproject.question.hot100.TanXin;
//Q56 合并区间
//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
// 示例 1：
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
//
//
// 示例 2：
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
// 提示：
// 1 <= intervals.length <= 10⁴
// intervals[i].length == 2
// 0 <= starti <= endi <= 10⁴
// Related Topics 数组 排序 👍 2505 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Q56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        ArrayList<int []> arrayList = new ArrayList<int  []>();
        arrayList.add(intervals[0]);
        for (int i=1;i< intervals.length;i++){
            int [] pre=arrayList.get(arrayList.size()-1);
            int []cur=intervals[i];
            if (cur[0]<=pre[1]){
                arrayList.remove(arrayList.size()-1);
                int []arr=new int[]{pre[0],Math.max(cur[1],pre[1])};
                arrayList.add(arr);
            }
            else arrayList.add(cur);
        }
        return arrayList.toArray(new int[arrayList.size()][2]);
    }
    public static void main(String[] args) {

    }
}
