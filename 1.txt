/**
题目：给出一个整数数组nums和目标值target，请在数组中找到和为目标值的两个整数，并返回他们的数组下表
**/


/**
方法一：暴力法
尝试所有的组合。双层for循环。第二层for循环要使数组元素排列不重复，必须从j=i+1开始（若j=i，也可，此时为相同数组元素的情况）
**/
public int[] twoSum(int[] nums, int target){
	for(int i=0; i<nums.length; i++){
		for(int j=1+1; j<nums.length; j++){
			if(nums[j]==target-nums[i]){
				return new int[]{i,j}
			}
		}
	}
	throw new IllegalAccessException("no two sum solution");
} 


/**
方法二：两遍哈希表
在方法一中，为了更加方便的查找nums[j]==target-nums[i]，而不是重新再遍历（第二层for循环时间复杂度O(n)）。使用哈希表进行查找，能够使这个过程变为O(1).
**/
public int[] twoSum(int[] nums, int target){
	Map<Integer, Integer> map = new HashMap<>();
	for(int i=0; i<nums.length; i++){
		map.put(nums[i], i)
	}
	for(int i=0; i<nums.length; i++){
		int a = target - nums[i]
		if(map.containsKey(a)&&map.get(a) != i){    //这里默认
			return new int[]{i, map.get(a)}
		}
	}
}

/**
方法三：一遍哈希表
**/
public int[] twoSum(int[] nums, int target){
	Map<Integer, Integer> map = new HashMap<>();
	for(int i=0; i<nums.length; i++){
		
	}
}


/**
1,哈希表的key查找复杂度O(1)比for循环查找复杂度O(n)快多了
2,使用哈希表的空间复杂度为O(n)
3,这是空间换时间的办法
**/