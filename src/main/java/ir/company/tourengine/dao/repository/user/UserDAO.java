package ir.company.tourengine.dao.repository.user;

import ir.company.tourengine.dao.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserDAO {

	@Autowired
	UserRepository userRepository;

	public User getUser(String mobile) {
		return userRepository.findUserByMobile(mobile);
	}
	public User getUserByPass(String mobile,String password) {
		return userRepository.findUserByMobileAndPassword(mobile,password);
	}
	public void saveOrUpdateUser(User user){
		userRepository.save(user);
	}
}