## 50、Pow（x,n）

#### 题目：

实现`pow(x,n)`，即计算x的n次幂函数。



#### 解法一（快速幂循环）：

利用快速幂的办法解决，时间复杂度为：`O(logN)`。

需要注意`Integer.MinValue`去掉负号溢出的问题。

```java
public double myPow(double x, int n) {
        
        long N = n;
    
        if(n<0){
            x = 1/x;
            N = -N;   //-n的话在-2147483648溢出报错
        }

        double ans = 1.0;

        for(long i=N; i>0; i=i/2){
            if(i%2==1){
                ans = ans*x;
            }
            x = x*x;
        }
        
        return  ans;

    }
```



#### 解法二（快速幂递归）：

