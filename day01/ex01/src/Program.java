public class Program {

    public static void main(String[] args) {
        System.out.println("Create user with positive balance");
        User user1 = new User("User with positive balance", 200);
        System.out.println("User: " + user1.getName() + ", id: "+user1.getId()
                +", balance: " + user1.getBalance());
        System.out.println("Create user with negative balance");
        User user2 = new User("User with positive balance", -100);
        System.out.println("User: " + user2.getName() + ", id: "+user2.getId()
                +", balance: " + user2.getBalance());
        System.out.println("Create user with negative balance");
        User user3 = new User("User with positive balance", -100);
        System.out.println("User: " + user3.getName() + ", id: "+user3.getId()
                +", balance: " + user3.getBalance());

    }
}
