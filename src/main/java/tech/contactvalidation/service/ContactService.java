package tech.contactvalidation.service;

import org.springframework.stereotype.Service;
import tech.contactvalidation.ContactValidationRequest;

@Service
public class ContactService {

    public static final String INVALID_STATE = "INVALID";
    public static final String VALID_STATE = "VALID";

    public String validateContact(ContactValidationRequest request) {
        String address = request.getAddress();
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        if (firstName.equals("") || lastName.equals("") || address.equals("")) {
            return INVALID_STATE;
        }
        return VALID_STATE;
    }
}
