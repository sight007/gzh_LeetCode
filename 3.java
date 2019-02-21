/**
��Ŀ������һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ���
**/

/**
����һ����������������
1�������е����ַ�������һ��
2��������ַ����������ظ��ַ�������true
3���ҵ����ĳ���
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
���㣺1��Ѱ�Ҳ��ظ��ַ����ַ����ķ�����������Set���ص㣬��֮ǰHashMap�����ص㣬������ͬ��֮�
	  2��j=i+1����������֮ǰ��Ŀ�ı����ƽ�Ҳ��ͬ�����ǣ�j�����ֵΪn�������ص㣬������һ�ꡣ
	  3������Math.max()����䳤�ȣ�����������û�뵽�ġ�
**/





