public class countSquare {


        private int[][] matrix;
    private int m;
    private int n;
    private int[][] right ;
    private int[][] down;
        public int countSquares(int[][] matrix) {
            this.matrix = matrix;
            m = matrix.length;
            n = matrix[0].length;
            right = getRightMatrix();
            down = getDownMatrix();
            int count = 0;
            for(int i = 0; i < m ; i++){
                for(int j = 0; j < n; j++){
                    if(matrix[i][j]!=0) count+=getSquaresCount(i,j);
                }
            }
            return count;
        }
        private int getSquaresCount(int i, int j){
            int count = 0;
            int len = 1;
            while(i+len-1 < m && j + len-1 < n){
                boolean done_loop = false;
                for(int k = 0; k < len; k++){

                    if(right[i+k][j+len-1]==0 || down[i+len -1][j + k]==0) {
                        done_loop = true;
                        break;
                    }
                }
                if(done_loop) break;
                count++;
                len++;
            }
            return count;
        }
        private int[][] getRightMatrix(){
            int[][] mat = new int[m][n];
            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){

                    if(matrix[i][j] == 0) continue;
                    if(j-1<0)mat[i][j] =matrix[i][j];
                    else mat[i][j] =mat[i][j-1] + 1;
                }
            }
            return mat;
        }
        private int[][] getDownMatrix(){
            int[][] mat = new int[m][n];
            for(int j = 0; j < n; j++){
                for(int i = 0; i < m; i++){
                    if(matrix[i][j] == 0) continue;
                    if(i-1<0)mat[i][j] =matrix[i][j];
                    else mat[i][j] =mat[i-1][j] + 1;
                }
            }
            return mat;
        }
    public static void main(String[] args){
            int[][] m = new int[][]{{0,1,1,1},
                    {1,1,1,1},
                    {0,1,1,1}
};
        System.out.println(new countSquare().countSquares(m));
    }


}
