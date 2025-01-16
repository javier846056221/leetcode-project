package com.leecode.leetcodeproject.question.hot100.hash;
//49字母异位词分组
//给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
//
// 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
//
//
//
// 示例 1:
//
//
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
//
// 示例 2:
//
//
//输入: strs = [""]
//输出: [[""]]
//
//
// 示例 3:
//
//
//输入: strs = ["a"]
//输出: [["a"]]
//
//
//
// 提示：
//
//
// 1 <= strs.length <= 10⁴
// 0 <= strs[i].length <= 100
// strs[i] 仅包含小写字母
//
//
// Related Topics 数组 哈希表 字符串 排序 👍 2094 👎 0

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Q49groupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> hashMap = new HashMap<String,ArrayList<String>>();
        for (String x : strs) {
            char[] chars = x.toCharArray();
            Arrays.sort(chars);
            ArrayList<String> arrayList=hashMap.getOrDefault(String.valueOf(chars),new ArrayList<String>());
            arrayList.add(x);
            hashMap.put(String.valueOf(chars),arrayList);
/*            if (hashMap.containsKey(String.valueOf(chars))) {
                hashMap.get(String.valueOf(chars)).add(x);
            } else {
                ArrayList arrayList = new ArrayList<String>();
                arrayList.add(x);
                hashMap.put(String.valueOf(chars), arrayList);
            }*/
        }
        return new ArrayList<>(hashMap.values());
    }
//leetcode submi
}
