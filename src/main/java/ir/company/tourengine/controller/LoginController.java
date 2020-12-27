package ir.company.tourengine.controller;

import ir.company.tourengine.exceptions.ServerException;
import ir.company.tourengine.facade.login.LoginFacade;
import ir.company.tourengine.model.request.AuthenticationRequest;
import ir.company.tourengine.model.response.StandardResponse;
import ir.company.tourengine.model.response.AuthenticationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/authentication")
public class LoginController {
    @Autowired
    LoginFacade loginFacade;

    @PostMapping("/verify")
    public StandardResponse verify(HttpServletRequest httpServletRequest) {
        try {
            /*
             *
             * encryption or decryption just here developed
             *
             * */
            int mobileNo = (int) Long.parseLong(httpServletRequest.getHeader("mobileNo"));
            AuthenticationRequest message = (AuthenticationRequest) httpServletRequest.getSession().getAttribute("message");
            AuthenticationResponse authenticationResponse = loginFacade.verify(message, mobileNo);
            StandardResponse standardResponse = new StandardResponse();
            standardResponse.setResultCode(1);
            standardResponse.setResponse(authenticationResponse);
            standardResponse.setResultMessage("OK");
            return standardResponse;
        } catch (Exception e) {
            return ServerException.create("خطای ناشناخته", e);

        }
    }

    @PostMapping("/verified")
    public StandardResponse verified(HttpServletRequest httpServletRequest) {
        try {

            int mobileNo = (int) Long.parseLong(httpServletRequest.getHeader("mobileNo"));
            AuthenticationRequest message = (AuthenticationRequest) httpServletRequest.getSession().getAttribute("message");
            AuthenticationResponse authenticationResponse = loginFacade.verified(message, mobileNo);
            StandardResponse standardResponse = new StandardResponse();
            standardResponse.setResponse(authenticationResponse);
            standardResponse.setResultCode(1);
            standardResponse.setResultMessage("OK");
            return standardResponse;
        } catch (Exception e) {
            return ServerException.create("خطای ناشناخته", e);

        }
    }

    @PostMapping("/login")
    public StandardResponse login(HttpServletRequest httpServletRequest) {
        try {

            int mobileNo = (int) Long.parseLong(httpServletRequest.getHeader("mobileNo"));
            AuthenticationRequest message = (AuthenticationRequest) httpServletRequest.getSession().getAttribute("message");
            AuthenticationResponse authenticationResponse = loginFacade.login(message, mobileNo);
            StandardResponse standardResponse = new StandardResponse();
            standardResponse.setResponse(authenticationResponse);
            standardResponse.setResultCode(1);
            standardResponse.setResultMessage("OK");
            return standardResponse;
        } catch (Exception e) {
            return ServerException.create("خطای ناشناخته", e);

        }
    }

    @PostMapping("/register")
    public StandardResponse register(HttpServletRequest httpServletRequest) {
        try {

            int mobileNo = (int) Long.parseLong(httpServletRequest.getHeader("mobileNo"));
            AuthenticationRequest message = (AuthenticationRequest) httpServletRequest.getSession().getAttribute("message");
            AuthenticationResponse authenticationResponse = loginFacade.login(message, mobileNo);
            StandardResponse standardResponse = new StandardResponse();
            standardResponse.setResponse(authenticationResponse);
            standardResponse.setResultCode(1);
            standardResponse.setResultMessage("OK");
            return standardResponse;
        } catch (Exception e) {
            return ServerException.create("خطای ناشناخته", e);

        }
    }
    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("sign-up-page-1");
    }
}
