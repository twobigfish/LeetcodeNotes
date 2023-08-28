package string;

/**
 * @author dayuu
 * @create 2023/5/7 17:35
 * KMP 前缀表
 * 参考  https://blog.csdn.net/yearn520/article/details/6729426
 *
 */
public class leetcode28 {
    //前缀表（不减一）Java实现
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) return 0;
        int[] next = new int[needle.length()];
        getNext(next, needle);

        int j = 0; // 同next数组的实现
        for (int i = 0; i < haystack.length(); i++) { // 注意i就从0开始
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) // 不匹配
                j = next[j - 1]; // 寻找之前匹配的位置
            if (needle.charAt(j) == haystack.charAt(i)) // 匹配，j和i同时向后移动
                j++; // i的增加在for循环里

            if (j == needle.length()) // 文本串s里出现了模式串t
                return i - needle.length() + 1;
        }
        return -1;

    }

    /**
     * 生成next数组逻辑：
     * 1. i代表子串的最后一位，从位置1开始每轮循环右移一位；
     * 2. j代表最长相等前缀的后一位，因为数组下标从0开始，故j的值也能代表最长相等前后缀的长度值，每当substr【j】=substr【i】时，长度+1，即j++；
     * 3. 如此可以知道substr【0, j-1】与substr【i-j+1, i】总是相等的；
     * 4. 所以若substr【j】!=substr【i】时，j要根据其之前确定的next【】数组值往前回溯，并不断比较substr【j】和substr【i】（因为前后缀要相等，最后一位必须要相等），以确定新的最长相等前后缀长度
     * 0--j看作模式串，1--i看作文本串
     * 不是abccba，而是abcabc这种对称
     */
    private void getNext(int[] next, String s) {
        int j = 0; // j指向前缀末尾位置
        next[0] = 0; // 初始化next数组
        // i指向后缀末尾位置
        for (int i = 1; i < s.length(); i++) {
            // 0--j看作模式串，1--i看作文本串  前后缀不相同
            while (j > 0 && s.charAt(j) != s.charAt(i)) // j要保证大于0，因为下面有取j-1作为数组下标的操作
                j = next[j - 1]; // 注意这里，是要找前一位的对应的回退位置
            // 找到相同的前后缀
            // j代表最长相等前缀的后一位，因为数组下标从0开始，故j的值也能代表最长相等前后缀的长度值，每当substr【j】=substr【i】时，长度+1，即j++；
            if (s.charAt(j) == s.charAt(i))
                j++;
            next[i] = j;
        }
    }
}
