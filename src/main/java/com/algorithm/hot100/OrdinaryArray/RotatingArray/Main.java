package com.algorithm.hot100.OrdinaryArray.RotatingArray;

import java.util.Arrays;

public class Main {
        public void rotate(int[] nums, int k) {
            int n = nums.length;
            k %= n;
            int[] arr = new int[n << 1];
            System.arraycopy(nums, 0, arr, 0, n);
            System.arraycopy(nums, 0, arr, n, n);
            System.arraycopy(arr, n - k, nums, 0, n);

        }
    public static void main(String[] args) {
        int[] nums = {1,2};
        Main main = new Main();
        main.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));

    }
}
