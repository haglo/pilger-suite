package org.pilger.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.pilger.model.entity.*;


public interface CurrentUserRepository extends JpaRepository<CurrentUser, Long> {

	public List<CurrentUser> findAllByOrderByIdDesc();
	public List<CurrentUser> findByElytronRole(Role role);
	public CurrentUser findByUsername(String username);
	public CurrentUser findById(Integer id);
 
}
