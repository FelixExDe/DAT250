package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable
    private Set<Address> addresses;
    private Set<CreditCard> cards;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

    public void setCreditCards(Set<CreditCard> cards) {
        this.cards = cards;
    }

    public Collection<Address> getAddresses() {
        return this.addresses;
    }

    public Collection<CreditCard> getCreditCards() {
        return this.cards;
    }
}