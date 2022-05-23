package tech.contactvalidation.service;

import org.junit.jupiter.api.Test;
import tech.contactvalidation.ContactValidationRequest;

import static org.junit.jupiter.api.Assertions.*;

class ContactServiceTest {

    ContactService contactService = new ContactService();

    @Test
    void shouldReturnStateValidWhenAllFieldsArePresent() {
        ContactValidationRequest request = ContactValidationRequest.newBuilder()
                .setAddress("Address")
                .setFirstName("FirstName")
                .setLastName("LastName").build();
        String state = contactService.validateContact(request);

        assertEquals("VALID", state);
    }

    @Test
    void shouldReturnStateInvalidWhenOneFieldIsEmpty() {
        String state = contactService.validateContact(ContactValidationRequest.newBuilder().build());

        assertEquals("INVALID", state);
    }
}