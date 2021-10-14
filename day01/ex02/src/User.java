public class User {
    private int id;
    private String name;
    private int balance;

    public User(String name, int balance){
        this.id = UserIdsGenerator.getInstance().generateId();
        this.name = name;
        setBalance(balance);

    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        if (balance<0){
            System.out.println("Error: balance cannot be negative.");
            this.balance =0;
        }else{
            this.balance = balance;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
}
