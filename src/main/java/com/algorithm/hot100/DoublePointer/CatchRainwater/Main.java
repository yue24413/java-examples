package com.algorithm.hot100.DoublePointer.CatchRainwater;

public class Main {
    public int trap(int[] height) {
        int sum = 0;
        int[] leftHeight = new int[height.length];
        int[] rightHeight = new int[height.length];
        leftHeight[0] = height[0];
        rightHeight[height.length-1] = height[height.length - 1];
        for(int i = 1; i < height.length; i++){
            leftHeight[i] = Math.max(leftHeight[i-1], height[i]);
        }
        for(int i = height.length - 2; i >= 0; i--){
            rightHeight[i] = Math.max(rightHeight[i+1], height[i]);
        }
        for(int i = 0; i < height.length; i++){
            sum += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }
        return sum;
    }
//    public int trap(int[] height) {
//        int i = 0,j = 0,sum = 0,nsum = 0;
//        if(height.length == 0 || height.length == 1) return sum;
//        j = i+1;
//        while(j < height.length){
//            while(j < height.length && height[j] >= height[i]){ i++;j++;}
//            while(j < height.length && height[j] < height[i]) j++;
//            if(j == height.length) break;
//            for(int k=i; k<j-1; k++){
//                nsum = nsum + height[k+1];
//            }
//            sum = sum + Math.min(height[i],height[j])*(j-i-1)-nsum;
//            nsum = 0;
//            i = j;j++;
//        }
//        i = height.length-1;j = height.length-2;
//        while(j >= 0){
//            while(j >= 0 && height[j] >= height[i]){ i--;j--;}
//            while(j >= 0 && height[j] <= height[i]) j--;
//            if(j == -1) break;
//            for(int k=j; k<i-1; k++){
//                nsum = nsum + height[k+1];
//            }
//            sum = sum + Math.min(height[i],height[j])*(i-j-1)-nsum;
//            nsum = 0;
//            i = j;j--;
//
//        }
//        return sum;
//    }
    public static void main(String[] args) {
        int[] height = {5,4,1,2};
        Main main = new Main();
        System.out.println(main.trap(height));
    }

}
