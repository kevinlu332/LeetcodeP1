import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class SnakeLadders {
    static int n;
    int[][] board;
    static int[] next_possible_move_amount = new int[]{1,2,3,4,5,6};
    static int max_number;
    public  int snakesAndLadders(int[][] board) {
        /*
                      1
                     /// \\\
               2 3  4      5 6 7         if not -1, move to new cell
         will use BFS
         will use a boolean[][] visited to mark the visited coor: so I will not add it to queue
        */

        n = board.length;
        this.board= board;
        max_number = n*n;
        Deque<int[]> q = new ArrayDeque<>();
        q.addLast(new int[]{n-1, 0});
        boolean[][] visited = new boolean[n][n];
        visited[n-1][0] = true;
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                int[] cur_coor = q.pollFirst();
                int cur_row = cur_coor[0];
                int cur_col = cur_coor[1];
                if(cur_row == 0 && cur_col == 0) return step;
                int cur_val = getVal(cur_row, cur_col);
                for(int next: next_possible_move_amount){
                    int next_val = cur_val + next;
                    if(next_val <= max_number) {
                        int[] next_coor = getCoor(next_val, false);
                        int next_row = next_coor[0];
                        int next_col = next_coor[1];
                        if( !visited[next_row][next_col] ){
                            visited[next_row][next_col] = true;
                            q.addLast(next_coor);
                        }
                    }
                }
            }
            step++;
        }
        return -1;
    }
    private  int[] getCoor(int val, boolean snake_used){  // 12    ////////////////////////////////////////////
        //find the next coor, get its val, if not -1, move to new point and return its coor
        int quot = (val - 1)/n;
        int rem = (val - 1)%n;
        int row = n -1 - quot;
        int col  = row%2 != n%2 ? rem: (n-1 - rem);
        if(board[row][col] == -1) return new int[]{row, col};
        else {
            if(!snake_used) return getCoor(board[row][col], true );  ////////////////
        }
        return new int[]{row, col};
    }
    private static int getVal(int row, int col){ // 4,0   /////////////////////////////////////////////
        int val = 0;
        val += (n-1-row) * n;
        val+= (row%2!= n%2 )? (col%n + 1): ( n - col ) ;
        return val;
    }
//    public static void main(String[] args){
//        int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
//        SnakeLadders s = new SnakeLadders();
//        int ans = s.snakesAndLadders(board);
//        System.out.println(ans);
//    }

}