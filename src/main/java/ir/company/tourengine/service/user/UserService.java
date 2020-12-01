package ir.company.tourengine.service.user;

import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;

public interface UserService {
    User fetchUser(long mobile) throws Exception;

    User fetchUser(long mobile, String password) throws Exception;
    void submitUser(User user) throws Exception;

}
