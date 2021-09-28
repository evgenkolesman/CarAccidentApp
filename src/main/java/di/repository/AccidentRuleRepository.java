package di.repository;

import di.model.Accident;
import di.model.Rule;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentRuleRepository extends CrudRepository<Rule, Integer> {
}
