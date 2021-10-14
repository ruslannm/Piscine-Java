public class Program {

    public static void main(String[] args) {
        System.out.println("Create user with positive balance");
        User user1 = new User(1, "User with positive balance", 200);
        System.out.println("User: " + user1.getName() + ", id: "+user1.getIdentificator()
                +", balance: " + user1.getBalance());
        System.out.println("Create user with negative balance");
        User user2 = new User(2, "User with positive balance", -100);
        System.out.println("User: " + user2.getName() + ", id: "+user2.getIdentificator()
                +", balance: " + user2.getBalance());

        System.out.println("Create transaction");
        Transaction debit = new Transaction(user2, user1, Category.debit, 50);
        Transaction credit = new Transaction(user1, user2, Category.credit,-50);
        System.out.println("debit Amount: " + debit.getAmount());
        System.out.println("credit Amount: " + credit.getAmount());
        System.out.println("Create invalid transaction");
        Transaction debitInv = new Transaction(user2, user1, Category.debit, -50);
        Transaction creditInv = new Transaction(user1, user2, Category.credit,50);
        System.out.println("debit Amount: " + debitInv.getAmount());
        System.out.println("credit Amount: " + creditInv.getAmount());
    }
}
