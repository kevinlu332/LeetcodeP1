import java.util.HashMap;
import java.util.Map;

class Solution {

    public static int solution(String S) {
        int ans = 0;
        int split = 1;
        Map<Character, Integer> map1 = new HashMap<>();
        map1.put(S.charAt(0), 1);
        Map<Character, Integer> map2 = new HashMap<>();
        for(int i = 1; i <S.length(); i++){
            map2.put(S.charAt(i), map2.getOrDefault(S.charAt(i), 0) +1);
        }
        int count1 = 1;
        int count2 = map2.size();
        if(count1==count2) ans++;
        for(split = 1; split < S.length()-1; split++){

            char c = S.charAt(split);
            Integer count11 = map1.get(c);
            if(count11==null) {
                map1.put(c, 1);
                count1++;
            }else map1.put(c, count11+1);

            Integer count22= map2.get(c);
            if(count22==1) {
                map2.put(c, 0);
                count2--;
            }
            if(count1==count2) ans++;
        }
        return ans;
    }
//    public static void main(String[] args){
//        String s = "abaca";
//        System.out.println(solution(s));
//        String s2 = "aaaa";
//        System.out.println(solution(s2));
//    }
}
