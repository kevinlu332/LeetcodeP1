import java.util.Arrays;

class Solution1 {
///////this solution is bad. please see Solution2.java
    public static int solution(int[] A) {
        if(A.length<=4) return 0;
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int movesLeft  = 3;
        while(movesLeft >0){

            int count1 = 1;
            int secondLeft = left+1;
            while(secondLeft < A.length && A[secondLeft] == A[left]){
                count1++;
                secondLeft++;
            }
            if(count1 > movesLeft) {
                for(int i = 0; i < movesLeft; i++){
                    right--;
                }
                break;
            }

            int count2 = 1;
            int secondRight = right -1;
            while(secondRight >=0 && A[secondRight] == A[right]){
                count2++;
                secondRight--;
            }
            if(count2 > movesLeft) {
                for(int i = 0; i < movesLeft; i++){
                    left++;
                }
                break;
            }

            //if(count1 + count2 >movesLeft) break;
            int DiffLeft = A[secondLeft] - A[left];
            int DiffRight = A[right] - A[secondRight];
            if(DiffLeft > DiffRight){
                for(int i = 1; i <= count1; i++){
                    left++;
                    movesLeft--;
                }
            }else{
                for(int i = 1; i <= count2; i++){
                    right--;
                    movesLeft--;
                }
            }

        }

        return A[right] - A[left];
    }
//    public static void main(String[] args){
//        int[] a = new int[]{8, -1, 4, 3, 5, -1}; // => -1 -1 3 4 5 8
//        int ans = solution(a);
//        System.out.println(ans); // 2
//        int[] b = new int[]{-1, -1, -1, -1, -1};
//        int ans2 = solution(b);
//        System.out.println(ans2);//0
//        int[] c = new int[]{10, 10, -6, 2, -3, 10};// => -6 -3 2 10 10 10
//        int ans3 = solution(c);
//        System.out.println(ans3); //0
//
//    }
}
