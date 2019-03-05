/**
题目：给出两个非空链表表示两个非负整数。其中，他们各自的位数是按逆序方式存储的，并且它们的每个节点只能存储一位数字
**/

//这是一个自己实现的链表类（自身包含自身）
public class ListNode{
	int val;                   //当前节点的值
	ListNode next;             //下一个节点
	public ListNode(int x){
		val=x
	}
}

public ListNode addTwoNumbers(ListNode L1, LisNode L2){
	ListNode dummyHead = new LisNode(0);
	LisNode p=L1, q=L2, curr=dummyHead;
	int carry=0;
	
	//只有当对应位置上全是0时，停止计算
	while(p!=null || q!=null){
		
		//空的位置补为0
		int x = (p!=null) ? p.val : 0;  
		int y = (q!=null) ? p.val : 0;
		
		//当前两个数字相加，再加上前面的进位
		int sum = x + y + carry;
		carry = sum / 10;
		curr.next = new LisNode(sum%10);
		
		//将当前结果节点下移一位
		curr = curr.next;
		
		//将两个计算节点分别下移一位（如果当前节点为null，自然没有下一个节点）
		if(p!=null) p=p.next;
		if(q!=null) q=q.next;
	}
	
	if(carry>0){
		curr.next = new LisNode(carry);
	}
	
	return dummyHead.next
	
}


/**
其实就是一个加法计算器。。。。。

这道题最值得看的地方在于ListNode类的实现，它包含自身的值和下一个节点
具体算法的实行其实不难，需要注意限制条件，保证鲁壮。
**/


