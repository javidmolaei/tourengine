package ir.company.tourengine.service.user;

import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;
import ir.company.tourengine.dao.repository.activation.VerifyDAO;
import ir.company.tourengine.dao.repository.user.UserDAO;
import ir.company.tourengine.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;


    @Override
    public User fetchUser(long mobileNo) throws Exception {
        if (mobileNo != 0) {
            return userDAO.getUser(String.valueOf(mobileNo));
        } else {
            throw new Exception("شماره همراه نادرست می باشد");
        }
    }

    @Override
    public User fetchUser(long mobileNo, String password) throws Exception {
        if (mobileNo != 0) {
            return userDAO.getUserByPass(String.valueOf(mobileNo), password);
        } else {
            throw new Exception("شماره همراه نادرست می باشد");
        }
    }

    @Override
    public void submitUser(User user) {
        userDAO.saveOrUpdateUser(user);
    }
}
