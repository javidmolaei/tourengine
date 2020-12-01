package ir.company.tourengine.facade.login;

import ir.company.tourengine.dao.model.Agency;
import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;
import ir.company.tourengine.dao.repository.activation.VerifyDAO;
import ir.company.tourengine.dao.repository.user.UserDAO;
import ir.company.tourengine.model.request.AuthenticationRequest;
import ir.company.tourengine.model.response.AuthenticationResponse;
import ir.company.tourengine.service.agency.AgencyService;
import ir.company.tourengine.service.auth.AuthenticationService;
import ir.company.tourengine.service.otp.OtpService;
import ir.company.tourengine.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LoginFacadeImpl implements LoginFacade {

    @Autowired
    AuthenticationService authenticationService;

    @Autowired
    UserService userService;

    @Autowired
    AgencyService agencyService;

    @Autowired
    OtpService otpService;

    @Override
    public AuthenticationResponse login(AuthenticationRequest message, int mobileNo) throws Exception {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setRegister(false);
        User user = userService.fetchUser(mobileNo, message.getPassword());
        if (user != null) {
            authenticationResponse.setRegister(true);
            authenticationResponse.setUser(user);
            List<Agency> agencies = agencyService.fetchAgencies(mobileNo);
            authenticationResponse.setAgencies(agencies);
        }
        return authenticationResponse;
    }

    @Override
    public AuthenticationResponse register(AuthenticationRequest message, int mobileNo) throws Exception {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setRegister(false);
        User user = userService.fetchUser(mobileNo, message.getPassword());
        if (user != null) {
            throw new Exception("کاربر وجود دارد");
        } else {
            userService.submitUser(message.getUser());
            authenticationResponse.setUser(message.getUser());
        }
        return authenticationResponse;
    }

    @Override
    public AuthenticationResponse verify(AuthenticationRequest request, int mobileNo) throws Exception {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setRegister(false);
        User user = userService.fetchUser(mobileNo);
        if (user != null) {
            authenticationResponse.setRegister(true);
        } else {
            Verify verifyObject = authenticationService.fetchVerifyCode((mobileNo));
            if (verifyObject != null) {
                if (verifyObject.getTryCount() < 3 /*&& verifyObject.getTime()<*/) {
                    String vcode = otpService.sendSmsCode(mobileNo);
                    verifyObject.setVcode(vcode);
                    verifyObject.setTryCount((verifyObject.getTryCount() + 1));
//                    verifyObject.setTime("");
                    authenticationService.submitVerifyCode(verifyObject);
                } else {
                    throw new Exception("تعداد دفعات درخواست کدفعالسازی به اتمام رسیده است");
                }
            } else {
                verifyObject = new Verify();
                String vCode = otpService.sendSmsCode(mobileNo);
                verifyObject.setVcode(vCode);
                verifyObject.setTryCount(1);
                verifyObject.setTime(new Date().toString());
                verifyObject.setPhoneNumber(String.valueOf(mobileNo));
                authenticationService.submitVerifyCode(verifyObject);
            }
        }

        return authenticationResponse;
    }

    @Override
    public AuthenticationResponse verified(AuthenticationRequest message, int mobileNo) throws Exception {
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setRegister(false);
        Verify verifyObject = authenticationService.fetchVerifyCode(mobileNo);
        if (verifyObject.getVcode().equals(message.getvCode())) {
            User user = userService.fetchUser((mobileNo));
            if (user != null) {
                authenticationResponse.setRegister(true);
            }

        } else {
            throw new Exception("کد فعالسازی نادرست می باشد");
        }
        return authenticationResponse;
    }
}
