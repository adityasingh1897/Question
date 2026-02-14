public class LL {
    private static class ListNode {
        ListNode next;
        int value;

        ListNode(ListNode next, int value) {
            this.next = next;
            this.value = value;
        }

        ListNode(int val) {
            this.value = val;
        }

        ListNode() {

        }
    }
    private ListNode head;
    private int size;
    public LL(){
        this.size = 0;
    }

    public void insertFirst(int val){
        ListNode node = new ListNode(val);
        node.next = head;
        head = node;
    }

    public void display() {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.value + " -> ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LL ll = new LL();
    ll.insertFirst(4);
        ll.insertFirst(3);
        ll.insertFirst(2);
        ll.insertFirst(1);
        swapPairs(ll.head);
        ll.display();
        }

    public static ListNode swapPairs(ListNode head) {
        if(head == null) return new ListNode();
        ListNode first = head;
        ListNode second = head.next;
        while(first != null && second != null){
            ListNode prev = second;
            first.next = second.next;
            second.next = first;
//            first = prev.next;
//            second = first.next != null ? first.next : null;
        }
        return second;

    }

}
