package com.leecode.leetcodeproject.question.carl.Gragh;

import java.util.ArrayDeque;

public class Q200NumberOfIslands {
    boolean[] []visit;
    int [][]fangxiang=new int[][]{{0,1},{0,-1},{-1,0},{1,0}};
    public int numIslands(char[][] grid) {
        visit=new boolean[grid.length][grid[0].length];
        int num = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1'&&visit[i][j]==false) {
                    num++;
                    bfs(grid, i, j);
                }
            }

        }
        return num;
    }
    void dfs(char[][] grid,int curx,int cury){
        //先处理本层节点，淹没
        grid[curx][cury]='0';
        for (int i=0;i<4;i++){
            int nextx=curx+fangxiang[i][0];
            int nexty=cury+fangxiang[i][1];
            if (nextx<0||nextx>= grid.length||nexty<0||nexty>= grid[0].length||grid[nextx][nexty]=='0')continue;
            dfs(grid,nextx,nexty);
        }
        //不需要取消淹没，如果是usd数组，可能需要退栈之前恢复uesd（按照顺序有关）
    }
    void bfs(char[][] grid,int x,int y){

        ArrayDeque<int []> arrayDeque=new ArrayDeque<>();
        arrayDeque.push(new int[]{x,y});
        visit[x][y]=true;
        while (!arrayDeque.isEmpty()){
            int []arr=arrayDeque.pop();
            int curx=arr[0];
            int  cury=arr[1];
            for (int i=0;i<4;i++){
                int nextx=curx+fangxiang[i][0];
                int nexty=cury+fangxiang[i][1];
                if (nextx<0||nextx>= grid.length||nexty<0||nexty>= grid[0].length||grid[nextx][nexty]=='0'||visit[nextx][nexty]==true)continue;
                arrayDeque.push(new int []{nextx,nexty});
                visit[nextx][nexty]=true;
            }

        }
    }
}
