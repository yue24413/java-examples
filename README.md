## LeetCode Hot 100

### LinkList
#### 25.K个一组翻转链表 
[K个一组翻转链表](https://leetcode.cn/problems/reverse-nodes-in-k-group/description/?envType=study-plan-v2&envId=top-100-liked)
##### 做法
思路：链表中K个一组切割，结合反转链表代码进行反转，最后再连接。
[Java 2024-08-19 时间：0ms/100.00% 内存：43.27MB/43.31%](./src/main/java/com/algorithm/hot100/LinkedList/AGroupOfKFlippedLists)

#### 138.随机链表的复制
[随机链表的复制](https://leetcode.cn/problems/copy-list-with-random-pointer/?envType=study-plan-v2&envId=top-100-liked)
##### 做法：
此题的难点在于复制指针random的指向。
<br>
<ul>
<li>
思路1：在每个节点后面新建一个一模一样的新节点，即先复制在了原有链表中，所有节点复制完成后，再通过每个结点random指向的，下一个节点(复制的一模一样的，指向random的结点)的next；
最后，再将每个复制的节点拆下来，组装成一条链表。
[Java 2024-08-20 时间：0ms/100.00% 内存：43.34MB/71.14%](./src/main/java/com/algorithm/hot100/LinkedList/ReplicationOfARandomLinkedList)
</li>
<li>
思路2：哈希表 <br>
创建一个哈希表，遍历原有链表，作为key,同时不断创建新节点作为value放入哈希表。
则：map.get(源节点)；map.get(源节点.next)；map.get(源节点.random)
[Java 2024-08-20 时间：0ms/100.00% 内存：43.28MB/83.76%](./src/main/java/com/algorithm/hot100/LinkedList/ReplicationOfARandomLinkedList)

</li>
</ul>





