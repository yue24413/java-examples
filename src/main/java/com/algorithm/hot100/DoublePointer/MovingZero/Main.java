package com.algorithm.hot100.DoublePointer.MovingZero;

public class Main {

    public void moveZeroes(int[] nums) {
        int i = 0,j = 0;
        while(i<nums.length){
            if(nums[i] != 0){
                nums[j] = nums[i];
                i++;j++;
            }
            else i++;

        }
        while(j < nums.length){
            nums[j] = 0;j++;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        Main m = new Main();
        m.moveZeroes(nums);
        for(int i = 0; i<nums.length; i++){
            System.out.println(nums[i]);
        }
    }
}
