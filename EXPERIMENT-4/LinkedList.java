public class LinkedList{
    static class DLLNode {
        int data;
        DLLNode next, prev;
        DLLNode(int data) { this.data = data; next = prev = null; }
    }
    static class CLLNode {
        int data;
        CLLNode next;
        CLLNode(int data) { this.data = data; next = this; }
    }
    static class DoublyLinkedList {
        DLLNode head;
        void insertAtBeginning(int data) {
            DLLNode newNode = new DLLNode(data);
            if (head == null) { head = newNode; return; }
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        void insertAtEnd(int data) {
            DLLNode newNode = new DLLNode(data);
            if (head == null) { head = newNode; return; }
            DLLNode temp = head;
            while (temp.next != null) temp = temp.next;
            temp.next = newNode;
            newNode.prev = temp;
        }
        void deleteFromBeginning() {
            if (head == null) return;
            head = head.next;
            if (head != null) head.prev = null;
        }
        void deleteFromEnd() {
            if (head == null) return;
            DLLNode temp = head;
            while (temp.next != null) temp = temp.next;
            if (temp.prev != null) temp.prev.next = null; else head = null;
        }
        void display() {
            DLLNode temp = head;
            while (temp != null) { System.out.print(temp.data + " "); temp = temp.next; }
            System.out.println();
        }
    }

    static class CircularLinkedList {
        CLLNode tail;
        void insertAtBeginning(int data) {
            CLLNode newNode = new CLLNode(data);
            if (tail == null) { tail = newNode; return; }
            newNode.next = tail.next;
            tail.next = newNode;
        }
        void insertAtEnd(int data) {
            CLLNode newNode = new CLLNode(data);
            if (tail == null) { tail = newNode; return; }
            newNode.next = tail.next;
            tail.next = newNode;
            tail = newNode;
        }
        void deleteFromBeginning() {
            if (tail == null) return;
            if (tail.next == tail) { tail = null; } else { tail.next = tail.next.next; }
        }
        void deleteFromEnd() {
            if (tail == null) return;
            if (tail.next == tail) { tail = null; return; }
            CLLNode temp = tail.next;
            while (temp.next != tail) temp = temp.next;
            temp.next = tail.next;
            tail = temp;
        }
        void display() {
            if (tail == null) { System.out.println(); return; }
            CLLNode temp = tail.next;
            do { System.out.print(temp.data + " "); temp = temp.next; } while (temp != tail.next);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertAtBeginning(10);
        dll.insertAtEnd(20);
        dll.insertAtEnd(30);
        dll.display();
        dll.deleteFromBeginning();
        dll.display();
        dll.deleteFromEnd();
        dll.display();

        CircularLinkedList cll = new CircularLinkedList();
        cll.insertAtBeginning(5);
        cll.insertAtEnd(15);
        cll.insertAtEnd(25);
        cll.display();
        cll.deleteFromBeginning();
        cll.display();
        cll.deleteFromEnd();
        cll.display();
    }
}

