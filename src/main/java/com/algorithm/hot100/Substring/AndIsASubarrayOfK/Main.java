package com.algorithm.hot100.Substring.AndIsASubarrayOfK;

import java.util.HashMap;

public class Main {
    /*假设我们有一个数组 nums，并且我们定义 sum 为从数组开头到当前位置 i 的元素之和，即 sum = nums[0] + nums[1] + ... + nums[i]。
如果我们想要找到一个以 i 结尾的连续子数组，它的和为 k，那么我们可以表示这个连续子数组的和为 sum - prev_sum = k，
其中 prev_sum 是某个之前的位置 j 的前缀和，即 prev_sum = nums[0] + nums[1] + ... + nums[j]。*/
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, 1);
        int sum = 0,count = 0,i = 0;
        for (i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if (hashMap.containsKey(sum - k))   count += hashMap.get(sum - k);
            hashMap.put(sum, hashMap.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        int[] nums = {1,1,1,1,1};
        int k = 2;
        Main main = new Main();
        System.out.println(main.subarraySum(nums, k));
    }
}
