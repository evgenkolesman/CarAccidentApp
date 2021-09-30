package di.repository;

import di.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository with Spring Data for User
 */

public interface UserRepository extends CrudRepository<User, Integer> {

    User findUserByUsername(String userName);

    User findUserById(Integer id);

}
