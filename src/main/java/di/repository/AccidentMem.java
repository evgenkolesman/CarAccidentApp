package di.repository;

import di.model.Accident;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;


@Repository
public class AccidentMem {
    static HashMap<Integer, Accident> map = new HashMap<>();

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

    public static void main(String[] args) {
        new AccidentMem().add(1, new Accident(1, "NAME", "DESC", "STREET"));
//        List<Accident> list = new AccidentMem().getAll().stream().toList();
        System.out.println(new AccidentMem().getAll().stream().toList().get(0));
        System.out.println(map.size());
    }
}
