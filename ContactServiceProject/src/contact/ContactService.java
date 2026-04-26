package contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {

    private Map<String, Contact> contacts = new HashMap<>();

    // Add a new contact
    public void addContact(Contact contact) {
        if (contacts.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("Contact ID already exists");
        }
        contacts.put(contact.getContactId(), contact);
    }

    // Delete a contact by ID
    public void deleteContact(String contactId) {
        if (!contacts.containsKey(contactId)) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contacts.remove(contactId);
    }

    // Update first name
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setFirstName(firstName);
    }

    // Update last name
    public void updateLastName(String contactId, String lastName) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setLastName(lastName);
    }

    // Update phone
    public void updatePhone(String contactId, String phone) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setPhone(phone);
    }

    // Update address
    public void updateAddress(String contactId, String address) {
        Contact contact = contacts.get(contactId);
        if (contact == null) {
            throw new IllegalArgumentException("Contact ID not found");
        }
        contact.setAddress(address);
    }

    // Optional helper for testing
    public Contact getContact(String contactId) {
        return contacts.get(contactId);
    }
}