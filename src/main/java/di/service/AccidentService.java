package di.service;

import di.model.*;
import di.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * private final AccidentJdbcTemplate store; - подключить для JDBC
 * private final AccidentMem store; - подключить для работы с локального компа
 * private final AccidentHibernate store; - подключить для работы на Hibernate
 * <p>
 * Service uses for connecting our DB(repositories) with
 * controllers and others may have some logic
 * for example saveOrEdit
 * <p>
 * Note: under all methods I save some another versions of service
 * for another types pf repository
 */

@Service
public class AccidentService {

    private final AccidentRepository accidentStore;
    private final AccidentRuleRepository ruleStore;
    private final AccidentTypeRepository typeStore;
    private final AuthorityRepository authorities;
    private final UserRepository users;

    @Autowired
    public AccidentService(AccidentRepository accidentStore,
                           AccidentRuleRepository ruleStore, AccidentTypeRepository typeStore,
                           AuthorityRepository authorities, UserRepository users) {
        this.accidentStore = accidentStore;
        this.ruleStore = ruleStore;
        this.typeStore = typeStore;
        this.authorities = authorities;
        this.users = users;
    }

    public Accident saveOrEdit(Accident accident) {
        return accidentStore.save(accident);
    }

    public User saveOrEdit(User user) {
        return users.save(user);
    }

    public List<Accident> getAll() {
        ArrayList<Accident> list = new ArrayList();
        accidentStore.findAll().forEach(list::add);
        return list;
    }

    public List<Rule> getRules() {
        ArrayList<Rule> list = new ArrayList();
        ruleStore.findAll().forEach(list::add);
        return list;
    }

    public List<AccidentType> getTypes() {
        ArrayList<AccidentType> list = new ArrayList();
        typeStore.findAll().forEach(list::add);
        return list;
    }

    public AccidentType getType(String[] type) {
        return getTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get();
    }

    public Rule getRule(String[] rules) {
        return getRules().stream().filter(x -> x.getId() == Integer.parseInt(rules[0])).findFirst().get();
    }

    public Accident get(Integer id) {
        return accidentStore.findById(id).get();
    }

    public Authority findByAuthority(String name) {
        return authorities.findByAuthority(name);
    }

    public User findUserByName(String userName) {
        return users.findUserByUsername(userName);
    }

    public User findUserById(Integer id) {
        return users.findUserById(id);
    }

    public void deleteAccidentById(int id) {
        accidentStore.deleteById(id);
    }

    public Accident findAccidentById(int id) {
        return accidentStore.findById(id).get();
    }
}

/**
 * Это сервис для Hibernate
 *
 * @Autowired public AccidentService(AccidentHibernate store) {
 * this.store = store;
 * }
 * <p>
 * public void saveOrEdit(Accident accident) {
 * store.saveOrUpdate(accident);
 * }
 * <p>
 * public List<Accident> getAll() {
 * return store.getAllAccident();
 * }
 * <p>
 * public List<Rule> getRules() {
 * return store.getAllRules();
 * }
 * <p>
 * public List<AccidentType> getTypes() {
 * return store.getAllTypes();
 * }
 * <p>
 * public AccidentType getType(String[] type) {
 * return store.getAllTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get();
 * }
 * <p>
 * public Rule getRule(String[] rules) {
 * return store.getAllRules().stream().filter(x -> x.getId() == Integer.parseInt(rules[0])).findFirst().get();
 * }
 * <p>
 * public Accident get(Integer id) {
 * return store.get(id);
 * }
 * <p>
 * <p>
 * Это сервис для применения на основе AccidentJdbcTemplate
 * <p>
 * public void add(Accident accident) {
 * store.save(accident);
 * }
 * <p>
 * public void edit(Accident accident) {
 * store.update(accident);
 * }
 * <p>
 * public List<Accident> getAll() {
 * return store.getAllAccident();
 * }
 * <p>
 * public List<Rule> getRules() {
 * return store.getAllRules();
 * }
 * <p>
 * public List<AccidentType> getTypes() {
 * return store.getAllTypes();
 * }
 * <p>
 * public AccidentType getType(String[] type) {
 * return store.getAllTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get();
 * }
 * <p>
 * public Rule getRule(String[] rules) {
 * return store.getAllRules().stream().filter(x -> x.getId() == Integer.parseInt(rules[0])).findFirst().get();
 * }
 * <p>
 * public Accident get(Integer id) {
 * return store.get(id);
 * }
 * <p>
 * Это сервис для применения на основе AccidentMem
 * private final AccidentMem store;
 * @Autowired public AccidentService(AccidentMem store) {
 * this.store = store;
 * }
 * <p>
 * public void saveOrEdit(Accident accident) {
 * if (accident.getId() == 0) {
 * add(accident);
 * } else {
 * edit(accident);
 * }
 * //accident.getId() == 0 ? add(accident) : edit(accident); так почему то не работает
 * }
 * <p>
 * public void add(Accident accident) {
 * if (accident.getId() == 0) {
 * accident.setId(store.getAll().size() + 1);
 * }
 * store.add(accident.getId(), accident);
 * }
 * <p>
 * public void edit(Accident accident) {
 * store.edit(accident);
 * }
 * <p>
 * public List<Accident> getAll() {
 * return store.getAll();
 * }
 * <p>
 * public Accident get(Integer id) {
 * return store.get(id);
 * }
 * <p>
 * public void delete(Accident accident) {
 * store.delete(accident);
 * }
 * <p>
 * public List<Rule> getRules() {
 * return store.getRules();
 * }
 * <p>
 * public List<AccidentType> getTypes() {
 * return store.getTypes();
 * }
 * <p>
 * public AccidentType getType(String[] type) {
 * return store.getTypes().stream().filter(x -> x.getId() == Integer.parseInt(type[0])).findFirst().get();
 * }
 * <p>
 * public Rule getRule(String[] rules) {
 * return store.getRules().stream().filter(x -> x.getId() == Integer.parseInt(rules[0])).findFirst().get();
 * }
 * }
 */
