package di.repository;


import di.model.AccidentType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccidentTypeRepository extends CrudRepository<AccidentType, Integer> {
}
