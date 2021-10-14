public class User {
    private int identificator;
    private String name;
    private int balance;

    public User(int identificator, String name, int balance){
        this.identificator = identificator;
        this.name = name;
        setBalance(balance);

    }

    public void setIdentificator(int identificator) {
        this.identificator = identificator;
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

    public int getIdentificator() {
        return identificator;
    }

    public String getName() {
        return name;
    }

    public int getBalance() {
        return balance;
    }
}
