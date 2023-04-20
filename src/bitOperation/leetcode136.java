package bitOperation;

import java.util.HashMap;

/**
 * @author dayuu
 * @create 2023/4/20 10:56
 */
public class leetcode136 {
    public int singleNumber1(int[] nums) {
    /*
   		这里运用异或运算的性质：
	    (1) ⼀个数和它本身做异或运算结果为 0，即 a ^ a = 0;
   		(2) ⼀个数和 0 做异或运算的结果为它本身，即 a ^ 0 = a;
   		对于本题，只要把所有数字进行异或，成对的数字就会变成 0，落单的数字和 0 做异或还是它本身，
   		所以最后异或的结果就是只出现⼀次的元素。
	*/
        int single = 0;
        for (int num : nums) {
            single = single ^ num;
        }
        return single;
    }

    public int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
//            getOrDefault() 方法获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值。
//            put() 方法将指定的键/值对插入到 HashMap 中
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
         for (Integer i : hashMap.keySet()){
//             get() 方法获取指定 key 对应对 value
             if (hashMap.get(i) == 1){
                 return i;
             }
         }
         return 0;
    }
}
