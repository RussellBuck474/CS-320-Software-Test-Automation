package contact;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");
        Contact contact2 = new Contact("12345", "Jane", "Smith", "0987654321", "456 Elm St");

        service.addContact(contact1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addContact(contact2);
        });
    }

    @Test
    void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.deleteContact("12345");

        assertNull(service.getContact("12345"));
    }

    @Test
    void testDeleteNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteContact("99999");
        });
    }

    @Test
    void testUpdateFirstName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateFirstName("12345", "Mike");

        assertEquals("Mike", service.getContact("12345").getFirstName());
    }

    @Test
    void testUpdateLastName() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateLastName("12345", "Smith");

        assertEquals("Smith", service.getContact("12345").getLastName());
    }

    @Test
    void testUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updatePhone("12345", "0987654321");

        assertEquals("0987654321", service.getContact("12345").getPhone());
    }

    @Test
    void testUpdateAddress() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);
        service.updateAddress("12345", "456 Elm St");

        assertEquals("456 Elm St", service.getContact("12345").getAddress());
    }

    @Test
    void testUpdateNonexistentContact() {
        ContactService service = new ContactService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.updateFirstName("99999", "NewName");
        });
    }

    @Test
    void testInvalidUpdatePhone() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "John", "Doe", "1234567890", "123 Main St");

        service.addContact(contact);

        assertThrows(IllegalArgumentException.class, () -> {
            service.updatePhone("12345", "123"); // invalid phone
        });
    }
}