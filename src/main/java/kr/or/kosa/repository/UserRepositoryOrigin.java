package kr.or.kosa.repository;

import kr.or.kosa.model.Users;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//DB연동을 위해 사용되는 클래스를 Map으로 모델링한 것임  
@Component
public class UserRepositoryOrigin {
	private Map<String, Users> usersMap = new HashMap<>();
	
	public Users findByUsername(String username) {
		return usersMap.get(username);
	}
	
	public Users save(Users users) {
		usersMap.put(users.getUsername(), users);
		return users;
	}
	
	public List<Users> findAll() {
		return new ArrayList<>(usersMap.values());
	}
}
