public class CanIWinII {
    //pizza race
    public static  int canWin(int[] input){
        /*
            M[i][j] represents the max to gain for slice from i to j (inclusive)
            base case: M[i][i] = input[i]; M[i][i+1] = max(input[i], input[i+1];
            induction rule:
                fill the table from down to up, from left to right
                    (why? because you finally want to return M[0][n-1] )
                case 1: pick the left one
                    M[i][j] = input[i] +  (input[i+1] > input[j])? M[i+2][j] : M[i+1][j-1];

                case 2: pick the right one
                    M[i][j] = input[j] + ( input[i]> input[j-1]) M[i+1][j-1]: M[i][j-2] ;
                M[i][j] = max(case1, case2);
            I will return M[0][input.length-1];
        * */
        int n = input.length;
       int[][] M = new int[n][n];
       //base case:
        for(int i = 0; i < n; i++){
            M[i][i] = input[i];
            if(i+1 < n) M[i][i+1] = Math.max(input[i], input[i+1]);
        }
       //induction rule:
       for(int i = n-2; i >=0; i--){
           for(int j = i+2; j < n; j++){ //after the base case
               // I pick the left one first
               int sum1 = (input[i+1] > input[j])? input[i] +M[i+2][j]: input[i] +M[i+1][j-1] ;
               //remember: if size is the same, he will choose the right one
               // I pick the right one first
               int sum2 = (input[i] > input[j-1])? input[j] + M[i+1][j-1]:input[j] + M[i][j-2];
               //remember: if size is the same, he will choose the right one
               M[i][j] = Math.max(sum1, sum2);
           }
       }
       return M[0][n-1];
    }
//    public static void main(String[] args){
////        int[] input = new int[]{2,1,100,3};
////        int ans = canWin(input);
////        System.out.println(ans); // print 102;
////        int[] input2 = new int[]{18,74,89,72,90,84,63,8,2,20,99,88,5};
////        int ans2 = canWin(input2);
////        System.out.println(ans2); //366
//        int[] input3 = new int[]{77,47,84,31,67,38,34,56,33,52,31,99,32,98,82,85,60};
//        int ans3 = canWin(input3);
//        System.out.println(ans3); // 620
//    }
}
