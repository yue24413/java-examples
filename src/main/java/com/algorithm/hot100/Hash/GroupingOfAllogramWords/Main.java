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
//    public List<List<String>> groupAnagrams(String[] strs) {
//        Map<String, List<String>> map = new HashMap<>();
//        for (String str : strs) {
//            char[] chars = str.toCharArray();
//            Arrays.sort(chars);
//            List<String> list = map.getOrDefault(String.valueOf(chars), new ArrayList());
//            list.add(str);
//            map.put(String.valueOf(chars),list);
//        }
//        return new ArrayList<List<String>>(map.values());
//
//    }

/*
computeIfAbsent() 会在键不存在时计算一个新值，并将该值与键关联。
    在计算值时可能会涉及锁的竞争，尤其是在多线程环境中，因为多个线程可能会同时尝试计算相同的键。
    更适合于需要动态计算值的场景，例如缓存计算结果。
getOrDefault() 仅返回与键关联的值，如果键不存在，则返回默认值。
    getOrDefault() 更适合于只需要读取值，且键不存在时有明确的默认值的场景。
*/

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        Main main = new Main();
        System.out.println(main.groupAnagrams(strs));
    }
}
