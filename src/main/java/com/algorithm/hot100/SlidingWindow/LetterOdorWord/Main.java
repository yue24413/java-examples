package com.algorithm.hot100.SlidingWindow.LetterOdorWord;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        int n1 = s.length();
        int n2 = p.length();
        if(n2>n1){
            return res;
        }
        int[] sInt = new int[26];
        int[] pInt = new int[26];
        for(int i=0;i<n2;i++){
            sInt[s.charAt(i)-'a']++;
            pInt[p.charAt(i)-'a']++;
        }
        if(Arrays.equals(sInt,pInt)){
            res.add(0);
        }
        for(int i=n2;i<n1;i++){
            sInt[s.charAt(i-n2)-'a']--;
            sInt[s.charAt(i)-'a']++;
            if(Arrays.equals(sInt,pInt)){
                res.add(i-n2+1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abab";
        String p = "ab";
        Main m = new Main();
        List<Integer> l = m.findAnagrams(s, p);
        System.out.println(l);
    }
}
