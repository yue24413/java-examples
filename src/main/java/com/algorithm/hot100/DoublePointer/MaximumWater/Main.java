package com.algorithm.hot100.DoublePointer.MaximumWater;
public class Main {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if(Math.max(maxArea, (right - left) * height[left])>maxArea) maxArea = Math.max(maxArea, (right - left) * height[left]);
                left++;
            }else {
                if(Math.max(maxArea, (right - left) * height[right])>maxArea) maxArea = Math.max(maxArea, (right - left) * height[right]);
                right--;
            }
        }
        return maxArea;
    }
    public static void main(String[] args) {
        int[] height = { 1,8,6,2,5,4,8,3,7 };
        Main main = new Main();
        System.out.println(main.maxArea(height));
    }
}
