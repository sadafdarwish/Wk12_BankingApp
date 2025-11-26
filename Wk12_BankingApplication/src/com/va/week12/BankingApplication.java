
package com.va.week12;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class BankingApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accNo = scanner.nextLine();

        System.out.print("Enter holder name: ");
        String name = scanner.nextLine();

        Account acc = new Account(accNo, name);

        Set<Account> set = new HashSet<>();
        set.add(acc);

        Account dup = new Account(accNo, name);
        boolean added = set.add(dup);
        System.out.println("Duplicate added? " + added);

        Iterator<Account> it = set.iterator();
        while (it.hasNext()) System.out.println(it.next());

        for (int i=1;i<=5;i++) {
            System.out.print("Credit " + i + ": ");
            acc.credit(Double.parseDouble(scanner.nextLine()));
        }

        for (int i=1;i<=3;i++) {
            System.out.print("Debit " + i + ": ");
            acc.debit(Double.parseDouble(scanner.nextLine()));
        }

        System.out.println("Transactions: " + acc.getTransactionCount());
        System.out.println("Final Balance: " + acc.getBalance());

        for (Transaction t : acc.getTransactions()) System.out.println(t);
    }
}
