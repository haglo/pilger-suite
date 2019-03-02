package org.pilger.service;

import java.util.List;
import org.pilger.model.entity.CurrentUser;
import org.pilger.model.entity.Role;
import org.pilger.model.repository.CurrentUserRepository;
import org.pilger.model.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PilgerService {

	@Autowired
	private CurrentUserRepository CurrentUserRepository;

	@Autowired
	private RoleRepository RoleRepository;

	public List<CurrentUser> getCurrentUsers() {
		List<CurrentUser> entries = CurrentUserRepository.findAllByOrderByIdDesc();
		return entries;
	}

	public CurrentUser setCurrentUser(CurrentUser entity) {
		CurrentUser entry = CurrentUserRepository.save(entity);
		return entry;
	}
	
	public List<Role> getRole() {
		List<Role> entries = RoleRepository.findAllByOrderByIdDesc();
		return entries;
	}
	
	
	public Role setRole(Role entity) {
		Role entry = RoleRepository.save(entity);
		return entry;
	}

	public void deleteCurrentUser(CurrentUser entity) {
		CurrentUserRepository.delete(entity);
	}

	public CurrentUser getCurrentUserByID(Integer id) {
		CurrentUser entry = CurrentUserRepository.findById(id);
		return entry;
	}

	public CurrentUser getCurrentUserByName(String name) {
		CurrentUser entry = CurrentUserRepository.findByUsername(name);
		return entry;
	}

	public List<Role> getRoles() {
		List<Role> entries = RoleRepository.findAllByOrderByIdDesc();
		return entries;
	}
	
	public Role getRoleByName(String name) {
		Role entry = RoleRepository.findByRolename(name);
		return entry;
	}

}
