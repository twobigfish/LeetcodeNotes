package hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dayuu
 * @create 2023/5/5 20:36
 */
public class leetcode202 {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        /*while (n != 1 && !set.contains(n)) {
            set.add(n);
            n = getNext(n);
        }
        return n == 1;*/
        while (n != 1) {
            set.add(n);
            n = getNext(n);
            if (set.contains(n)) {
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
