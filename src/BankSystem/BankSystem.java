package BankSystem;

import java.sql.Struct;
import java.util.ArrayList;

/**
 * Created by Yiannis Kiranis <yiannis.kiranis@gmail.com>
 * https://apps4net.eu
 * Date: 15/6/22
 * Time: 7:52 μ.μ.
 *
 * Άσκηση 3, Τελικές 2017
 *
 */

class Customer {
    private String name;
    private ArrayList<Card> cards = new ArrayList<>();
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addCard(Card card) throws Exception {
        boolean customerOwnsTheAccount = false;

        for (BankAccount cardsAccount : card.getAccounts()) {
            for (BankAccount customersAccount : accounts) {
                if (cardsAccount.getNumber().equals(customersAccount.getNumber())) {
                    customerOwnsTheAccount = true;
                }
            }
        }


        if (customerOwnsTheAccount) {
            cards.add(card);
        } else {
            throw new Exception("Ο λογαριασμός δεν ανήκει στον πελάτη");
        }
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public double getTotalBalance() {
        double totalBalance = 0.0;

        for (BankAccount b : accounts) {
            totalBalance += b.getBalance();
        }

        return totalBalance;
    }

    public double calcTotalWeekWithdraw() {
        double totalWeekWithdraw = 0.0;

        for (Card card : cards) {
            if (getTotalBalance() >= 400) {
                totalWeekWithdraw += 400;
            } else {
                totalWeekWithdraw += getTotalBalance();
            }
        }

        return totalWeekWithdraw;
    }
}

class BankAccount {
    private String number;
    private double balance;
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Card> cards = new ArrayList<>();

    public BankAccount(String number, double balance) {
        this.number = number;
        this.balance = balance;
    }

    public String getNumber() {
        return number;
    }

    public double getBalance() {
        return balance;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addCustomer(Customer customer) throws Exception{
        if (customers.size() == 2) {
            throw new Exception("Δεν μπορεί να προστεθεί άλλος πελάτης για τον συγκεκριμένο λογαριασμό");
        } else {
            customers.add(customer);
        }
    }

    public void addCard(Card card) {
        cards.add(card);
    }
 }

class Card {
    private String card;
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public Card(String card) {
        this.card = card;
    }

    public String getCard() {
        return card;
    }

    public ArrayList<BankAccount> getAccounts() {
        return accounts;
    }

    public double getTotalBalance() {
        double totalBalance = 0.0;

        for (BankAccount b : accounts) {
            totalBalance += b.getBalance();
        }

        return totalBalance;
    }
}

public class BankSystem {
    public static void main(String[] args) {
        Customer georgiou = new Customer("ΓΕΩΡΓΙΟΥ");
        Customer anastasiou = new Customer("ΑΝΑΣΤΑΣΙΟΥ");

        BankAccount account1 = new BankAccount("GR123", 300);
        georgiou.addAccount(account1);

        BankAccount account2 = new BankAccount("GR456", 550);
        georgiou.addAccount(account2);
        anastasiou.addAccount(account2);

        Card card1 = new Card("12547090");
        account1.addCard(card1);
        account2.addCard(card1);

        try {
            georgiou.addCard(card1);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(georgiou.getCards());

        System.out.println("Μέγιστο εβδομαδιαίο όριο ανάληψης του πελάτη " + georgiou.getName() + ": " + georgiou.calcTotalWeekWithdraw());
    }
}
