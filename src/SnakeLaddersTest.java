import java.util.*;

class SnakeLaddersTest {
    static int n;
    int[][] board;
    static int max_number;
    static int[] next_possible_move_amount = new int[]{1,2,3,4,5,6};
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
        Deque<cell> q = new ArrayDeque<>();
        List<Integer> l = new ArrayList<>();
        l.add(1);
        q.addLast(new cell(new int[]{n-1, 0}, l));
        boolean[][] visited = new boolean[n][n];
        visited[n-1][0] = true;
        int step = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                cell c = q.pollFirst();
                int[] cur_coor = c.coor;
                List<Integer> curList = c.list;
                int cur_row = cur_coor[0];
                int cur_col = cur_coor[1];
                int destination_val = getVal(cur_row, cur_col);
                if(destination_val == max_number) { /////////////////////////////
                    System.out.println(Arrays.toString(curList.toArray()));
                    return step;
                }
                int cur_val = getVal(cur_row, cur_col);

                for(int next: next_possible_move_amount){
                    int next_val = cur_val + next;
                    if(next_val <= max_number) {
                        int[] next_coor = getCoor(next_val, false);
                        int next_row = next_coor[0]; ////////////
                        int next_col = next_coor[1];
                        if( !visited[next_row][next_col] ){
                            visited[next_row][next_col] = true;
                            List<Integer> nl = new ArrayList<>(curList);
                            nl.add(getVal(next_row, next_col));
                            q.addLast(new cell(next_coor, nl));
                        }
                    }
                }
            }
            step++;/////////////////
        }
        return -1;//////////////////
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

        class cell{
            int[] coor ;
            List<Integer> list;
            cell(int[] coor, List<Integer> list){
                this.coor = coor;
                this.list =list;
            }
        }
//    public static void main(String[] args){
////        int[][] board = new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}};
////        SnakeLaddersTest s = new SnakeLaddersTest();
////        int ans = s.snakesAndLadders(board);
////        System.out.println(ans);
////        int[][] board2 = new int[][]{{-1,-1},{-1,3}};
////        SnakeLaddersTest s2 = new SnakeLaddersTest();
////        int ans2 = s2.snakesAndLadders(board2);
////        System.out.println(ans2); //1
//        int[][] board3 = new int[][]{{-1,4,-1},{6,2,6},{-1,3,-1}};
//        SnakeLaddersTest s3 = new SnakeLaddersTest();
//        int ans3 = s3.snakesAndLadders(board3);
//        System.out.println(ans3); //2
//    }
}