package com.algorithm.hot100.Hash.SumOfTwoNumbers;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            int count = target - nums[i];
            if(map.containsKey(count)){
                return new int[] {map.get(count),i};
            }
            map.put(nums[i],i);
        }
        return new int [] {};
    }
    /*
    * {map.get(count), i} 是数组初始化的部分，它指定了数组的初始值。在这个例子中，数组有两个元素：
第一个元素是 map.get(count)，即从 HashMap 中根据键 count 获取的值，也就是之前存储的索引。
第二个元素是 i，即当前遍历到的元素的索引。
    * */

    public static void main(String[] args) {
        int[] numbers = new int[4];
        numbers[0] = 2;
        numbers[1] = 7;
        numbers[2] = 11;
        numbers[3] = 15;
        int target = 9;
        Main main = new Main();
        for(int i = 0;i<2;i++){
            System.out.println(main.twoSum(numbers, target)[i]);
        }

    }
}
