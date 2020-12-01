package ir.company.tourengine.dao.repository.activation;

import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerifyRepository extends JpaRepository<Verify, Long> {
    Verify findUserByPhoneNumber(String mobile);
}