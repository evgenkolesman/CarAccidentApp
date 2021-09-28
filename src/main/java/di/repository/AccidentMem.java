package di.repository;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * необходимо дописать что бы заработало при смене на внуттреннюю БД на основе MAP
 * и поменять весь сервис
 * @Repository
 *
 */

public class AccidentMem {
    private final static Map<Integer, Accident> MAP = new ConcurrentHashMap<>();
    private Set<AccidentType> types = new HashSet<>();
    private Set<Rule> rules = new HashSet<>();

    {
        rules.add(Rule.of(1, "Статья. 1"));
        rules.add(Rule.of(2, "Статья. 2"));
        rules.add(Rule.of(3, "Статья. 3"));
        types.add(AccidentType.of(1, "Две машины"));
        types.add(AccidentType.of(2, "Машина и человек"));
        types.add(AccidentType.of(3, "Машина и велосипед"));

    }

    public void add(Integer id, Accident accident) {
        MAP.put(id, accident);
    }

    public Accident get(Integer id) {
        return MAP.get(id);
    }

    public List<Accident> getAll() {
        return MAP.values().stream().toList();
    }

    public void delete(Integer id) {
        MAP.remove(id, MAP.get(id));
    }

    public void delete(Accident accident) {
        MAP.remove(accident.getId(), accident);
    }

    public void edit(Accident accident) {
        MAP.replace(accident.getId(), accident);
    }

    public List<AccidentType> getTypes() {
        return types.stream().toList();
    }

    public void setTypes(List<AccidentType> types) {
        this.types = new HashSet<>(types);
    }

    public List<Rule> getRules() {
        return rules.stream().toList();
    }

    public void setRules(List<Rule> rules) {
        this.rules = new HashSet<>(rules);
    }
}
