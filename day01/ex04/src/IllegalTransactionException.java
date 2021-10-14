public class IllegalTransactionException extends Exception{
    public IllegalTransactionException(){
        super("The balance amount is not enough");
    }
}
