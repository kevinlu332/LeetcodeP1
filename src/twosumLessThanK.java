public class twosumLessThanK {

    public static int twoSumLessThanK(int[] A, int K) {
        if (A== null || A.length==0) return -1;
        if (A.length==1) return -1;

        int[] B = new int[A.length];
        for (int i = 0; i<B.length; i++){
            B[i] = K- A[i];
            }
            int max = 0;
            int aa = 0;
            for (int i = 0; i<B.length-1; i++){
                int temp=0;
                for (int j = i+1; j<B.length; j++){

                    if (B[i] > A[j]){
                        if (A[j] > temp){
                            temp = A[j];
                            aa++;
                        }
                    }

                }
                if (temp != 0 && (temp + A[i] > max)) {
                    max = temp + A[i];
                }
                if (aa ==0 && i ==B.length-2 ) return -1;

            }


    return max;
    }
    /*
public static void main(String[] ar){
        int[] A = new int[]{358,898,450,732,672,672,256,542,320,573,423,543,591,280,399,923,920,254,135,952,115,536,143,896,411,722,815,635,353,486,127,146,974,495,229,21,733,918,314,670,671,537,533,716,140,599,758,777,185,549};

        int K = 1800;
    System.out.println(twoSumLessThanK(A,K));


}
*/

}
