class Solution {
    public int numIslands(char[][] grid) {
        int n=grid.length,m=grid[0].length,cnt=0;
        boolean[][] visited=new boolean[n][m];
        int i,j;
        for(i=0;i<n;i++)
        {
            for(j=0;j<m;j++)
            {
                if(!visited[i][j] && grid[i][j]=='1')
                {
                    cnt++;
                    count(i,j,grid,visited);
                }
            }
        }
        return cnt;
    }
    public void count(int i,int j,char[][] grid,boolean[][] visited)
    {
        int[][] dir={{0,-1},{-1,0},{0,1},{1,0}};
        int n=grid.length,m=grid[0].length;
        Queue<int[]> q=new LinkedList<>();
        q.add(new int[]{i,j});
        visited[i][j]=true;
        while(!q.isEmpty())
        {
            int[] x=q.poll();
            int r=x[0],c=x[1];
            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<m && !visited[nr][nc] && grid[nr][nc]=='1')
                {
                    q.add(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
    }
}