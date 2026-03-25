# SpringAddressBookAppDev

A Spring Boot REST application that serves as the backend for the Address Book UI.

## Project Structure
- **Section 1 - App Setup**: Project scaffolding and REST controller with CURL testing
- **Section 2 - Service Layer**: DTO/Model introduction, Service layer, in-memory data store

## Branch Strategy (Gitflow)
| Branch | Purpose |
|---|---|
| `main` | README only |
| `develop` | Integration branch - all UCs merge here |
| `UC1-project-setup` | Section 1 UC1 |
| `UC2-rest-controller` | Section 1 UC2 |
| `UC3-dto-model` | Section 2 UC1 |
| `UC4-service-layer` | Section 2 UC2 |
| `UC5-inmemory-storage` | Section 2 UC3 |

## Commit Convention
All commits follow the pattern: `[Manas]:<message>`

## How to Run
`ash
./mvnw spring-boot:run
`
Application starts on **http://localhost:8080**

## CURL Quick Reference
`ash
# Get all contacts
curl -X GET http://localhost:8080/addressbook/contacts

# Get by ID
curl -X GET http://localhost:8080/addressbook/contacts/1

# Add contact
curl -X POST http://localhost:8080/addressbook/contacts \
     -H "Content-Type: application/json" \
     -d "{\"name\":\"Alice\",\"phone\":\"9999999999\",\"email\":\"alice@example.com\",\"city\":\"Mumbai\"}"

# Update by ID
curl -X PUT http://localhost:8080/addressbook/contacts/1 \
     -H "Content-Type: application/json" \
     -d "{\"name\":\"Alice Updated\",\"phone\":\"8888888888\",\"email\":\"alice@example.com\",\"city\":\"Pune\"}"

# Delete by ID
curl -X DELETE http://localhost:8080/addressbook/contacts/1
`

## Tech Stack
- Java 17
- Spring Boot 3.x
- Maven
- MySQL (configured via application.properties)
