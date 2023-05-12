package base.usermanage.com.repository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import base.usermanage.com.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
interface UserRepository extends CrudRepository<UserModel , Long> {
	Optional<UserModel> findByEmail(String email);
	Optional<UserModel> findByName(String name);
}
