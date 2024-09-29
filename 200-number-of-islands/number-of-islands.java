
class Solution {
    private void solve(int r, int c, char[][] grid, boolean[][] vis) {
        int n = grid.length;
        int m = grid[0].length;
        
        vis[r][c] = true;
        
        int[] dp1 = {1, -1, 0, 0};
        int[] dp2 = {0, 0, -1, 1};
        
        for (int i = 0; i < 4; i++) {
            int nr = dp1[i] + r; 
            int nc = dp2[i] + c; 
            
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && !vis[nr][nc] && grid[nr][nc] == '1') {
                solve(nr, nc, grid, vis);
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int ans = 0;
        
        boolean[][] vis = new boolean[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !vis[i][j]) {
                    solve(i, j, grid, vis);
                    ans++;
                }
            }
        }
        
        return ans;
    }
}