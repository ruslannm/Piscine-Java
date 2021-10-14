import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Node head;
    private Node tail;
    private int size;

    public TransactionsLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void addTransaction(Transaction transaction) {
        if (size == 0) {
            head = new Node(null, transaction, null);
            tail = head;
        } else {
            tail.setNext(new Node(tail, transaction, null));
            tail = tail.getNext();
        }
        size++;
    }

    @Override
    public void removeTransaction(UUID id) throws TransactionNotFoundException {
        Node cur = head;

        while (cur != null) {
            if (cur.getTransaction().getIdentificator().equals(id)) {
                if (cur == head) {
                    head = cur.getNext();
                }
                if (cur.getNext() != null) {
                    cur.getNext().setPrev(cur.getPrev());
                }
                if (cur.getPrev() != null) {
                    cur.getPrev().setNext(cur.getNext());
                }
                size--;
                return;
            }
            cur = cur.getNext();
        }
        throw new TransactionNotFoundException();
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactionArr = new Transaction[size];
        Node cur = head;
        for (int i = 0; i < size; i++) {
            transactionArr[i] = cur.getTransaction();
            cur = cur.getNext();
        }
        return transactionArr;
    }

    public void printTransactionsLinkedList(){
        Node cur = head;

        while (cur != null) {
            System.out.println(cur.getTransaction());
            cur = cur.getNext();
        }
    }
}
