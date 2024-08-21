package com.algorithm.hot100.Hash.LongestContinuousSequence;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    /*基础写法*/
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Arrays.sort(nums);

        int i = 0,j = 1,sum = 1;
        while(i < nums.length-1) {
            if(nums[i]+1 == nums[i+1] )j++;
            else if(nums[i] == nums[i+1]) ;
            else j = 1;
            i++;
            if(j>sum) sum = j;

        }
        return sum;
    }


    public static void main(String[] args) {
      int[] nums = {100,4,200,1,3,2};
      Main m = new Main();
      System.out.println(m.longestConsecutive(nums));
    }
}
