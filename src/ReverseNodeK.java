

public class ReverseNodeK {
    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val = val;
        }
    }
    public static ListNode reverseNodeK(ListNode head, int K){
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode prevhead = head;
        ListNode tail = null;

        while(prevhead!=null){
            ListNode newhead = null;
            ListNode cur = prevhead;
            for(int i = 1; i < K; i++){
                if(cur==null) break;
                cur = cur.next;
            }
            newhead = cur;
            if(cur==null) break;
            cur = cur.next;
            tail = cur;
            prev.next = newhead;
            reverse(prevhead, K);
            prev = prevhead;
            prevhead = tail;
        }
        prev.next = prevhead;
        return dummy.next;

    }
    private static void reverse(ListNode head, int K){
        ListNode prev = head;
        ListNode cur = head.next;
        for(int i = 1; i < K; i++){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
    }
//    public static void main(String[] args){
//
//        ListNode node = new ListNode(1);
//        node.next = new ListNode(2);
//        node.next.next = new ListNode(3);
//        node.next.next.next = new ListNode(4);
//        node.next.next.next.next = new ListNode(5);
//        node.next.next.next.next.next = new ListNode(6);
//        ListNode ans0 = reverseNodeK(node, 4);
//        printIt(ans0);
//
//        ListNode node1 = new ListNode(1);
//        node1.next = new ListNode(2);
//        node1.next.next = new ListNode(3);
//        node1.next.next.next = new ListNode(4);
//        node1.next.next.next.next = new ListNode(5);
//        ListNode ans1 = reverseNodeK(node1, 3);
//        printIt(ans1);
//
//        ListNode node2 = new ListNode(1);
//        node2.next = new ListNode(2);
//        node2.next.next = new ListNode(3);
//         node2.next.next.next = new ListNode(4);
//        ListNode ans2 =reverseNodeK(node2, 1);
//        printIt(ans2);
//
//        ListNode node3 = new ListNode(1);
//        node3.next = new ListNode(2);
//        node3.next.next = new ListNode(3);
//        node3.next.next.next = new ListNode(4);
//        ListNode ans3 = reverseNodeK(node3, 11);
//        printIt(ans3);
//    }
    private static void printIt(ListNode node){
        ListNode cur= node;
        while(cur!=null){
            System.out.print(cur.val + " ");
            cur = cur.next;
        }
        System.out.println();
    }
}
