package ir.company.tourengine.dao.repository.agency;

import ir.company.tourengine.dao.model.Agency;
import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AgencyDAO {

	@Autowired
	AgencyRepository agencyRepository;

	public List<Agency> getAllAgencies(String mobile) {
		return agencyRepository.findAllByPhoneNumber(mobile);
	}
}