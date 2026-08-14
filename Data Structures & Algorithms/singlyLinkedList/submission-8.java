class LinkedList {

    public class ListNode {
        private int val;
        private ListNode next;

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public int getVal() { return val; }
        public ListNode getNext() { return next; }
        public void setVal(int val) { this.val = val; }
        public void setNext(ListNode next) { this.next = next; }
    }

    private ListNode head;

    public LinkedList() {
        head = null;
    }

    public int get(int index) {
        ListNode curr = head;
        for(int i = 0; i < index; i++) {
            if(curr == null) return -1;
            curr = curr.getNext();
        }

        return curr != null ? curr.getVal() : -1;
    }

    public void insertHead(int val) {
        head = new ListNode(val, head);
    }

    public void insertTail(int val) {
        if(head == null) {
            insertHead(val);
            return;
        }

        ListNode curr = head;
        while(curr.getNext() != null) {
            curr = curr.getNext();
        }

        curr.setNext(new ListNode(val, null));

    }

    public boolean remove(int index) {
        if (index == 0) {
            if (head == null) return false;
            head = head.getNext();  
            return true;           
        }

        ListNode curr = head;
        for(int i = 0; i < index - 1; i++) {
            if(curr == null) return false;
            curr = curr.getNext();
        }
        
        if(curr == null) return false;
        if(curr.getNext() == null) return false; // <-- Add this line
        curr.setNext(curr.getNext().getNext());  // <-- (Can also simplify this line)
        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> output = new ArrayList<>();
        ListNode curr = head;
        while(curr != null) {
            output.add(curr.getVal());
            curr = curr.getNext();
        }

        return output;
    }
}
