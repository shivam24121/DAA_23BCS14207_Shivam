class Solution {

    static int[] dx={0,1,-1,0};
    static int[] dy={1,0,0,-1};

    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int ct=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    dfs(grid,i,j);
                    ct++;
                }
            }
        }
        return ct;
    }
    public void dfs(char[][] grid,int x,int y){
        if(x<0 || x>=grid.length || y<0 || y>=grid[0].length || grid[x][y]!='1')return;

        grid[x][y]='@';
        for(int i=0;i<4;i++){
            int xx=x+dx[i];
            int yy=y+dy[i];
            dfs(grid,xx,yy);
        }
    }
}
