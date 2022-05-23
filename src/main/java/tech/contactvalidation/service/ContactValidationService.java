package tech.contactvalidation.service;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;
import tech.contactvalidation.ContactValidationRequest;
import tech.contactvalidation.ContactValidationResponse;
import tech.contactvalidation.ContactValidationServiceGrpc;

@GrpcService
public class ContactValidationService extends ContactValidationServiceGrpc.ContactValidationServiceImplBase {

    @Autowired
    private ContactService contactService;

    @Override
    public void validateContact(ContactValidationRequest request, StreamObserver<ContactValidationResponse> responseObserver) {
        String state = contactService.validateContact(request);

        ContactValidationResponse response = ContactValidationResponse.newBuilder().setContactState(state).build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

}
