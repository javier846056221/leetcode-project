# 0/1背包
每个物品用无限次
背包j从0往后遍历

求价值：在完全背包中，对于一维dp数组来说，其实两个for循环嵌套顺序是无所谓的！

二维 i j遍历顺序可颠倒

一维dp数组代码如下：
```
for (int j = 0; j <= bagWeight; j++) { // 遍历背包容量
            for (int i = 0; i < weight.length; i++) { // 遍历物品
                if (j >= weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
```
变化：方案数 需要考虑循环嵌套顺序