package hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: Dayuu
 * @description: 3. 无重复字符的最长子串
 */
public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int res = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int start = 0, end = 0; end < len; end++) {
            char element = s.charAt(end);
            if (map.containsKey(element)) {
                // 当end遇到重复字符，start应该放在上一个重复字符的位置的后一位
                // 取max：防止start前移
                // map.get(element) + 1：重复元素的下一个位置
                start = Math.max(start, map.get(element) + 1);
            }
            // 无论是否更新 start，都会更新 map和res
            map.put(element, end);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }
}
