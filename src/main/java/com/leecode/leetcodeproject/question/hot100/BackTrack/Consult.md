# 分为几类
子集，组合总和 考虑start 纵向回溯时候 往该节点 往后找！

全排列 考虑回溯不选重复节点  used数组 
模板：
···
    void backtracking(参数) {
    if (终止条件) {
    存放结果;
    return;
    }

    for (选择：本层集合中元素（树中节点孩子的数量就是集合的大小）) {
        处理本次节点;如path.add,sum+=val;
        backtracking(路径，选择列表); // 递归
        回溯，撤销处理结果 remove,sum-=..
    }
}
···
只有没有start每次往后找 才可能要used
uesd也能去同层重复 组合总和2
