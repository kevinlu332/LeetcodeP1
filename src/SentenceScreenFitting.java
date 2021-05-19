class SentenceScreenFitting {
    int n;
    public int wordsTyping(String[] sentence, int rows, int cols) {

        n = sentence.length;
        int[] words_count_arr = getWCArray(sentence, cols);
        if (words_count_arr == null) {
            return 0;
        }
        int wc = 0;
        int r = 0;
        int first_index = 0;
        while(r <rows ){
            int cur_word_count = words_count_arr[first_index];
            wc += cur_word_count;
            first_index = (first_index + cur_word_count)%n;
            r++;
        }
        return wc/n;
    }
    private int[] getWCArray(String[] sentence, int cols){
        int[] arr = new int[n];
        int wc  = 0;
        int col_index =0;
        for(int i = 0; i< n; i++){
            while(col_index + sentence[wc%n].length() <= cols){
                col_index+=1+sentence[wc%n].length();
                wc++;
            }
            if(wc - i <=0) return null; //if wc doesn't increase anymore, wc will be soon caught up by i 
            arr[i] = wc -i; ///////////////////////
            col_index -= 1+sentence[i].length(); //////////

        }
        return arr;
    }

}