package di.service;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import di.repository.AccidentMem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class AccidentService {

    private AccidentMem store;

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

    public Accident get (Integer id) {
        return store.get(id);
    }

    public void delete(Accident accident) {
        store.delete(accident);
    }

    public static List<Rule> getRules() {
        return AccidentMem.getRules();
    }

    public static List<AccidentType> getTypes() {
        return AccidentMem.getTypes();
    }
}
