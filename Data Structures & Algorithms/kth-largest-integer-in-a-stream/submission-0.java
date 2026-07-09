class KthLargest {

    private final LinkedList list;
    public KthLargest(int k, int[] nums) {
        list = new LinkedList(k);
        for (int num: nums) {
            list.add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
        return list.largest();
    }
}

/**
 * we can customize the implementation
 * we can only store k largest elements and drop the smaller ones
 */
class LinkedList {
    private Node head = null;
    private int limit;
    
    public LinkedList(int limit) {
        this.limit = limit;
    }

    public int largest() {
        int count = 1;
        Node curr = head;
        while (curr != null && count < limit) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            throw new AssertionError("This should not happen");
        }
        return curr.val;
    }

    public void add(int val) {
        if (head == null) {
            head = new Node(val);
            return;
        }
        Node prev = null;
        Node curr = head;
        // this loop will exit when
        // case 1: val exceeds curr.val
        // case 2: curr become null
        // for case 1: insert the element between prev and curr
        // for case 2: simply append the value

        int count = 0;
        while (curr != null && val < curr.val && count < limit) {
            prev = curr;
            curr = curr.next;
            count++;
        }
        if (count == limit) {
            // the element is smaller than current kth largest
            // value
            return;
        }

        if (curr == null) {
            if (prev == null) {
                // when the while loop starts, curr cannot be null
                // so if it is null, it means while is executed
                // in that case prev cannot be null
                throw new AssertionError("This should not happen");
            }
            prev.next = new Node(val);
        } else {
            if (prev == null) {
                // if the curr is non null but the prev is null
                // the only case is loop never ran
                // which means head is less than val
                head = new Node(val, head);
            } else {
                prev.next = new Node(val, curr);
            }
        }
    }
}

class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this(val, null);
    }
    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
