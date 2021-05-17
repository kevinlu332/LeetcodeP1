public class buystockwithCD {

        public static int maxProfit(int[] prices) {

            int n = prices.length;
            if(n <2) return 0;
            int[] dp = new int[n];
            dp[1] = (prices[1] - prices[0] > 0)? (prices[1]-prices[0]): 0;
            int max = dp[1];
            for(int i = 2; i < n; i++){

                for(int j = 0; j < i; j++){
                    if(prices[i] <= prices[j]) continue;
                    else{
                        int subOptimal = prices[i]-prices[j];
                        if(j-2>=0) subOptimal+=dp[j-2];
                        max = Math.max(max, subOptimal);
                    }
                }
                dp[i] = max;
            }
            return dp[n-1];
        }

//    public static void main(String[] args){
//            int[] arr = new int[]{1,4,2};
//            int ans =maxProfit(arr);
//        System.out.println(ans);
//    }
}
