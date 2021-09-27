package di.repository;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

//@Repository
public class AccidentMem {
    static Map<Integer, Accident> map = new ConcurrentHashMap<>();
    static Set<AccidentType> types = new HashSet<>();
    static Set<Rule> rules = new HashSet<>();

    {
        rules.add(Rule.of(1, "Статья. 1"));
        rules.add(Rule.of(2, "Статья. 2"));
        rules.add(Rule.of(3, "Статья. 3"));
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));
//        map.put(1, new Accident(1, "NAME", "DESC", "STREET ул. им. Жукова", types.(0), rules.get(1)));
//        map.put(2, new Accident(2, "NAME1", "DESC1", "STREET ул. Майская", types.get(1), rules.get(0)));
//        map.put(3, new Accident(3, "NAME2", "DESC2", "STREET ул. Вечерняя", types.get(2), rules.get(2)));
    }

    public void add(Integer id, Accident accident) {
        map.put(id, accident);
    }

    public Accident get(Integer id) {
        return map.get(id);
    }

    public List<Accident> getAll() {
        return map.values().stream().toList();
    }

    public void delete(Integer id) {
        map.remove(id, map.get(id));
    }

    public void delete(Accident accident) {
        map.remove(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        map.replace(accident.getId(), accident);
    }

    public static void main(String[] args) {
        new AccidentMem().add(1, new Accident(1, "NAME", "DESC", "STREET",
                types.stream().filter(data -> data.getId() == 1).findFirst().get(), rules.stream().filter(data -> data.getId() == 1).findFirst().get()));
        System.out.println(new AccidentMem().getAll().stream().toList().get(0));
        System.out.println(map.size());
        System.out.println();
    }

    public static List<AccidentType> getTypes() {
        return types.stream().toList();
    }

    public static void setTypes(List<AccidentType> types) {
        AccidentMem.types = new HashSet<>(types);
    }

    public static List<Rule> getRules() {
        return rules.stream().toList();
    }

    public static void setRules(List<Rule> rules) {
        AccidentMem.rules = new HashSet<>(rules);
    }
}
