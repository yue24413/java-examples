package com.algorithm.hot100.OrdinaryArray.MergingInterval;

import java.util.Arrays;

public class Main {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b) -> a[0] - b[0]);
        int[][] result = new int[intervals.length][2];
        result[0] = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
           int[] interval = intervals[i];
           if(interval[0] > result[index][1]) {
               index++;
               result[index] = interval;
           }else{
               result[index][1] = Math.max(result[index][1], interval[1]);
           }
        }
        return Arrays.copyOfRange(result, 0, index+1);
    }

    public static void main(String[] args) {
        int[][] intervals= {{1,3},{2,6},{8,10},{15,18}};
        Main main = new Main();
        for (int[] interval : main.merge(intervals)) {
            System.out.println(Arrays.toString(interval));
        }
    }
}
