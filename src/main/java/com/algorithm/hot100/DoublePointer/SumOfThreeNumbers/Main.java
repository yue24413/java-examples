package com.algorithm.hot100.DoublePointer.SumOfThreeNumbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<List<Integer>>();
        for(int i =0; i < nums.length-2; i++){//要选三个数，到i为倒数第三个数时，会得到倒数第二个和倒数第一个，判断是否相加为0
           if((i> 0 && nums[i] != nums[i-1]) || i == 0){
               int j = i+1, k = nums.length-1,sum = 0 - nums[i];
               while(j<k){
                if(nums[j] + nums[k] == sum){
                    ls.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while (j<k && nums[j] == nums[j+1]) j++;
                    while (j<k && nums[k] == nums[k-1]) k--;
                    j++;k--;
                }else if(nums[j] + nums[k] < sum){
                    while(j<k && nums[j] == nums[j+1]) j++;
                    j++;
                }else if(nums[j] + nums[k] > sum){
                    while(j<k && nums[k] == nums[k-1]) k--;
                    k--;
                }
               }
           }
        }
        return ls;
    }




    public static void main(String[] args) {
        Main m = new Main();
        List<List<Integer>> ls = m.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(ls);

    }
}
