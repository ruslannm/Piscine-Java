public class UserIdsGenerator {
    private static UserIdsGenerator instance;
    private static int id;

    public static UserIdsGenerator getInstance(){
        if (instance == null){
            instance = new UserIdsGenerator();
        }
        return instance;
    }

    private UserIdsGenerator(){
    }

    public static int generateId(){
        return id++;
    }
}
