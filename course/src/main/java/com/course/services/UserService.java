package com.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.course.model.User;
import com.course.repositories.UserRepository;
import com.course.services.exception.DatabaseException;
import com.course.services.exception.ResourceNotFountException;

@Service
public class UserService {

	@Autowired
	UserRepository userRespository;

	public List<User> findAll() {
		return userRespository.findAll();
	}

	public User findById(Integer id) {
		Optional<User> user = userRespository.findById(id);
		return user.orElseThrow(() -> new ResourceNotFountException(id));
	}

	public User insert(User user) {
		return userRespository.save(user);
	}

	public void delete(Integer id) {
		try {
			userRespository.deleteById(id);

		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFountException(id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}

	}

	public User update(Integer id, User user) {
		try {
			User entity = userRespository.getOne(id);
			updateData(entity, user);
			return userRespository.save(entity);

		} catch (EntityNotFoundException e) {
			throw new ResourceNotFountException(id);
		}
	}

	private void updateData(User entity, User user) {
		entity.setName(user.getName());
		entity.setEmail(user.getEmail());
		entity.setPhone(user.getPhone());
	}
}
