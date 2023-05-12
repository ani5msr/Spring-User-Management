package base.usermanage.com.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import base.usermanage.com.model.UserModel;

import java.util.Optional;

interface UserRepository extends CrudRepository<UserModel , Long> {
	Optional<UserModel> findByEmail(String email);
	Optional<UserModel> findByName(String name);
}
