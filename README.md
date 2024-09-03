## LeetCode Hot 100

### LinkList
#### 25.K个一组翻转链表 
[K个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked)
##### 做法
思路：链表中K个一组切割，结合反转链表代码进行反转，最后再连接。
[Java 2024-08-19 时间：0ms/100.00% 内存：43.27MB/43.31%](./src/main/java/com/algorithm/hot100/LinkedList/AGroupOfKFlippedLists/Main.java)

#### 138.随机链表的复制
[随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
此题的难点在于复制指针random的指向。
<br>
<ul>
<li>
思路1：在每个节点后面新建一个一模一样的新节点，即先复制在了原有链表中，所有节点复制完成后，再通过每个结点random指向的，下一个节点(复制的一模一样的，指向random的结点)的next；
最后，再将每个复制的节点拆下来，组装成一条链表。 <br>

[Java 2024-08-20 时间：0ms/100.00% 内存：43.34MB/71.14%](./src/main/java/com/algorithm/hot100/LinkedList/ReplicationOfARandomLinkedList/Main.java)
</li>
<li>
思路2：哈希表 <br>
创建一个哈希表，遍历原有链表，作为key,同时不断创建新节点作为value放入哈希表。
则：map.get(源节点)；map.get(源节点.next)；map.get(源节点.random) <br>

[Java 2024-08-20 时间：0ms/100.00% 内存：43.28MB/83.76%](./src/main/java/com/algorithm/hot100/LinkedList/ReplicationOfARandomLinkedList/Main.java)
</li>
</ul>

### Hash
#### 1.两数之和
[两数之和](https://leetcode.cn/problems/two-sum/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
map.containsKey()的应用，用于检查给定的键是否存在于map中，若当前值是x,x+y=target，可在map中用此方法
查找y即可，即map.containsKey(target-x); <br>
[Java 2024-08-20 时间：3ms/48.68% 内存：44.08MB/17.02%](./src/main/java/com/algorithm/hot100/LinkedList/ReplicationOfARandomLinkedList/Main.java)

#### 49.字母异位词分组
[字母异位词分组](https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
先将数组的每个元素，即字符串拆成一个个字符放入一个字符数组中，然后对他们排序，得到的字符数组若不存在map中，
put，作为sort的键(字符数组转换成的字符串 String.valueOf(chars))；<br>

<ul>
<li>computeIfAbsent 方法用于在 HashMap 中获取或计算键对应的值。 <br>
当排序好的字符串在map中，没有作为键，则重新创建ArrayList<>()；若存在，加入到出现键的数组里；<br>
则：strToListMap.computeIfAbsent(String.valueOf(chars), key -> new ArrayList<>()).add(str);
最后，将这些值转换为一个 Stream，最后将这些值收集到一个新的 List 中。 <br>

[Java 2024-08-21 时间：9ms/29.25% 内存：46.68MB/65.67%](./src/main/java/com/algorithm/hot100/Hash/GroupingOfAllogramWords/Main.java)
</li>
<li>
使用map.getOrDefault(String.valueOf(chars), new ArrayList())更好理解也更省时。
return 也可以不用流，return new ArrayList,类型是List,泛型为String,即为map.values()。
相比流式操作，构造函数性能可能会更好，但对于额外操作（如过滤、排序等）不如流式方便。
</li>
</ul>

### 双指针
#### 11.盛最多水的容器
[盛最多水的容器](https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
容量的大小由两方面控制：高度与长度；
倘若现在两个指针指向开始和结束的位置，长度最长，高度取决于较短的一边；若长度内的某个高度比较短的还短，那容量的高变低，长度也更低，不可能有更大容量；
若长度内的某个高度比较短的高，长度变短，高度还是较短的一边，长度变短，高度不变，还是不可能有更大的容量。只有不断更新最短高度才有可能找到更大容量。
当一边相较于另一边更短的时候，较短的一边“内移动”一个位置，得到的容量再与当前得到的最大容量比较。
[Java 2024-08-22 时间 3ms/92.83% 内存：56.59MB/54.41%](./src/main/java/com/algorithm/hot100/DoublePointer/MaximumWater/Main.java)

#### 15.三数之和
[三数之和](https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
定一移二，定一：将数组sort后，从前往后走，从移动的两个指针中找到"sum-定一的数"。移二：两个指针，一个指向定一的后一个，一个指向数组的最后一位，来寻找两指针之和是否满足条件。 <br>
当移动的两个指针和"sum-定一的数"比较，较小时，左指针右移，反之，右指针左移
优化：定一从前往后寻找满足的只时，由于找的移二和值不变，所以排序后的数组中，如果已经找过某个定一值，可以不用再找，防止重复结果出现。 <br>
同理，移动的两个指针，如果左指针的右一个或右指针的左一个与当前值相同时，也没有必要再比较，直到得到全新的值。
[Java 2024-08-22 时间 43ms/20.22% 内存：50.15MB/88.27%](./src/main/java/com/algorithm/hot100/DoublePointer/SumOfThreeNumbers/Main.java)

#### 42.接雨水
[接雨水](https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
<ul>
<li>
思路1：从头到尾顺着找，两个指针，一旦出现下一个比当前低，left指向当前结点，right往后遍历，直到高度大于等于left停止,
left和right取较小值乘以长度，再把left和right里面夹的每个位置的高度剪掉即可。

[Java 2024-08-23 时间 1ms/69.67% 内存：45.63MB/5.74%](./src/main/java/com/algorithm/hot100/DoublePointer/CatchRainwater/Main.java)
</li>
<li>
思路2：想计算某个位置的接水量，则要找到这个位置的左边最高和右边最高，两个的较小值减去当前位置的高即为当前位置的接水量。此方法更简洁一点，相较于第一种，空间复杂度更低。

[Java 2024-08-23 时间 1ms/69.67% 内存：45.06MB/48.43%](./src/main/java/com/algorithm/hot100/DoublePointer/CatchRainwater/Main.java)
</li>
<li>
思路3:在盛最多水的容器题目中，结合思路二进行优化，既然某个位置的高度为左边最高和右边最高中更小的一个，
</li>
</ul>

### 子串
#### 560.和为k的子数组
[和为k的子数组](https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked)
#### 做法：
前缀和+哈希表。遍历到某个位置时，要判断以这个位置为尾的子数组，是否有第i位，到这个位置的另一个子数组的和为k，如果有，有几个的问题。 <br>
子数组-子数组还是为子数组,sum为从开始位置到当前位置的数组和;pre数组为前缀和数组，要得到数组和为k的数组,可将pre数组和作为哈希表的键。 <br>
利用containsKey()方法寻找是否有满足的前缀和，若有，count++，并且此前缀和对应哈希表的值++;若没有，put入哈希表初始值存为1。
[Java 2024-08-26 时间 23ms/89.25% 内存：45.43MB/38.86%](./src/main/java/com/algorithm/hot100/Substring/AndIsASubarrayOfK/Main.java)

#### 239.滑动窗口最大值
[滑动窗口最大值](https://leetcode.cn/problems/sliding-window-maximum/?envType=study-plan-v2&envId=top-100-liked)
#### 做法：
<ul>
<li>
法一：单调队列。只需遍历一遍nums数组，有两个检验条件，首先头部必须在窗口内，不在窗口内则头部指针h++，直到在窗口内； <br>
而每遍历一个位置，将它的数值与模拟队列的尾部比较，如果当前值大与模拟队列当前对应的值，则模拟队列尾部t--，直到模拟队列中有一个值大于当前值，然后将当前元素加至队尾； <br>
初始化一个辅助数组来模拟队列，用于保存可能的最大值的索引。

[Java 2024-09-03 时间 10ms/97.91% 内存：56.69MB/97.03%](./src/main/java/com/algorithm/hot100/Substring/SlidingWindowMaximum/Main.java)

</li>
<li>
法二：优先队列。定义比较器的规则：数值大的排在前面，竖直一样时，则索引大的排在前面。 <br>
先把前k个元素都放入优先队列里，pq.offer(new int[]{nums[i], i})；第一个窗口最大的数则为pq.peek()[0]；然后再遍历从索引为k开开始的数组，当窗口初始位置
不满足条件时，弹出，while(pq.peek()[1] <= i-k ) pq.poll();

[Java 2024-08-26 时间 87ms/14.91% 内存：57.52MB/62.70%](./src/main/java/com/algorithm/hot100/Substring/SlidingWindowMaximum/Main.java)

</li>
</ul>



