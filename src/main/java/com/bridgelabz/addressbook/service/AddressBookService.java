package com.bridgelabz.addressbook.service;

/**
 * AddressBookService
 *
 * Concrete implementation of IAddressBookService.
 * In UC2 of Section 2 the service layer is introduced but does NOT
 * yet maintain state - it builds and returns Model objects on the fly.
 * Persistent storage (in-memory List) will be added in UC3.
 *
 * The @Service annotation registers this class as a Spring-managed bean
 * so it can be injected into the Controller via @Autowired.
 *
 * @author Manas
 * @version 1.0
 */

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressBookService implements IAddressBookService {

    // Returns a single dummy contact - no storage yet
    @Override
    public List<AddressBook> getAllContacts() {
        List<AddressBook> contacts = new ArrayList<>();
        contacts.add(new AddressBook(1L, "Service Layer Demo", "9000000001", "svc@example.com", "Bangalore"));
        return contacts;
    }

    // Builds and returns a contact model for the requested ID
    @Override
    public AddressBook getContactById(Long id) {
        return new AddressBook(id, "Service Layer Demo", "9000000001", "svc@example.com", "Bangalore");
    }

    // Builds a model from DTO and returns it (not stored yet)
    @Override
    public AddressBook addContact(AddressBookDTO dto) {
        return new AddressBook(System.currentTimeMillis(), dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCity());
    }

    // Builds an updated model from DTO and returns it (not stored yet)
    @Override
    public AddressBook updateContact(Long id, AddressBookDTO dto) {
        return new AddressBook(id, dto.getName(), dto.getPhone(), dto.getEmail(), dto.getCity());
    }

    // No-op delete at this stage - storage arrives in UC3
    @Override
    public void deleteContact(Long id) {
        // Storage-backed deletion implemented in UC3
    }
}
