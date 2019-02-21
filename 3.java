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





