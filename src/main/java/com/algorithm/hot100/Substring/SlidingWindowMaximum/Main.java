package com.algorithm.hot100.Substring.SlidingWindowMaximum;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int n = nums.length;
       int[] ans = new int[n - k + 1];
       int[] q = new int[n];
       int h = 0,t = -1,idx = 0;
       for (int i = 0; i < n; i++) {
           while (h <= t && q[h] <= i-k) h++;
           while (h <=t && nums[i] >= nums[q[t]]) t--;
           q[++t] = i;
           if(i>= k-1) ans[idx++] = nums[q[h]];
       }
        return ans;
    }

//    public int[] maxSlidingWindow(int[] nums, int k) {
//       int n = nums.length;
//        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//            public int compare(int[] o1, int[] o2) {
//                return o1[0] != o2[0] ? o2[0] - o1[0] : o2[1] - o1[1];
//            }
//        });
//        for (int i = 0; i < k; i++) pq.offer(new int[]{nums[i], i});
//        int[] res = new int[n - k + 1];
//        res[0] = pq.peek()[0];
//        for (int i = k; i < n; i++) {
//            pq.offer(new int[]{nums[i], i});
//            while(pq.peek()[1] <= i-k ) pq.poll();
//            res[i-k+1] = pq.peek()[0];
//        }
//        return res;
//    }



    public static void main(String[] args) {
        int[] nums = {9,10,9,-7,-4,-8,2,-6};
        int k = 3;
        Main main = new Main();
        int[] result = main.maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(result));

    }
}
