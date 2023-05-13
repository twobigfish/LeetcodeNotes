package string;

/**
 * @author dayuu
 * @create 2023/5/7 21:21
 */
public class leetcode459 {
    public boolean repeatedSubstringPattern(String s) {
        int j = 0;
        int[] next = new int[s.length()];
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
//        如果 next[len - 1] != 0，则说明字符串有最长相同的前后缀
        // 在由重复子串组成的字符串中，最长相等前后缀不包含的子串就是最小重复子串
        // 数组长度减去最长相同前后缀的长度相当于是第一个周期的长度，也就是一个周期的长度，如果这个周期可以被整除，就说明整个数组就是这个周期的循环。
        if (next[next.length - 1] !=0 && next.length % (next.length - (next[next.length - 1])) == 0){
            return true;
        } else {
            return false;
        }
    }
}
