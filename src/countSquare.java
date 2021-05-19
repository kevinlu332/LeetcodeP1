import java.util.Arrays;

class countSquare {
    int[][] matrix;
    int m;
    int n;
    int[][] right ;
    int[][] down;
    public int countSquares(int[][] matrix) {
        //method 2: dp[1][j] = length of square whose right lower vertex is at j
        int[][] dp = new int[2][n];
        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;
        int count = 0;
        dp[0] = Arrays.copyOf(matrix[0], n);
        dp[1] = new int[n];   ////////////////
        for(int x: dp[0])count+=x;

        for(int i = 1; i < m; i++){
            if(i!=1) dp[0] = Arrays.copyOf(dp[1], n);
            dp[1][0] = matrix[i][0];
            for(int j = 1; j < n; j++){
                if(matrix[i][j]!=0)   ////////////////////
                    dp[1][j] = Math.min(dp[1][j-1], Math.min(dp[0][j], dp[0][j-1]))+1;
                else dp[1][j]=0;   //////////////////////
            }
            for(int x: dp[1])count+=x;
        }
        return count;
    }

    public static void main(String[] args){
        int[][] m = new int[][]{
                {1,0,1},
                {1,1,0},
                {1,1,0}
        }; // 7
        int[][] m2 = new int[][]{
                {0,0,1},
                {0,1,0},
                {0,0,0}
    };
        System.out.println(new countSquare().countSquares(m));
    }
//     public int countSquares(int[][] matrix) {
    //method 1: (not best)
    //use of right[][] and down[][]
//         this.matrix = matrix;
//         m = matrix.length;
//         n = matrix[0].length;
//         right = getRightMatrix();
//         down = getDownMatrix();
//         int count = 0;
//         for(int i = 0; i < m ; i++){
//             for(int j = 0; j < n; j++){
//                 if(matrix[i][j]!=0) count+=getSquaresCount(i,j);
//             }
//         }
//         return count;
//     }
//     private int getSquaresCount(int i, int j){
//         int count = 0;
//         int len = 1;
//         while(i+len-1 < m && j + len-1 < n){
//             boolean done_loop = false;
//             for(int k = 0; k < len; k++){

//                 if(right[i+k][j+len-1]==0 || down[i+len -1][j + k]==0) {
//                     done_loop = true;
//                     break;
//                 }
//             }
//             if(done_loop) break;
//             count++;
//             len++;
//         }
//         return count;
//     }
//     private int[][] getRightMatrix(){
//             int[][] mat = new int[m][n];
//             for(int i = 0; i < m; i++){
//                 for(int j = 0; j < n; j++){

//                     if(matrix[i][j] == 0) continue;
//                     if(j-1<0)mat[i][j] =matrix[i][j];
//                     else mat[i][j] =mat[i][j-1] + 1;
//                 }
//             }
//             return mat;
//         }
//         private int[][] getDownMatrix(){
//             int[][] mat = new int[m][n];
//             for(int j = 0; j < n; j++){
//                 for(int i = 0; i < m; i++){
//                     if(matrix[i][j] == 0) continue;
//                     if(i-1<0)mat[i][j] =matrix[i][j];
//                     else mat[i][j] =mat[i-1][j] + 1;
//                 }
//             }
//             return mat;
//         }
}