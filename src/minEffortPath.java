import java.util.PriorityQueue;
import java.util.Queue;

class minEffortPath {
    private final int[][] DIRS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1, 0}};
    public int minimumEffortPath(int[][] heights) {
        /*
            O(m*n*log(m*n))
            best first search: (Like dijstra's algorithm)
                expand the node with smallest effort value first
        */
        int r = heights.length;
        int c = heights[0].length;
        int[][] effort_matrix = new int[r][c];
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j ++){
                if(i==0 && j == 0) continue;
                effort_matrix[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<Cell> pq = new PriorityQueue<>(
                ( a, b) ->  { return Integer.compare(a.difference, b.difference);  }
        );
        pq.offer(new Cell(0,0,0));
        while (!pq.isEmpty()){
            Cell cell = pq.poll();
            int x= cell.x;
            int y = cell.y;
            if(x == r-1 && y == c-1) return cell.difference;
            for(int[] dir: DIRS){
                int new_x = x + dir[0];
                int new_y = y + dir[1];
                if(isValidCell(new_x, new_y, r,c)){
                    int curDiff = Math.abs(heights[x][y]- heights[new_x][new_y]);
                    int max_diff = Math.max(curDiff, effort_matrix[x][y]); ///////////////////////////
                    int prevDiff = effort_matrix[new_x][new_y];
                    if(prevDiff > max_diff ){
                        effort_matrix[new_x][new_y] = max_diff;
                        pq.offer(new Cell(new_x, new_y, max_diff));
                    }
                }
            }
        }
        return effort_matrix[r-1][c-1];
    }


    boolean isValidCell(int x, int y, int row, int col) {
        return x >= 0 && x <= row - 1 && y >= 0 && y <= col - 1;
    }
}

class Cell {
    int x;
    int y;
    Integer difference;

    Cell(int x, int y, Integer difference) {
        this.x = x;
        this.y = y;
        this.difference = difference;
    }

    // public int minimumEffortPath(int[][] heights) {
    //     /*
    //     method 2: binary search(in a budget range) + BFS(to see whether we can finish the task with a specific budget)
    //      O(m * n * log(10^6))
    //     */
    // }

    // public int minimumEffortPath(int[][] heights) {
    //     /*
    //     method 1: (not the best)
    //         lazy BFS (like dp)
    //     dp[i][j] means min effort so far in the current round
    //     dp[0][0] = 0; other positions are maxvalue;
    //     dp[i][j] = min(4 cases of max(dp[p][q], abs(h[p][q] - h[i][j])  ))
    //     run for max(r, c) times
    //      O(m*n*max(r, c))
    //     */
    //     int r = heights.length;
    //     int c = heights[0].length;
    //     int[][] dp = new int[r][c];
    //     for(int i = 0; i < r; i++){
    //         for(int j = 0; j < c; j++){
    //             if(i==0 && j ==0) continue;
    //             dp[i][j] = Integer.MAX_VALUE;
    //         }
    //     }
    //     for(int k = 0; k <Math.max(r,c); k++){
    //         for(int i = 0; i < r; i++){
    //             for(int j = 0; j < c; j++){
    //                 for(int[] dir: DIRS){
    //                     int p = i+dir[0];
    //                     int q = j + dir[1];
    //                     if(p < r && p >=0 && q < c && q >=0){
    //                         dp[i][j] = Math.min(dp[i][j], Math.max(dp[p][q], Math.abs(heights[p][q] - heights[i][j])));
    //                     }
    //                 }
    //             }
    //         }
    //     }
    //     return dp[r-1][c-1];
    // }
}