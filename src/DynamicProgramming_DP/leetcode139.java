package DynamicProgramming_DP;

import java.util.HashSet;
import java.util.List;

/**
 * @author: Dayuu
 * @description: 139.单词拆分
 */
/*
    1.确定dp数组（dp table）以及下标的含义
    2.确定递推公式
    3.dp数组如何初始化
    4.确定遍历顺序
    5.举例推导dp数组
*/
public class leetcode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // 初始化

        // 先背包 后物品
        for (int i = 1; i <= s.length(); i++) { // 背包容量
            for (int j = 0; j < i; j++) { // j <i:字符串长度j < 背包的容量i
                if (wordDict.contains(s.substring(j, i)) && dp[j]) {  // dp[j] = dp[i-(i-j)] 和其他的题目一样，获取上一个状态，即往前(i-j)个距离
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}
