package com.algorithm.hot100.OrdinaryArray.ProductOfAnArrayOtherThanItself;

public class Main {
    public int[] productExceptSelf(int[] nums) {
        if(nums.length == 0) return new int[0];
       int n = nums.length,num = 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if(i > 0) num *=  nums[i - 1];
            result[i] = num;
        }
        num = 1;
        for (int i = n - 1; i >= 0; i--) {
            if(i < n - 1) num *= nums[i + 1];
            result[i] *= num;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        Main m = new Main();
        int[] result = m.productExceptSelf(nums);
        for(int i = 0; i < result.length; i++){
            System.out.print(result[i] + " ");
        }
    }
}
