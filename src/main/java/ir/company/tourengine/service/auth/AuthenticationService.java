package ir.company.tourengine.service.auth;

import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;

public interface AuthenticationService {

    Verify fetchVerifyCode(long mobile) throws Exception;

    void submitVerifyCode(Verify verify);
}
