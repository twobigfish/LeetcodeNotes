package GreedyAlgorithm;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 划分字母区间
 */
public class leetcode763 {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        // 统计每一个字符最后出现的位置
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, i);
        }

        int start = 0; // 每一段字符串的起始位置
        int end = 0; // 每一段字符串的终止位置
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            end = Math.max(end, map.get(c));
            if (i == end) {
                list.add(i - start + 1);
                start = i + 1;
            }
        }
        return list;
    }
}
