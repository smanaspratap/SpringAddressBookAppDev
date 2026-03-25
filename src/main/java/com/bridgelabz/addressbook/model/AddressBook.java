package com.bridgelabz.addressbook.model;

/**
 * AddressBook (Domain Model)
 *
 * Represents an address book contact entity that will eventually
 * be persisted in the MySQL database via JPA/Hibernate.
 * At this stage it is used in-memory; @Entity/@Table annotations
 * will be activated once the repository layer is introduced.
 *
 * @author Manas
 * @version 1.0
 */

public class AddressBook {

    private long   id;
    private String name;
    private String phone;
    private String email;
    private String city;

    // Default constructor
    public AddressBook() {}

    // Full constructor for building a model from a DTO
    public AddressBook(long id, String name, String phone, String email, String city) {
        this.id    = id;
        this.name  = name;
        this.phone = phone;
        this.email = email;
        this.city  = city;
    }

    // Getter for id
    public long getId()   { return id; }
    // Setter for id
    public void setId(long id) { this.id = id; }

    // Getter for name
    public String getName()  { return name; }
    // Setter for name
    public void setName(String name) { this.name = name; }

    // Getter for phone
    public String getPhone() { return phone; }
    // Setter for phone
    public void setPhone(String phone) { this.phone = phone; }

    // Getter for email
    public String getEmail() { return email; }
    // Setter for email
    public void setEmail(String email) { this.email = email; }

    // Getter for city
    public String getCity()  { return city; }
    // Setter for city
    public void setCity(String city) { this.city = city; }
}
