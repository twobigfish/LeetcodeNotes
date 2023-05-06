package string;

/**
 * @author dayuu
 * @create 2023/5/6 22:00
 */

// 剑指 Offer 05. 替换空格
/*
其实很多数组填充类的问题，都可以先预先给数组扩容带填充后的大小，然后在从后向前进行操作。
这么做有两个好处：
    不用申请新数组。
    从后向前填充元素，避免了从前向后填充元素时，每次添加元素都要将添加元素之后的所有元素向后移动的问题。
*/
public class Offer05 {
    public static String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        // 选用 StringBuilder 单线程使用，比较快，选不选都行
        StringBuilder chars = new StringBuilder();
        // 使用 chars 逐个复制 s ，碰到空格则替换，否则直接复制
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                chars.append("%20");
            } else {
                chars.append(s.charAt(i));
            }
        }
//        return new String(chars);
        return chars.toString();
    }

    /*public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //扩充空间，空格数量2倍
//        StringBuilder速度快，线程不安全；StringBuffer线程安全，但开销大
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                str.append("  ");
            }
        }
        // 若是没有空格，直接返回
        if (str.length() == 0) {
            return s;
        }
        // 有空格 双指针移动数组
        int left = s.length() - 1;
        s = s + str.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            right--;
            left--;
        }
        return new String(chars);
    }*/
}
