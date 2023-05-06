package string;

/**
 * @author dayuu
 * @create 2023/5/6 21:11
 */
public class leetcode541 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i = i + 2 * k) {
            int left = i;
            // 判断尾数够不够k个来取决right指针的位置
            int right = Math.min(left + k - 1, chars.length - 1);
            reverse(chars, left, right);
        }
        return new String(chars);
    }

    void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
