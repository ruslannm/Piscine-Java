import java.util.UUID;

enum Category {
    debit,
    credit
}

public class Transaction {

    private UUID identificator;
    private User recipient;
    private User sender;
    private Category category;
    private int amount;

    public Transaction(User recipient, User sender, Category category, int amount) {
        this.identificator = UUID.randomUUID();
        this.recipient = recipient;
        this.sender = sender;
        this.category = category;
        setAmount(amount);
    }

    public UUID getIdentificator() {
        return identificator;
    }

    public void setIdentificator(UUID identificator) {
        this.identificator = identificator;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        if (this.category == Category.debit && amount < 0) {
            System.out.println("Debit cannot be negative, set to 0 by default");
            this.amount = 0;
        } else if (this.category == Category.credit && amount > 0) {
            System.out.println("Credit cannot be positive, set to 0 by default");
            this.amount = 0;
        } else {
            this.amount = amount;
        }
    }
}
