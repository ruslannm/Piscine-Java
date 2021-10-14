import java.util.UUID;

public class Program {

    public static void main(String[] args) throws UserNotFoundException, IllegalTransactionException, TransactionNotFoundException {
        TransactionsService transactionsService = new TransactionsService();
        User user1 = new User("User1", 100);
        User user2 = new User("User2", 100);
        transactionsService.addUser(user1);
        transactionsService.addUser(user2);
        System.out.println("valid transfers");
        transactionsService.addTransation(user1.getId(), user2.getId(), 50);
        transactionsService.addTransation(user1.getId(), user2.getId(), 20);
        transactionsService.addTransation(user1.getId(), user2.getId(), 10);
        System.out.println("user1 transactions");
        int i = 0;
        UUID transactionId = UUID.randomUUID();
        for (Transaction t : transactionsService.UserTransaction(user1.getId())) {
            System.out.println(t);
            if (i == 1){
                transactionId = t.getIdentificator();
            }
            i++;
        }
        System.out.println("user2 transactions");
        for (Transaction t : transactionsService.UserTransaction(user2.getId())) {
            System.out.println(t);
        }
        System.out.println("user1 balance: " + user1.getBalance());
        System.out.println("user2 balance: " + user2.getBalance());
        transactionsService.removeTransaction(transactionId, user1.getId());
        System.out.println("user1 transactions after delete");
        for (Transaction t : transactionsService.UserTransaction(user1.getId())) {
            System.out.println(t);
        }
        System.out.println("Unpaired transaction:");
        for (Transaction t : transactionsService.getUnpairedTransaction()) {
            System.out.println(t);
        }
    }
}
