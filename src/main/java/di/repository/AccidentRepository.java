package di.repository;

import di.model.Accident;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * Repository with Spring Data for Accident
 */
@Repository
public interface AccidentRepository extends CrudRepository<Accident, Integer> {
}