/**
题目：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
**/

/**
方法一：暴力法（遍历）
1，把所有的子字符串都切一遍
2，如果子字符串都不含重复字符，返回true
3，找到最大的长度
**/

public class Solution{
	public int lengthOfLongestSubstring(String s){
		int n = s.length();
		int ans = 0;
		for(int i=0; i<n; i++){
			for(int j=i+1; j<=n; j++){
				if(allUnique(s,i,j)) ans = Math.max(ans, j-i)
			}
		}
		return ans;
	}
	
	public boolean allUnique(String s, int start, int end){
		Set<Character> set = new HashSet();
		for(int i=start; j<end; i++){
			Character ch = s.charAt(i);
			if(set.contains(ch)) return false;
			set.add(ch)
		}
		return true;
	}
}

/**
看点：1，寻找不重复字符的字符串的方法，利用了Set的特点，跟之前HashMap键的特点，有异曲同工之妙。
	  2，j=i+1，这个设计与之前题目的暴力破解也相同。但是，j的最大值为n，很有特点，年减年加一年。
	  3，利用Math.max()求出其长度，这是我万万没想到的。
**/






/**
 * 方法二：滑动窗口发
 * 	   1，从未见过这么好的方法，是我孤陋寡闻了。。。。max()才是核心
 * 	   2，详情参见https://github.com/MisterBooo/LeetCodeAnimation的动画展示
 * 	   3，设置前后两个指针，把前指针的字符放进set，后指针不变，记录max值；如果前指针字符已经有了，后指针向前移；总之，计算set里面没有重复字符的最大长度
 * 	   4, j++ 先运算后加1， ++j,先加1后运算
 */
public class Solution{
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		Set<Character> set = new HashSet<>();
		
		int ans=0, i=0, j=0;
		while(i<n && j<n) {
			if(!set.contains(s.charAt(j++))) {
				set.add(s.charAt(j++));
				ans = Math.max(ans, j-i);
			}else {
				set.remove(s.charAt(i++));
			}
		}
		
		return 0;
	}
}


/**
 * 方法3：滑动窗口的优化
 * 
 * 	 在上面使用set时，总是发现如果下一个字符在set中时，需要把set左边的值一个一个的去除，直到重复的字符消失。
 *  我们的目的就是删除重复字符在内的开头字符，所以，可以直接定位到重复字符，从它的下一个位置开始，去计算长度
 *  
 *  max()这个函数运用真是叹为观止。。。。666
 * 
 */
public class Solution{
	public int lengthOfLongestSubstring(String s) {
		
	}
}

























