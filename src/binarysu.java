public class binarysu {


        public static String addBinary(String a, String b) {
            //make inputs to be same length by adding 0
            //int increase = 0;
            //make new StringBuilder, then loop the 2 string:
            //int added = add 2 number and increase;
            //if >=2: append added % 2; increase = 1
            //else append added, increase = 0;
            //if increase == 1 append 1;
            //return sb reverse toString
            if(a.length() < b.length() ) a= makeSameLength(a,b);
            else b = makeSameLength(b,a);
            int increase = 0;
            StringBuilder sb=  new StringBuilder();
            for(int i = a.length()-1; i >=0; i--){
                int added = a.charAt(i) - '0' + b.charAt(i)-'0' + increase;
                if(added >=2) {
                    sb.append(String.valueOf(added % 2));
                    increase = 1;
                }else{
                    sb.append(String.valueOf(added));
                    increase = 0;
                }
            }
            if(increase==1) sb.append('1');
            return sb.reverse().toString();
        }
    private static String makeSameLength(String a, String b){

        StringBuilder sb = new StringBuilder();
        String toExtend = a;
        for(int i = toExtend.length()-1;i >=0;  i--) sb.append(toExtend.charAt(i));
        for(int i = b.length(); i > a.length(); i--) sb.append('0');
        return sb.reverse().toString();
    }
//        public static void main(String[] args){
//            String a = "100";
//            String b=  "1";
//            String ans = addBinary(a,b);
//            System.out.println( ans);
//        }
    }


