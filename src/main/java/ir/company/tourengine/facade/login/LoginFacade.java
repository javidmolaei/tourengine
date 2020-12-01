package ir.company.tourengine.facade.login;

import ir.company.tourengine.model.request.AuthenticationRequest;
import ir.company.tourengine.model.response.AuthenticationResponse;

public interface LoginFacade {
    AuthenticationResponse login(AuthenticationRequest message, int mobileNo) throws Exception;
    AuthenticationResponse register(AuthenticationRequest message, int mobileNo) throws Exception;
    AuthenticationResponse verify(AuthenticationRequest request, int mobileNo) throws Exception;
    AuthenticationResponse verified(AuthenticationRequest message, int mobileNo) throws Exception;
}
