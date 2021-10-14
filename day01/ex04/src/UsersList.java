public interface UsersList {
    void addUser(User user);
    User getUserById(int id) throws UserNotFoundException;
    User getUserByIndex(int index);
    int getAmountOfUsers();
}