/**
 * 给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
 *
 * 示例 1:
 *
 * 输入:
 * 11110
 * 11010
 * 11000
 * 00000
 *
 * 输出: 1
 * 示例 2:
 *
 * 输入:
 * 11000
 * 11000
 * 00100
 * 00011
 *
 * 输出: 3
 * 在真实的面试中遇到过这道题？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/number-of-islands
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class NumIslands {
    public int Solution (char[][] grid ) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int nums_island = 0;
        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c){
                if (grid[r][c] == '1') {
                    ++nums_island;
                    dfs(grid, r, c);
                }
            }
        }
        return nums_island;

    }

    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    class Point{
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int Solution2 (char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int nums_island = 0;
        int[] Xmove = new int[]{-1, 1, 0, 0};
        int[] Ymove = new int[]{0, 0, -1, 1};

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c ){
                if (grid[r][c] == '1') {
                    grid[r][c] = 0;
                    LinkedList<Point> queue = new LinkedList<Point>();
                    queue.add(new Point(r, c));
                    ++nums_island;
                    while (queue.size() != 0) {
                        Point p = queue.pop();
                        for (int k = 0; k < Xmove.length; ++k) {
                            int r2 = p.x + Xmove[k], c2 = p.y + Ymove[k];
                            if (this.isValid(grid, r2, c2) && grid[r2][c2] == '1') {
                                grid[r2][c2] = 0;
                                queue.add(new Point(r2, c2));
                            }
                        }
                    }
                }
            }
        }
        return nums_island;
    }

    private boolean isValid (char[][] grid, int x, int y) {
        int nr = grid.length;
        int nc = grid[0].length;
        return !(x < 0 || x >= nr || y < 0 || y >= nc);
    }
}