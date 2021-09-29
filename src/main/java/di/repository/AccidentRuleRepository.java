package di.repository;


import di.model.Rule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository with Spring Data for Rule
 */
@Repository
public interface AccidentRuleRepository extends CrudRepository<Rule, Integer> {
}
