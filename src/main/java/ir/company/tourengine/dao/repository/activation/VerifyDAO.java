package ir.company.tourengine.dao.repository.activation;

import ir.company.tourengine.dao.model.User;
import ir.company.tourengine.dao.model.Verify;
import ir.company.tourengine.dao.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class VerifyDAO {

	@Autowired
	VerifyRepository verifyRepository;

	public Verify getVerifyObject(String mobile) {
		return verifyRepository.findUserByPhoneNumber(mobile);
	}
	public void saveOrUpdate(Verify verify) {
		 verifyRepository.save(verify);
	}


}