package di.repository;

import di.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;

@Repository
public class AccidentMem {
    static HashMap<Integer, Accident> map = new HashMap<>();

    {
        map.put(1, new Accident(1, "NAME", "DESC", "STREET ул. им. Жукова"));
        map.put(2, new Accident(2, "NAME1", "DESC1", "STREET ул. Майская"));
        map.put(3, new Accident(3, "NAME2", "DESC2", "STREET ул. Вечерняя"));
    }

    public void add(Integer id, Accident accident) {
        map.put(id, accident);
    }

    public Accident get(Integer id) {
        return map.get(id);
    }

    public Collection<Accident> getAll() {
        return map.values();
    }

    public void delete(Integer id) {
        map.remove(id);
    }

    public void delete(Accident accident) {
        map.remove(accident);
    }

    public void edit(Accident accident) {
        map.replace(accident.getId(), accident);
    }

    public static void main(String[] args) {
        new AccidentMem().add(1, new Accident(1, "NAME", "DESC", "STREET"));
//        List<Accident> list = new AccidentMem().getAll().stream().toList();
        System.out.println(new AccidentMem().getAll().stream().toList().get(0));
        System.out.println(map.size());
    }
}
