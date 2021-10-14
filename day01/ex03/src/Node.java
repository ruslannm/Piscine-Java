public class Node {
    private Transaction transaction;
    private Node prev;
    private Node next;

    public Node(Node prev, Transaction transaction, Node next){
        this.transaction = transaction;
        this.prev = prev;
        this.next = next;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
