package hashtable;

/**
 * @author dayuu
 * @create 2023/5/5 20:00
 */
public class leetcode242 {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++; // 并不需要记住字符a的ASCII，只要求出一个相对数值就可以了
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }

        for (int i : record) {
            if (i != 0) {
                return false; // record数组如果有的元素不为零0，说明字符串s和t 一定是谁多了字符或者谁少了字符。
            }
        }
        return true; // record数组所有元素都为零0，说明字符串s和t是字母异位词
    }
}
