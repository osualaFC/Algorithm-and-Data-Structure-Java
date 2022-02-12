package LinkedList;

public class SinglyLinkedList {

    private ListNode head;

    public static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.head = new ListNode(10);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(8);
        ListNode fourth = new ListNode(11);
        //chaining the nodes together
        list.head.next = second;
        second.next = third;
        third.next = fourth;

        //print list
        ListNode newNode = new ListNode(15);
        list.deleteNodeAtPosition(4);
    }

    public void printList() {
        ListNode current = head;
        while(current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }

    public int getLength() {
        if (head == null) {
            return 0;
        }
        int count = 0;
        ListNode current = head;
        while(current != null) {
           count++;
            current = current.next;
        }
       // System.out.println(count);
        return count;
    }

    public void addHead(ListNode newNode) {
        if(head == null) {
            head = newNode;
        }
        newNode.next = head;
        head = newNode;
        printList();
    }

    public void addToEnd(ListNode newNode) {
        if(head == null) {
            head = newNode;
        }
        ListNode current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        printList();
    }

    public void addNodeAtPosition(ListNode newNode, int position) {
        if(position == 0) {
           newNode.next = head;
           head = newNode;
        }else {
            ListNode previous = head;
            int count = 0;
            while (count < position - 1) {
                previous = previous.next;
                count++;
            }
            newNode.next = previous.next;
            previous.next = newNode;
        }
        printList();
    }

    public ListNode deleteFirstNode() {
        if(head == null) {
            return null;
        }
        ListNode currentHead = head;
        head = head.next;
        currentHead.next = null;
         printList();
        return currentHead;
    }

    public ListNode deleteLastNode() {
        if (head == null || head.next == null) {
            return head;
        }
        int length = getLength() - 1;
        ListNode current = head;
        int count = 0;
        while(count < length - 1) {
            current = current.next;
            count++;
        }
        ListNode deletedNode = current.next;
        current.next = null;
        printList();
        return deletedNode;
    }

    public ListNode deleteNodeAtPosition(int position) {
        if(position >= getLength()) {
            return null;
        }
        ListNode deletedNode = null;
        if(position == 0) {
            deletedNode = deleteFirstNode();
        }
        else if(position == getLength() - 1) {
            deletedNode = deleteLastNode();
        } else {
            int count = 0;
            ListNode previous = head;
            while(count < position - 1) {
                previous = previous.next;
                count++;
            }
            deletedNode = previous.next;
            previous.next = deletedNode.next;
            deletedNode.next = null;
             printList();
        }
        return deletedNode;
    }

    public ListNode mergeTwoSortedList(ListNode a, ListNode b) {
        ListNode result = new ListNode(0);
        ListNode tail = result;
        while(a != null && b != null) {
            if(a.data <= b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        if(a == null) {
            tail.next = b;
        } else {
            tail.next = a;
        }
        return result.next;
    }
}
