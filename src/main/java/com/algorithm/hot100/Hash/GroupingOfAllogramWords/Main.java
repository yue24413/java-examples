package com.algorithm.hot100.Hash.GroupingOfAllogramWords;

import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> strToListMap = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            strToListMap.computeIfAbsent(String.valueOf(chars), k -> new ArrayList<>()).add(str);
    /*提供了一个 Supplier 函数：key -> new ArrayList<>()。这里使用了一个 Lambda 表达式来定义这个函数。
这个函数不使用 key 参数，因为 Supplier 函数不需要参数。它只是返回一个新的 ArrayList<String>。*/
        }
        /*将这些值转换为一个 Stream，最后将这些值收集到一个新的 List 中*/
        return strToListMap.values().stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Main main = new Main();
        System.out.println(main.groupAnagrams(strs));
    }
}
