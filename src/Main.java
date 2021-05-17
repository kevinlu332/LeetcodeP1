import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
// Uncomment below classes to send network request if needed.
// import java.net.HttpURLConnection;
// import java.net.URL;

class Main {
//    public static void main(String args[] ) throws Exception {
//        String inputData = "";
//        String thisLine = null;
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
////        while ((thisLine = br.readLine()) != null) {
////            inputData += thisLine + "\n";
////        }
//        inputData = "7\n" +
//                "test\n" +
//                "tester\n" +
//                "Phenomenologically\n" +
//                "testertest\n" +
//                "testing\n" +
//                "TestingTester\n" +
//                "testingtester";
//        // Output the solution to the console
//        System.out.println(codeHere(inputData));
//    }
    static List<String> ansList = new ArrayList<>();
    public static String codeHere(String inputData) {
        // Use this function to write your solution;
        //when comparing: ignore letter cases; but output is with letter cases.
        //if output has many string answers, print the smallest one
        //if no words fit: print: None

        String[] arr = inputData.split("\n");
        int N = Integer.parseInt(arr[0]);
        Trie trie = new Trie();
        for(int i = 1; i < arr.length; i++){
            trie.insert(arr[i]);
        }
        Node cur = trie.node;

        boolean containsOtherWord = false;
        dfs(cur, containsOtherWord, new int[]{0});
        if(ansList.size()==0) return "None";
        Collections.sort(ansList);
        return ansList.get(0);
    }
    private static void dfs(Node cur, boolean containsOtherWord, int[] longestLength){
        //base case: 
        List<String> wordList = cur.getWordList();
        if(containsOtherWord){
            if(!cur.wordListIsEmpty()){
                int wordLength = wordList.get(0).length();
                if(wordLength==longestLength[0]) ansList.addAll(wordList);
                else if(wordLength > longestLength[0]){
                    longestLength[0] = wordLength;
                    ansList = new ArrayList<>();
                    ansList.addAll(wordList);
                }
            }
        }
        if(!cur.wordListIsEmpty()) containsOtherWord = true;
        List<Node> list = cur.getListOfExistingNode();
        if(list.size()==0) return;

        //recursive rule:
        for(Node n: list){
            dfs(n, containsOtherWord, longestLength);
        }
    }
    static class Node{
        private Node[] links;
        private int R = 26;
        List<String> wordList = new ArrayList<>(); // list of words with case sensitive at this node

        public Node(){
            links = new Node[R];
        }
        public boolean containsChar(char ch){
            char temp = ch;
            if(Character.isUpperCase(ch)) temp = Character.toLowerCase(ch);
            return links[temp - 'a']!=null;
        }
        public Node get(char ch){
            char temp = ch;
            if (Character.isUpperCase(ch))
                temp = Character.toLowerCase(ch);
            return links[temp - 'a'];
        }
        public List<Node> getListOfExistingNode(){
            List<Node> nodeList = new ArrayList<>();
            for(int i = 0; i < R; i++){
                if(links[i]!=null) nodeList.add(links[i]);
            }
            return nodeList;
        }
        public void put(char ch, Node node){
            char temp = ch;
            if (Character.isUpperCase(ch))
                temp = Character.toLowerCase(ch);
            links[temp - 'a'] = node;
        }
        public void putToList(String str){
            wordList.add(str);
        }
        public boolean wordListIsEmpty() {
            return wordList.size()==0;
        }
        public List<String> getWordList(){
            return wordList;
        }
    }
    static class Trie{
        Node node;
        public Trie(){
            node = new Node();
        }
        public void insert(String word){
            Node cur  = node;
            for(char c: word.toCharArray()){
                if(cur.containsChar(c)) cur = cur.get(c);
                else{
                    Node node = new Node();
                    cur.put(c, node);
                    cur = cur.get(c);
                }
            }
            cur.putToList(word);
        }
    }
}