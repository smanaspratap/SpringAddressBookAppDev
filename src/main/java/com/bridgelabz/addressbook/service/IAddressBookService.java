package com.bridgelabz.addressbook.service;

/**
 * IAddressBookService
 *
 * Interface that defines the contract for all Address Book service operations.
 * Programming to an interface enables easy mocking in tests and
 * decouples the Controller from the concrete implementation.
 *
 * @author Manas
 * @version 1.0
 */

import com.bridgelabz.addressbook.dto.AddressBookDTO;
import com.bridgelabz.addressbook.model.AddressBook;

import java.util.List;

public interface IAddressBookService {

    // Retrieves all address book contacts
    List<AddressBook> getAllContacts();

    // Retrieves a single contact by its ID
    AddressBook getContactById(Long id);

    // Creates and stores a new contact from the given DTO
    AddressBook addContact(AddressBookDTO dto);

    // Updates an existing contact identified by ID using the given DTO
    AddressBook updateContact(Long id, AddressBookDTO dto);

    // Deletes the contact identified by the given ID
    void deleteContact(Long id);
}
