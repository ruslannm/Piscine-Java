public class Program {

    public static void main(String[] args) throws UserNotFoundException {
	    final int USERS_AMOUNT = 16;
        UsersArrayList users = new UsersArrayList();
        for (int i = 0; i< USERS_AMOUNT; i++){
            users.addUser(new User("User "+String.valueOf(i), i));
        }
        User user5 = users.getUserById(5);
        System.out.println("User: " + user5.getName() + ", id: "+user5.getId()
                +", balance: " + user5.getBalance());
        User user7 = users.getUserByIndex(7);
        System.out.println("User: " + user7.getName() + ", id: "+user7.getId()
                +", balance: " + user7.getBalance());
        System.out.println("Amount of users: "+users.getAmountOfUsers());
        User user100 = users.getUserById(100);
        System.out.println("User: " + user100.getName() + ", id: "+user100.getId()
                +", balance: " + user100.getBalance());

    }
}
