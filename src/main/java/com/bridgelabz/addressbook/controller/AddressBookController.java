package com.bridgelabz.addressbook.controller;

/**
 * AddressBookController
 *
 * REST Controller for the Address Book application.
 * Handles all incoming HTTP requests (GET, POST, PUT, DELETE)
 * and returns appropriate JSON responses wrapped in ResponseEntity.
 *
 * UC2 - Section 1: Demonstrates HTTP method wiring before Service/DB layers
 * are introduced. Data is hard-coded/dummy at this stage.
 *
 * Base URL: /addressbook/contacts
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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/addressbook/contacts")
@CrossOrigin(origins = "*")
public class AddressBookController {

    // Returns a dummy list confirmation - connectivity check
    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllContacts() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "GET all contacts - REST layer working");
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Returns dummy data for a single contact by ID - connectivity check
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getContactById(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "GET contact by ID - REST layer working");
        response.put("id", id);
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Accepts a contact JSON body and echoes it back - connectivity check
    @PostMapping
    public ResponseEntity<Map<String, Object>> addContact(@RequestBody Map<String, Object> body) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "POST contact received - REST layer working");
        response.put("receivedData", body);
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    // Accepts updated contact data by ID and echoes it back - connectivity check
    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateContact(@PathVariable Long id,
                                                              @RequestBody Map<String, Object> body) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "PUT contact updated - REST layer working");
        response.put("id", id);
        response.put("updatedData", body);
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // Accepts an ID and confirms deletion intent - connectivity check
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteContact(@PathVariable Long id) {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "DELETE contact request received - REST layer working");
        response.put("id", id);
        response.put("status", "success");
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
