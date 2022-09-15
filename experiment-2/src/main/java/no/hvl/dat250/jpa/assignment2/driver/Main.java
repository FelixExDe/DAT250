package no.hvl.dat250.jpa.assignment2.driver;

import no.hvl.dat250.jpa.assignment2.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
    public static final String PERSISTENCE_UNIT_NAME = "experiment2";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        EntityManager em = factory.createEntityManager();

        Person p = new Person();
        p.setName("Max Mustermann");

        Address a = new Address();
        a.setNumber(28);
        a.setStreet("Inndalsveien");

        Set<Address> adresses = new HashSet<>();
        adresses.add(a);

        Set<Person> owners = new HashSet<>();
        owners.add(p);

        p.setAddresses(adresses);
        a.setResidents(owners);

        Pincode pin = new Pincode();
        pin.setCount(1);
        pin.setPincode("123");

        CreditCard c1 = new CreditCard();
        CreditCard c2 = new CreditCard();
        Bank b = new Bank();

        b.setName("Pengebank");

        c1.setNumber(12345);
        c1.setBalance(-5000);
        c1.setLimit(-10000);
        c1.setPincode(pin);
        c1.setBank(b);

        c2.setNumber(123);
        c2.setBalance(1);
        c2.setLimit(2000);
        c2.setPincode(pin);
        c2.setBank(b);

        Set<CreditCard> cards = new HashSet<>();
        cards.add(c1);
        cards.add(c2);

        p.setCreditCards(cards);
        b.setOwnedCards(cards);

        //Persisting entities
        em.getTransaction().begin();

        em.persist(p);
        em.persist(a);
        em.persist(pin);
        em.persist(b);
        em.persist(c1);
        em.persist(c2);

        em.getTransaction().commit();
        em.close();
    }
}
