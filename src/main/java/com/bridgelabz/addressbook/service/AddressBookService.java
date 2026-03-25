package com.bridgelabz.addressbook.service;

/**
 * AddressBookService
 *
 * Updated in Section 2 UC3 to store, update and delete contacts
 * in an in-memory List<AddressBook>. This simulates a database
 * until the actual JPA/MySQL persistence layer is connected.
 *
 * An AtomicLong counter is used to auto-generate unique IDs,
 * mirroring what a database sequence would provide.
 *
 * Supports all CRUD operations:
 *   - getAllContacts  - returns full in-memory list
 *   - getContactById - finds by ID or throws RuntimeException
 *   - addContact     - creates model from DTO, assigns ID, stores in list
 *   - updateContact  - finds by ID, replaces fields, returns updated model
 *   - deleteContact  - removes entry by ID from list
 *
 * @author Manas
 * @version 1.0
 */

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class AddressBookService implements IAddressBookService {

    // In-memory list acting as a temporary data store
    private final List<AddressBook> contactList = new ArrayList<>();

    // Auto-incrementing ID generator starting at 1
    private final AtomicLong idCounter = new AtomicLong(1);

    // Returns a copy of all contacts currently in memory
    @Override
    public List<AddressBook> getAllContacts() {
        return new ArrayList<>(contactList);
    }

    // Finds and returns a contact by ID; throws exception if not found
    @Override
    public AddressBook getContactById(Long id) {
        return contactList.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Contact not found with id: " + id));
    }

    // Creates a new AddressBook entry from the DTO and stores it in-memory
    @Override
    public AddressBook addContact(AddressBookDTO dto) {
        AddressBook contact = new AddressBook(
                idCounter.getAndIncrement(),
                dto.getName(),
                dto.getPhone(),
                dto.getEmail(),
                dto.getCity()
        );
        contactList.add(contact);
        return contact;
    }

    // Finds the contact by ID, updates its fields, and returns the updated object
    @Override
    public AddressBook updateContact(Long id, AddressBookDTO dto) {
        AddressBook contact = getContactById(id);
        contact.setName(dto.getName());
        contact.setPhone(dto.getPhone());
        contact.setEmail(dto.getEmail());
        contact.setCity(dto.getCity());
        return contact;
    }

    // Removes the contact with the given ID from the in-memory list
    @Override
    public void deleteContact(Long id) {
        AddressBook contact = getContactById(id);
        contactList.remove(contact);
    }
}
