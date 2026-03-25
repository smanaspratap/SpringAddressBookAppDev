package com.bridgelabz.addressbook.controller;

/**
 * AddressBookController
 *
 * Updated in Section 2 UC2 to delegate all business logic
 * to the AddressBookService via the IAddressBookService interface.
 * The Service is injected using Spring''s @Autowired annotation
 * (Dependency Injection / IoC principle).
 *
 * The Controller is now thin: it only handles HTTP concerns and
 * delegates data operations to the Service layer.
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
import com.bridgelabz.addressbook.service.IAddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/addressbook/contacts")
@CrossOrigin(origins = "*")
public class AddressBookController {

    // Spring injects the AddressBookService implementation at runtime
    @Autowired
    private IAddressBookService addressBookService;

    // Delegates to service and returns all contacts as JSON
    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return new ResponseEntity<>(addressBookService.getAllContacts(), HttpStatus.OK);
    }

    // Delegates to service and returns a single contact by ID
    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable Long id) {
        return new ResponseEntity<>(addressBookService.getContactById(id), HttpStatus.OK);
    }

    // Delegates contact creation to service and returns the created contact
    @PostMapping
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO dto) {
        return new ResponseEntity<>(addressBookService.addContact(dto), HttpStatus.CREATED);
    }

    // Delegates update to service and returns the updated contact
    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable Long id,
                                                      @RequestBody AddressBookDTO dto) {
        return new ResponseEntity<>(addressBookService.updateContact(id, dto), HttpStatus.OK);
    }

    // Delegates deletion to service and returns a success message
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable Long id) {
        addressBookService.deleteContact(id);
        return new ResponseEntity<>("Contact with id " + id + " deleted successfully", HttpStatus.OK);
    }
}
