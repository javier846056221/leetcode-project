# 完全背包
每个物品用无限次
背包j从0往后遍历
如果求组合数就是外层for循环遍历物品，内层for遍历背包。
如果求排列数就是外层for遍历背包，内层for循环遍历物品。

求价值：在纯完全背包中，对于一维dp数组来说，其实两个for循环嵌套顺序是无所谓的！

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