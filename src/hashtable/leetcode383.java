package hashtable;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dayuu
 * @create 2023/5/6 15:04
 */
public class leetcode383 {
    public boolean canConstruct(String ransomNote, String magazine) {
//        法1  哈希表大小有限，有数组实现哈希法更快
        int[] record = new int[26];

        for (char c : magazine.toCharArray()) {
            record[c - 'a'] += 1;
        }

        for (char c : ransomNote.toCharArray()) {
            record[c - 'a'] -= 1;
        }

        for (int i : record) {
            if (i < 0) {
                return false;
            }
        }

        return true;

//        法2
        /*Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                map.put(magazine.charAt(i), map.get(magazine.charAt(i)) + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i)) && map.get(ransomNote.charAt(i)) > 0){
                map.put(ransomNote.charAt(i), map.get(ransomNote.charAt(i))-1);
            } else {
                return false;
            }
        }
        return true;*/
    }
}
