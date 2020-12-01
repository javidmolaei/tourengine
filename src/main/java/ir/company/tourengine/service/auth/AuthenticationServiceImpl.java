package ir.company.tourengine.service.auth;

import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;
import ir.company.tourengine.dao.repository.activation.VerifyDAO;
import ir.company.tourengine.dao.repository.user.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {


    @Autowired
    VerifyDAO verifyDAO;



    @Override
    public Verify fetchVerifyCode(long mobileNo) throws Exception {
        if (mobileNo != 0) {
            return verifyDAO.getVerifyObject(String.valueOf(mobileNo));
        } else {
            throw new Exception("شماره همراه نادرست می باشد");
        }
    }

    @Override
    public void submitVerifyCode(Verify verify) {
        verifyDAO.saveOrUpdate(verify);
    }
}
