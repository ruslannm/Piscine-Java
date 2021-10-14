import java.util.UUID;

public class Program {

    public static void main(String[] args) throws TransactionNotFoundException {
        final int USERS_AMOUNT = 2;

        UsersArrayList users = new UsersArrayList();
        for (int i = 0; i < USERS_AMOUNT; i++) {
            users.addUser(new User("User " + String.valueOf(i), i));
        }
        User user1 = new User("User1", 100);
        User user2 = new User("User2", 100);
        Transaction transaction1 = new Transaction(user1, user2, Category.debit, 10);
        user1.getTransactionsLinkedList().addTransaction(transaction1);
        Transaction transaction2 = new Transaction(user1, user2, Category.debit, 20);
        user1.getTransactionsLinkedList().addTransaction(transaction2);
        UUID transactionId = transaction2.getIdentificator();
        Transaction transaction3 = new Transaction(user1, user2, Category.debit, 30);
        user1.getTransactionsLinkedList().addTransaction(transaction3);
        System.out.println("TransactionsLinkedList before delete:");
        user1.getTransactionsLinkedList().printTransactionsLinkedList();
        user1.getTransactionsLinkedList().removeTransaction(transactionId);
        System.out.println("TransactionsLinkedList after delete:");
        user1.getTransactionsLinkedList().printTransactionsLinkedList();
        System.out.println("Get transaction with invalid UUID:");
        user1.getTransactionsLinkedList().removeTransaction(transactionId);

    }
}
