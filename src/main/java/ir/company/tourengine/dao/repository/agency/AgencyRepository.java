package ir.company.tourengine.dao.repository.agency;

import ir.company.tourengine.dao.model.Agency;
import ir.company.tourengine.dao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgencyRepository extends JpaRepository<Agency, Long> {
    List<Agency> findAllByPhoneNumber(String mobile);
}