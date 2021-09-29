package di.repository;

import di.model.Authority;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository with Spring Data for Authority
 */

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

    Authority findByAuthority(String authority);
}
