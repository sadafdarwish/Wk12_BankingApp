
package com.va.week12;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Account {
    private String accountNumber;
    private String holderName;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, String holderName) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = 0.0;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() { return accountNumber; }
    public String getHolderName() { return holderName; }
    public double getBalance() { return balance; }
    public List<Transaction> getTransactions() { return transactions; }

    public void credit(double amount) {
        if (amount <= 0) return;
        balance += amount;
        transactions.add(new Transaction(TransactionType.CREDIT, amount));
    }

    public void debit(double amount) {
        if (amount <= 0 || amount > balance) return;
        balance -= amount;
        transactions.add(new Transaction(TransactionType.DEBIT, amount));
    }

    public int getTransactionCount() { return transactions.size(); }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber);
    }

    @Override
    public int hashCode() { return Objects.hash(accountNumber); }

    @Override
    public String toString() {
        return "Account{" + accountNumber + ", " + holderName + ", Balance=" + balance + "}";
    }
}
