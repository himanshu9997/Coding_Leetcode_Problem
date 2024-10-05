class Solution {
    public Node construct(int[][] grid) {
        return build(grid, 0, 0, grid.length);
    }
    public Node build(int[][] grid, int r, int c, int size) {
        if (size == 1 || checkSame(grid, r, c, size)) {
            Node leaf = new Node(grid[r][c] == 1, true);
            return leaf;
        } else {
            int new_size = size/2;
            Node curr = new Node(true, false, 
                                build(grid, r, c, new_size), 
                                build(grid, r, c + new_size, new_size), 
                                build(grid, r + new_size, c, new_size), 
                                build(grid, r + new_size, c + new_size, new_size));
            return curr;
        }
    }
    public boolean checkSame(int[][] grid, int r, int c, int size) {
        int first = grid[r][c];
        for (int i = r; i < r+size; i++) {
            for (int j = c; j < c+size; j++) {
                if (grid[i][j] != first) {
                    return false;
                }
            }
        }
        return true;
    }
}