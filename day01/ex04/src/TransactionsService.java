import java.util.UUID;

public class TransactionsService {
    private UsersList usersList;

    public TransactionsService() {
        usersList = new UsersArrayList();
    }

    public void addUser(User user) {
        usersList.addUser(user);
    }

    public int getBalance(int userId) throws UserNotFoundException {
        User user = usersList.getUserById(userId);
        return user.getBalance();
    }

    public void addTransation(int recipientId, int senderId, int amount) throws UserNotFoundException, IllegalTransactionException {
        User recipient = usersList.getUserById(recipientId);
        User sender = usersList.getUserById(senderId);
        if (sender.getBalance() < amount) {
            throw new IllegalTransactionException();
        }
        Transaction debit = new Transaction(recipient, sender, Category.debit, amount);
        UUID transactionId = debit.getIdentificator();
        Transaction credit = new Transaction(recipient, sender, Category.credit, -amount);
        credit.setIdentificator(transactionId);

        recipient.getTransactionsLinkedList().addTransaction(debit);
        sender.getTransactionsLinkedList().addTransaction(credit);

        recipient.setBalance(recipient.getBalance() + debit.getAmount());
        sender.setBalance(sender.getBalance() + credit.getAmount());
    }

    public Transaction[] UserTransaction(int userId) throws UserNotFoundException {
        User user = usersList.getUserById(userId);
        return user.getTransactionsLinkedList().toArray();
    }

    public void removeTransaction(UUID transactionId, int userId) throws TransactionNotFoundException, UserNotFoundException {
        User user = usersList.getUserById(userId);
        user.getTransactionsLinkedList().removeTransaction(transactionId);
    }

    public Transaction[] getUnpairedTransaction() {
        User user;
        int size;
        int userAmount = usersList.getAmountOfUsers();
        int amountTransaction = 0;
        int currentIndex = 0;
        UUID transactionID;
        boolean unpaired;
        for (int i = 0; i < userAmount; i++) {
            user = usersList.getUserByIndex(i);
            amountTransaction += user.getTransactionsLinkedList().getSize();
        }

        Transaction[] transactions = new Transaction[amountTransaction];
        Transaction[] userTransactions;
        for (int i = 0; i < userAmount; i++) {
            user = usersList.getUserByIndex(i);
            size = user.getTransactionsLinkedList().getSize();
            userTransactions = user.getTransactionsLinkedList().toArray();
            for (int j = 0; j < size; j++) {
                transactions[currentIndex + j] = userTransactions[j];
            }
            currentIndex += size;
        }
        TransactionsLinkedList unpairedTransaction = new TransactionsLinkedList();
        for (int i = 0; i < amountTransaction; i++) {
            if (transactions[i] == null){
                continue;
            }
            transactionID = transactions[i].getIdentificator();
            unpaired = true;
            for (int j = i + 1; j < amountTransaction; j++) {
                if (transactions[j] != null) {
                    if (transactionID == transactions[j].getIdentificator()) {
                        transactions[i] = null;
                        transactions[j] = null;
                        unpaired = false;
                        break;
                    }
                }
            }
            if (unpaired) {
                unpairedTransaction.addTransaction(transactions[i]);
            }
        }
        return unpairedTransaction.toArray();
    }
}
