package no.hvl.dat250.jpa.assignment2;

import java.util.List;
import java.util.Collection;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;
    private Integer number;
    @ManyToMany(mappedBy = "addresses")
    private Set<Person> residents;

    public String getStreet() {
        return street;
    }

    public Integer getNumber() {
        return number;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Set<Person> getResidents() {
        return this.residents;
    }

    public void setResidents(Set<Person> residents) {
        this.residents = residents;
    }

    public Collection<Person> getOwners() {
        return this.residents;
    }
}