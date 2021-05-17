class countDigitOne {
    public int countDigitOne(int n) {
     /*
     long base
     int sum
     int left, cur, right
     in while loop
     if cur ==1: sum+=left*base  + right + 1;
    else if cur>1: sum+=(left + 1) * base;
    else sum+=left * base;
     */
        long base = 1;
        int sum = 0;
        int left, cur, right;
        while(base <=n){
            left = (int)(n/base/10);
            cur = (int)(n/base%10);
            right = (int)(n%base);
            if(cur==1) sum+=left *base + right +1;
            else if(cur>1) sum+=(left+1)*base;
            else sum+=left*base;
            base*=10;
        }
        return sum;
    }
}