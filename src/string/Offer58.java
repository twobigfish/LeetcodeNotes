package string;

/**
 * @author dayuu
 * @create 2023/5/7 16:14
 */
// 剑指 Offer 58 - II. 左旋转字符串
public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        StringBuilder stringBuilder = new StringBuilder(s);
        reverse(stringBuilder, 0, n - 1);
        reverse(stringBuilder, n, stringBuilder.length() - 1);
        reverse(stringBuilder, 0, stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void reverse(StringBuilder s, int start, int end) {
        while (start < end) {
            char temp = s.charAt(start);
            s.setCharAt(start, s.charAt(end));
            s.setCharAt(end, temp);
            start++;
            end--;
        }
    }
}
