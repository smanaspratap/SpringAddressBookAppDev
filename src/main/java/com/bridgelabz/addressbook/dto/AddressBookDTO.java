package com.bridgelabz.addressbook.dto;

/**
 * AddressBookDTO (Data Transfer Object)
 *
 * Carries data between the client (Frontend UI / CURL) and the
 * Controller layer. Intentionally kept simple at this stage;
 * additional fields will be added once all layers are wired up.
 *
 * @author Manas
 * @version 1.0
 */

public class AddressBookDTO {

    private String name;
    private String phone;
    private String email;
    private String city;

    // Default constructor required for JSON deserialization
    public AddressBookDTO() {}

    // Parameterised constructor for quick object creation
    public AddressBookDTO(String name, String phone, String email, String city) {
        this.name  = name;
        this.phone = phone;
        this.email = email;
        this.city  = city;
    }

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
