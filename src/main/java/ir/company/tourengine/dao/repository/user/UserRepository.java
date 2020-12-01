package ir.company.tourengine.dao.repository.user;

import ir.company.tourengine.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByMobile(String mobile);
    User findUserByMobileAndPassword(String mobile,String password);
}