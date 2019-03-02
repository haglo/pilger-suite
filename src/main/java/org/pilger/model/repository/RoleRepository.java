package org.pilger.model.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.pilger.model.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

	public List<Role> findAllByOrderByIdDesc();
	public Role  findByRolename(String rolename);
 
}
