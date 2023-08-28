package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dayuu
 * @create 2023/5/5 20:36
 */

public class leetcode202 {
    public boolean isHappy(int n) {
        // 要快速判断一个元素是否出现集合里的时候，就要考虑哈希法了
        Set<Integer> set = new HashSet<>();
        /*while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;*/
        while (n != 1) {  // 题目中说了，要么最后结果变为1，要么无限循环
            set.add(n);
            n = getNext(n);
            if (set.contains(n)) { // 有重复的数，说明有循环
                return false;
            }
        }
        return true;
    }

    public int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int temp = n % 10;
            sum = sum + temp * temp;
            n = n / 10;
        }
        return sum;
    }
}
