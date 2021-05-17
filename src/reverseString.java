public class reverseString {

    private int[] idxRange = new int[]{0,0};
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        cleanSpaceAndGetRange(arr);
        reverse(arr);
        reverseEachWord(arr);
        return new String(arr, 0, idxRange[1]);
    }
    private void cleanSpaceAndGetRange(char[] arr){
        int slow = 0, fast = 0;
        while(arr[fast]==' ') fast++;
        while(fast<arr.length){
            if(arr[fast]!=' '){
                while(fast<arr.length &&arr[fast]!=' '){
                    arr[slow++] = arr[fast++];
                }
                while(fast<arr.length && arr[fast]==' ') fast++;
                if(fast<arr.length) arr[slow++] = ' ';
            }
        }
        idxRange[1] = slow;
    }
    private void reverse(char[] arr){
        int left = 0, right = idxRange[1]-1;
        while(left<right){
            swap(arr, left++, right--);
        }
    }
    private void swap(char[] arr, int l, int r){
        char temp = arr[l];
        arr[l]=arr[r];
        arr[r] = temp;
    }
    private void reverseEachWord(char[] arr){
        int left = 0, right = 0;
        while(right<idxRange[1]){
            while( right<idxRange[1] && arr[right]!=' ' ){
                right++;
            }

            swap(arr, left, right-1);
            right++;
            left = right;
        }
    }
//
//    public static void main(String[] args){
//        reverseString s = new reverseString();
//        System.out.println(s.reverseWords("EPY2giL"));
//    }

}
