package di.service;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import di.repository.AccidentJdbcTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccidentService {

    private final AccidentJdbcTemplate store;

    @Autowired
    public AccidentService(AccidentJdbcTemplate store) {
        this.store = store;
    }

    public void saveOrEdit(Accident accident) {
        if (accident.getId() == 0) {
            add(accident);
        } else {
            edit(accident);
        }
    }

    public void add(Accident accident) {
        store.save(accident);
    }

    public void edit(Accident accident) {
        store.update(accident);
    }

    public List<Accident> getAll() {
        return store.getAllAccident();
    }

    public List<Rule> getRules() {
        return store.getAllRules();
    }

    public List<AccidentType> getTypes() {
    return store.getAllTypes();
    }

    public AccidentType getType(String[] type) {
        return store.getAllTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get();
    }

    public Rule getRule(String[] rules) {
        return store.getAllRules().stream().filter(x -> x.getId() == Integer.parseInt(rules[0])).findFirst().get();
    }

    public Accident get(Integer id) {
        return store.get(id);
    }
}

/**Это сервис для применения на основе AccidentMem
 *  private final AccidentMem store;

    @Autowired
    public AccidentService(AccidentMem store) {
        this.store = store;
    }

    public void saveOrEdit(Accident accident) {
        if (accident.getId() == 0) {
            add(accident);
        } else {
            edit(accident);
        }
        //accident.getId() == 0 ? add(accident) : edit(accident); так почему то не работает
    }

    public void add(Accident accident) {
        if (accident.getId() == 0) {
            accident.setId(store.getAll().size() + 1);
        }
        store.add(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        store.edit(accident);
    }

    public List<Accident> getAll() {
        return store.getAll();
    }

    public Accident get(Integer id) {
        return store.get(id);
    }

    public void delete(Accident accident) {
        store.delete(accident);
    }

    public List<Rule> getRules() {
        return store.getRules();
    }

    public List<AccidentType> getTypes() {
        return store.getTypes();
    }

    public AccidentType getType(String[] type) {
        return store.getTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get();
    }

    public Rule getRule(String[] rules) {
        return store.getRules().stream().filter(x -> x.getId() == Integer.parseInt(rules[0])).findFirst().get();
    }
}*/
