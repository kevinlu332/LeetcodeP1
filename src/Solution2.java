import java.util.Arrays;

class ggOAP1  {

    public static int solution(int[] A) {
        if(A.length<=4) return 0;
        Arrays.sort(A);
        int left = 0, right = A.length - 1;
        int a = helper(A, left, right - 3);
        int b = helper(A, left+1, right -2);
        int c = helper(A, left +2, right -1);
        int d = helper(A, left +3, right);

        return Math.min(Math.min(Math.min(a, b), c), d);
    }
    private static int helper(int[] A, int left, int right){
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
