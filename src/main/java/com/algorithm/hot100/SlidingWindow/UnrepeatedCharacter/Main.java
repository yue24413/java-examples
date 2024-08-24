package com.algorithm.hot100.SlidingWindow.UnrepeatedCharacter;

public class Main {
    public int lengthOfLongestSubstring(String s) {
        int[] counts = new int[128];
        for (int i = 0; i < 128; i++) counts[i] = -1;
        int start = 0, len = 0;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i);//charAt(i): 这个方法需要一个整数参数 i，表示要访问的字符的位置（索引）
            start = Math.max(start, counts[c] + 1);
            len = Math.max(len, i - start + 1);
            counts[c] = i;
        }
        return len;
    }
    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.lengthOfLongestSubstring("abcabcbb"));
    }
}
