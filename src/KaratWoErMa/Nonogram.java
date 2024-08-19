package KaratWoErMa;

public class Nonogram {
/*
A nonogram is a logic puzzle, similar to a crossword, in which the player is given a blank grid and has to color it according to some instructions.
Specifically, each cell can be either black or white, which we will represent as 0 for black and 1 for white.

+------------+
| 1  1  1  1 |
| 0  1  1  1 |
| 0  1  0  0 |
| 1  1  0  1 |
| 0  0  1  1 |
+------------+

For each row and column, the instructions give the lengths of contiguous runs of black (0) cells.
For example, the instructions for one row of [ 2, 1 ] indicate that
    there must be a run of two black cells, followed later by another run of one black cell, and the rest of the row filled with white cells.

These are valid solutions: [ 1, 0, 0, 1, 0 ] and [ 0, 0, 1, 1, 0 ] and also [ 0, 0, 1, 0, 1 ]
This is not valid: [ 1, 0, 1, 0, 0 ] since the runs are not in the correct order.
This is not valid: [ 1, 0, 0, 0, 1 ] since the two runs of 0s are not separated by 1s.

Your job is to write a function to validate a possible solution against a set of instructions.
Given a 2D matrix representing a player's solution; and instructions for each row along with additional instructions for each column;
return True or False according to whether both sets of instructions match.

Example instructions #1

matrix1 = [[1,1,1,1],
           [0,1,1,1],
           [0,1,0,0],
           [1,1,0,1],
           [0,0,1,1]]
rows1_1    =  [], [1], [1,2], [1], [2]
columns1_1 =  [2,1], [1], [2], [1]
validateNonogram(matrix1, rows1_1, columns1_1) => True

Example solution matrix:
matrix1 ->
                                   row
                +------------+     instructions
                | 1  1  1  1 | <-- []
                | 0  1  1  1 | <-- [1]
                | 0  1  0  0 | <-- [1,2]
                | 1  1  0  1 | <-- [1]
                | 0  0  1  1 | <-- [2]
                +------------+
                  ^  ^  ^  ^
                  |  |  |  |
  column       [2,1] | [2] |
  instructions      [1]   [1]


Example instructions #2

(same matrix as above)
rows1_2    =  [], [], [1], [1], [1,1] (my note: the last [1,1] seems wrong.)
columns1_2 =  [2], [1], [2], [1]
validateNonogram(matrix1, rows1_2, columns1_2) => False

The second and third rows and the first column do not match their respective instructions.

Example instructions #3

matrix2 = [
[ 1, 1 ],
[ 0, 0 ],
[ 0, 0 ],
[ 1, 0 ]
]
rows2_1    = [], [2], [2], [1]
columns2_1 = [1, 1], [3]
validateNonogram(matrix2, rows2_1, columns2_1) => False

The black cells in the first column are not separated by white cells.

n: number of rows in the matrix
m: number of columns in the matrix
"""

    matrix1 = [
            [1,1,1,1], # []
            [0,1,1,1], # [1] -> a single run of _1_ zero (i.e.: "0")
            [0,1,0,0], # [1, 2] -> first a run of _1_ zero, then a run of _2_ zeroes
    [1,1,0,1], # [1]
            [0,0,1,1], # [2]
            ]

            # True
    rows1_1 = [[],[1],[1,2],[1],[2]]
    columns1_1 = [[2,1],[1],[2],[1]]
            # False
    rows1_2 = [[],[],[1],[1],[1,1]]
    columns1_2 = [[2],[1],[2],[1]]

    matrix2 = [
            [1,1],
            [0,0],
            [0,0],
            [1,0]
            ]
            # False
    rows2_1 = [[],[2],[2],[1]]
    columns2_1 = [[1,1],[3]]
    */

    public boolean isValidNonogram(int[][] matrix, int[][] rows, int[][] cols){
        if(matrix == null || rows == null || cols == null) return false;
        int n = matrix.length, m = matrix[0].length;
        if(n == 0  || n!= rows.length || m != cols.length) return false;
        return isNonogramRowsValid(matrix, rows, n, m) && isNonogramColsValid(matrix, cols, n, m);
    }
    private boolean isNonogramRowsValid(int[][] matrix, int[][] rows, int n, int m){
        for(int i = 0; i < n; i++){
            int rowIndex = 0;
            for(int j = 0; j < m; j++){
                if(matrix[i][j] == 0) { //if not 0, continue the loop.
                    if(rows[i].length == 0) return false;
                    if(rowIndex >= rows[i].length)return false;
                    for(int k = 0; k < rows[i][rowIndex]; k++){ //check the row
                        if(j + k >= m || matrix[i][j+k] != 0) return false;
                    }
                    j+=rows[i][rowIndex++]-1;  //this part is differnt from the code in JianShu.
                }
            }
            if(rowIndex != rows[i].length) return false;
        }
        return true;
    }

    private boolean isNonogramColsValid(int[][] matrix, int[][] cols, int n, int m){
        for(int i = 0; i < m; i++){ // i = which column
            int colIndex = 0;
            for(int j = 0; j < n; j++){ // j = which row
                if(matrix[j][i] == 0) {
                    if(cols[i].length == 0) return false;
                    if(colIndex >= cols[i].length)return false;
                    for(int k = 0; k < cols[i][colIndex]; k++){
                        if(j + k >= n || matrix[j+k][i] != 0) return false;
                    }
                    j+=cols[i][colIndex++]-1;
                }
            }
            if(colIndex != cols[i].length) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] matrix1  = {{1,1,1,1},
                {0,1,1,1},
                {0,1,0,0},
                {1,1,0,1},
                {0,0,1,1}};
        int[][] rows1_1    =  {{}, {1}, {1,2}, {1},{2}};
        int[][] columns1_1 =  {{2,1}, {1}, {2}, {1}};
        Nonogram nonogram = new Nonogram();
        boolean ans1 = nonogram.isValidNonogram(matrix1, rows1_1, columns1_1);
        System.out.println(ans1);

        int[][] rows1_1_2    =  {{}, {1}, {1,2}, {1},{1,1}}; // if the end one is not {2}, The answer still passes.
        int[][] columns1_1_2 =  {{2,1}, {1}, {2}, {1}};
        boolean ans1_2 = nonogram.isValidNonogram(matrix1, rows1_1_2, columns1_1_2);
        System.out.println(ans1_2);

        int[][] rows1_2    =  {{}, {}, {1}, {1}, {2}};// (my note: the last [1,1] seems wrong.)
        int[][] columns1_2 =  {{2}, {1}, {2}, {1}};
        boolean ans2 = nonogram.isValidNonogram(matrix1, rows1_2, columns1_2);
        System.out.println(ans2);
    }
}
