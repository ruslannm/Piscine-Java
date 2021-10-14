public class UsersArrayList implements UsersList {
    private final static int DEFAULT_SIZE = 10;
    private int size = DEFAULT_SIZE;
    private int amount = 0;
    private User[] users = new User[DEFAULT_SIZE];

    @Override
    public void addUser(User user) {
        if (amount == size) {
            User[] tmpUsers = new User[size * 3 / 2];
            int i = 0;
            while (i < size) {
                tmpUsers[i] = users[i];
                i++;
            }
            tmpUsers[i] = user;
            size = size * 3 / 2;
            users = tmpUsers;
        } else {
            users[amount] = user;
        }
        amount++;
    }

    @Override
    public User getUserById(int id) throws UserNotFoundException {
        for (int i = 0; i < amount; i++) {
            if (users[i].getId() == id) {
                return users[i];
            }
        }
        throw new UserNotFoundException();
    }

    @Override
    public User getUserByIndex(int index) {
        if (index < 0 || index >= amount){
            return null;
        }else {
            return users[index];
        }
    }

    @Override
    public int getAmountOfUsers() {
        return amount;
    }
}
