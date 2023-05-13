package string;

/**
 * @author dayuu
 * @create 2023/5/7 14:37
 */
public class leetcode151 {
    /**
     * 方法1 时间复杂度O(n) 空间复杂度O(1)
     * 1.去除首尾以及中间多余空格
     * 2.反转整个字符串
     * 3.反转各个单词
     */
    /*public String reverseWords(String s) {
        StringBuilder stringBuilder = removeSpace(s);
        reverseString(stringBuilder, 0, stringBuilder.length() - 1);
        reverseEachWord(stringBuilder);
        return stringBuilder.toString();
    }

    // 1.去除首尾以及中间多余空格
    private StringBuilder removeSpace(String s) {
        int left = 0;
        int right = s.length() - 1;
        // 去除首尾多余空格
        while (s.charAt(left) == ' ') left++;
        while (s.charAt(right) == ' ') right--;
        StringBuilder stringBuilder = new StringBuilder();
        while (left <= right) {
            if (s.charAt(left) != ' ') {
                stringBuilder.append(s.charAt(left));
                // 去除中间多余的空格
            } else if (stringBuilder.charAt(stringBuilder.length() - 1) != ' ') {
                stringBuilder.append(' ');
            }
            left++;
        }
        return stringBuilder;
    }

    // 2.反转整个字符串
    public void reverseString(StringBuilder sb, int left, int right) {
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }

    // 3.反转各个单词
    private void reverseEachWord(StringBuilder sb) {
        int left = 0;
        int right = 1;
        while (left < sb.length()) {
            *//*
                while (sb.charAt(right) != ' ' && right < sb.length()) right++;
                错误原因：应该是先判断也没有越界，再去判断是否为' '
             *//*
            while (right < sb.length() && sb.charAt(right) != ' ') right++;
            reverseString(sb, left, right - 1);
            left = right + 1;
            right = left + 1;
        }
    }*/

    /**
     * 方法2 法2
     * 创建新字符数组填充。时间复杂度O(n) 空间复杂度O(n)
     */
    public String reverseWords(String s) {
        //源字符数组
        char[] initArr = s.toCharArray();
        //新字符数组
        char[] newArr = new char[initArr.length + 1]; //下面循环添加"单词 "，最终末尾的空格不会返回
        //i来进行整体对源字符数组从后往前遍历
        int i = initArr.length - 1;
        int j = 0;
        while (i >= 0) {
            while (i >= 0 && initArr[i] == ' ') i--; // 跳过空格，找到单词的末尾字母
            int right = i;
            while (i >= 0 && initArr[i] != ' ') i--; // 确定单词的首字母的位置
            int left = i + 1; // i此时指向首字母的前一个位置，所以+1
            while (left <= right) {
                newArr[j++] = initArr[left];
                if (left == right) {
                    newArr[j++] = ' ';
                }
                left++; // 放在判断之后
            }
        }
        //若是原始字符串没有单词，直接返回空字符串；若是有单词，返回0-末尾空格索引前范围的字符数组(转成String返回)
        if (j == 0) {
            return "";
        } else {
            return new String(newArr, 0, j - 1);
        }
    }
}
