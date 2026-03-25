package com.bridgelabz.addressbook;

/**
 * AddressBookApplication
 *
 * Entry point for the Spring Boot Address Book application.
 * This application exposes REST APIs to manage address book contacts
 * and is designed to integrate with the Address Book Frontend UI.
 *
 * @author Manas
 * @version 1.0
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AddressBookApplication {

    // Bootstraps the Spring application context
    public static void main(String[] args) {
        SpringApplication.run(AddressBookApplication.class, args);
    }
}
