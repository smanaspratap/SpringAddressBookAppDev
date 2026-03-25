package com.bridgelabz.addressbook.controller;

/**
 * AddressBookController
 *
 * REST Controller updated in Section 2 UC1 to accept AddressBookDTO
 * as the request body instead of a raw Map, and returns AddressBook
 * model objects wrapped in ResponseEntity.
 *
 * The Controller builds the Model directly here (no Service layer yet).
 * Service layer will be introduced in UC2 of Section 2.
 *
 * CURL Test Commands:
 *   GET all    : curl -X GET  http://localhost:8080/addressbook/contacts
 *   GET by id  : curl -X GET  http://localhost:8080/addressbook/contacts/1
 *   POST       : curl -X POST http://localhost:8080/addressbook/contacts -H "Content-Type: application/json" -d "{\"name\":\"Alice\",\"phone\":\"9999999999\",\"email\":\"alice@example.com\",\"city\":\"Mumbai\"}"
 *   PUT by id  : curl -X PUT  http://localhost:8080/addressbook/contacts/1 -H "Content-Type: application/json" -d "{\"name\":\"Alice Updated\",\"phone\":\"8888888888\",\"email\":\"alice@example.com\",\"city\":\"Pune\"}"
 *   DELETE     : curl -X DELETE http://localhost:8080/addressbook/contacts/1
 *
 * @author Manas
 * @version 1.0
 */

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/addressbook/contacts")
@CrossOrigin(origins = "*")
public class AddressBookController {

    // Returns a static list of contacts (Model created in Controller - temporary)
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        List<AddressBook> contacts = new ArrayList<>();
        contacts.add(new AddressBook(1L, "Demo User", "9000000000", "demo@example.com", "Delhi"));
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    // Returns a contact by ID - model created inline for demonstration
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable Long id) {
        AddressBook contact = new AddressBook(id, "Demo User", "9000000000", "demo@example.com", "Delhi");
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    // Accepts DTO, builds Model, returns the created Model
    @PostMapping
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO dto) {
        AddressBook contact = new AddressBook(1L, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCity());
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    // Accepts DTO with updated fields, returns updated Model
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable Long id,
                                                      @RequestBody AddressBookDTO dto) {
        AddressBook contact = new AddressBook(id, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCity());
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    // Returns confirmation message for deletion
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        return new ResponseEntity<>("Contact with id " + id + " deleted successfully", HttpStatus.OK);
    }
}
