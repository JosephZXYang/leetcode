/**

Key points: 

	1. No need for another array to record visited status. Just change the original 
	array. All visited '1' entries set to '0',

	2. Breath-First-Search.

Difficulty: Medium
 
*/
class Solution {
    public int numIslands(char[][] grid) {
		int num = 0;

		for (int i = 0; i < grid.length; i ++) {
			for (int j = 0; j < grid[0].length; j ++) {
				if (grid[i][j] != '0') {
					grid[i][j] = '1';
					num ++;
					bfs(grid, i, j);
				}
			}
		}
		
		return num;
	}

	private void bfs(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length 
				|| grid[i][j] == '0') return;
		
		grid[i][j] = '0';
		bfs(grid, i-1, j);
		bfs(grid, i+1, j);
		bfs(grid, i, j+1);
		bfs(grid, i, j-1);
	}
}