package projeto01;

import java.util.ArrayList;
import projeto01.Transaction;

public class Account {
    public String type;
    private double balance = 0;
    public ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Account (String type) {
        this.type = type;
    }

    public double getBalance() {
        double balance = 0;
        for (int i = 0; i < transactions.size(); i++) {
            balance += transactions.get(i).value;
        }
        return balance;
    }
}
