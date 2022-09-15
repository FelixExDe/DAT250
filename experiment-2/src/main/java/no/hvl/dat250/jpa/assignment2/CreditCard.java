package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;

@Entity
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer number;
    private Integer limit;
    private Integer balance;
    private Pincode pincode;

    @ManyToOne(targetEntity = Bank.class)
    private Bank myBank;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public void setPincode(Pincode pincode) {
        this.pincode = pincode;
    }

    public Integer getNumber() {
        return this.number;
    }

    public Integer getLimit() {
        return this.limit;
    }

    public Integer getBalance() {
        return this.balance;
    }

    public Pincode getPincode() {
        return this.pincode;
    }

    public Bank getBank() {
        return this.myBank;
    }

    public void setBank(Bank myBank) {
        this.myBank = myBank;
    }

    public Bank getOwningBank() {
        return this.myBank;
    }
}