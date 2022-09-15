package no.hvl.dat250.jpa.assignment2;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "myBank")
    private Set<CreditCard> ownedCards;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnedCards(Set<CreditCard> ownedCards) {
        this.ownedCards = ownedCards;
    }

    public Set<CreditCard> getOwnedCards() {
        return this.ownedCards;
    }
}