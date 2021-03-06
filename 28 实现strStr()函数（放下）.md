## 28 实现strStr()函数

#### 题目：

给定一个haystack字符串和一个needle字符串，在haystack字符串中找出needle字符串出现的第一个位置（从0开始）。如果不存在，返回-1。

示例1：

```
输入: haystack = "hello", needle = "ll"
输出: 2
```

这根本不是easy的难度，下面依次记录`KMP（Knuth-Morris-Pratt算法）`、`Sunday算法`、`BM（Boyer-Moore算法）`、`Horsepool算法` 。

#### 解法0（暴力法，不推荐）：

两个字符串，一个一个开头字符对照着找。

~~~java
public static int searchBaoLi(String pat, String text) {
		
		int M = pat.length();
		int N = text.length();
		
		for(int i=0; i<(N-M+1); i++) {
			int j = 0;
			for(j=0; j<M; j++) {
				char a = text.charAt(i+j);
				char b = pat.charAt(j);
				if(a != b) {
					break;
				}
			}
			if(j==M) {
				return i;
			}
		}
    
		return -1;
	}
~~~

**时间复杂度：O（M*N）**



#### 解法一（KMP算法）：

[参考博客：写的特别好](![1572249317696](C:\Users\gongzihui\AppData\Roaming\Typora\typora-user-images\1572249317696.png))

假设有长字符串a，短字符串b，要在a中找到b的位置。

一般的字符串比较，就是a[i]和b[0]比较：

- 如果不相同，那么a[i+1]和b[0]接着比较。
- 如果相同，那么a[i+1]和b[1]以及后面相对应，一直比下去
  - 如果b字符串都结束了，a中的对应字符也都相同，那这个位置就找到了
  - 如果b字符串没结束，a中字符就不对应了，也就是说，只匹配成功了一部分。那么，**接下来的才是重点**
    - 如果再次从a[i+1]和b[0]开始比较，这是普通的遍历，性能差，因为要把比较过的位置重新再搜索。
    - **KMP算法：**再次从a[i+k]和b[0]开始比较，k是一个移动位数。从这里可以看出，因为少比较一些次数，所以KMP算法更加的高效。k是怎么算出来的？下面用**部分匹配表（Partial Match Table）**解释。



**部分匹配表（Partial Match Table）:**

对已经匹配到的词切片前缀，做成对应键值表。对于每个切片，找到这个切片的前缀和后缀，找到共有元素的长度，那么，这个就是这个切片在部分匹配表中对应的值。

**移动位数（k） =  已匹配的字符数  - 对应部分的匹配值 **

![](img\28-1.jpg)



