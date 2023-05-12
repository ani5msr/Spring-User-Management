package base.usermanage.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import base.usermanage.com.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

}
