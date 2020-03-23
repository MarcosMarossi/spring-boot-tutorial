package com.marcos.workshop.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcos.workshop.dto.UserDTO;
import com.marcos.workshop.model.User;
import com.marcos.workshop.repository.UserRespository;
import com.marcos.workshop.services.exception.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRespository repo;
	
	public List<User> findAll() {
		return repo.findAll();
	}
	
	public User findById(String id) {
		Optional<User> user = repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFoundException("Object not found. Id " + id));
	}
	
	public User insert(User user) {
		return repo.insert(user);
	}
	
	public User fromDTO (UserDTO userDto) {
		return new User(userDto.getId(), userDto.getName(), userDto.getEmail());
	}
	
	public void delete(String id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public User update(User obj) {
		User newObj = findById(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}

	private void updateData(User newObj, User user) {
		newObj.setName(user.getName());
		newObj.setEmail(user.getEmail());
	}
}
