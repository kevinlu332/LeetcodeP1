//public class CopyListWithRandomPointers {
//private class RandomListNode{
//    int label;
//    int random;
//    private RandomListNode(int label){
//        this.label = label;
//       ////////unfinished
//
//    };
//}
//
//    private void copyNext(RandomListNode head) {
//        while (head != null) {
//            RandomListNode newNode = new RandomListNode(head.label);
//            newNode.random = head.random;
//            newNode.next = head.next;
//            head.next = newNode;
//            head = head.next.next;
//        }
//    }
//
//    private void copyRandom(RandomListNode head) {
//        while (head != null) {
//            if (head.next.random != null) {
//                head.next.random = head.random.next;
//            }
//            head = head.next.next;
//        }
//    }
//
//    private RandomListNode splitList(RandomListNode head) {
//        RandomListNode newHead = head.next;
//        while (head != null) {
//            RandomListNode temp = head.next;
//            head.next = temp.next;
//            head = head.next;
//            if (temp.next != null) {
//                temp.next = temp.next.next;
//            }
//        }
//        return newHead;
//    }
//
//    public RandomListNode copyRandomList(RandomListNode head) {
//        if (head == null) {
//            return null;
//        }
//        copyNext(head);
//        copyRandom(head);
//        return splitList(head);
//    }
//
//}
