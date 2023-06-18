package GreedyAlgorithm;

/**
 * @author: Dayuu
 * @description: 柠檬水找零
 */
public class leetcode860 {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0, twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            // 情况1
            if (bills[i] == 5) {
                five++;
            // 情况2
            } else if (bills[i] == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            // 情况3
            } else if (bills[i] == 20) {
                if (five > 0 && ten > 0) {  // 优先消耗10美元，因为5美元的找零用处更大，能多留着就多留着
                    five--;
                    ten--;
                    twenty++; // 其实这行代码可以删了，因为记录20已经没有意义了，不会用20来找零
                } else if (five >= 3) {
                    five -= 3;
                    twenty++; // 其实这行代码可以删了，因为记录20已经没有意义了，不会用20来找零
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
