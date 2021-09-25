package di.repository;

import di.model.Accident;
import di.model.AccidentType;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

@Repository
public class AccidentMem {
    static HashMap<Integer, Accident> map = new HashMap<>();
    private static List<AccidentType> types = new ArrayList<>();

    {
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
        map.put(1, new Accident(1, "NAME", "DESC", "STREET ул. им. Жукова", types.get(0)));
        map.put(2, new Accident(2, "NAME1", "DESC1", "STREET ул. Майская", types.get(1)));
        map.put(3, new Accident(3, "NAME2", "DESC2", "STREET ул. Вечерняя", types.get(2)));
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
        new AccidentMem().add(1, new Accident(1, "NAME", "DESC", "STREET", types.get(2)));
//        List<Accident> list = new AccidentMem().getAll().stream().toList();
        System.out.println(new AccidentMem().getAll().stream().toList().get(0));
        System.out.println(map.size());
    }
}
