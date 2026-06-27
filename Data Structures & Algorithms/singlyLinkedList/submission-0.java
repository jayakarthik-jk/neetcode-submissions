class LinkedList {
    class Node {
        int val;
        Node next = null;
        public Node(int val) {
            this.val = val;
        }
        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }
    private Node head = null;
    private int length = 0;
    public LinkedList() {

    }

    public int get(int index) {
        Node temp = head;
        int i = 0;
        while (temp != null) {
            if (i == index) {
                return temp.val;
            }
            i++;
            temp = temp.next;
        }
        return -1;
    }

    public void insertHead(int val) {
        head = new Node(val, head);
        length++;
    }

    public void insertTail(int val) {
        if (head == null) {
            insertHead(val);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val);
        length++;
    }

    public boolean remove(int index) {
        if (index == 0) {
            if (head == null) return false;
            head = head.next;
            length--;
            return true;
        }
        Node curr = head;
        Node prev = head;

        int i = 0;
        while (curr != null) {
            if (i == index) {
                prev.next = curr.next;
                length--;
                return true;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }
        return false;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>(length);
        Node temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        return list;
    }
}
