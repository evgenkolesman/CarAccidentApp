package di.repository;

import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccidentJdbcTemplate {
    private final JdbcTemplate jdbc;

    public AccidentJdbcTemplate(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public void save(Accident accident) {
        jdbc.update("insert into accident (name, text, adress, atype_id, rule_id) values (?, ?, ?, ?, ?)",
                accident.getName(), accident.getText(), accident.getAddress(), accident.getType().getId(), accident.getRule().getId());
    }

    public void update(Accident accident) {
        jdbc.update("update accident set name = ?, text = ?, adress = ?, atype_id =?, rule_id =?",
                accident.getName(), accident.getText(), accident.getType().getId(), accident.getRule().getId());
    }

    public List<Accident> getAllAccident() {
        return jdbc.query("select id, name, text, adress, atype_id, rule_id from accident",
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("adress"));
                    accident.setType(findType(rs.getInt("atype_id")));
                    accident.setRule(findRule(rs.getInt("rule_id")));
                    return accident;
                });
    }

    public List<AccidentType> getAllTypes() {
        return jdbc.query("select id, name from atype",
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));
                    return type;
                });
    }

    public List<Rule> getAllRules() {
        return jdbc.query("select id, name from rule",
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                });
    }

    public Rule findRule(Integer val) {
        String sql = String.format("select*from rule where id = %d", val);
        return jdbc.query(sql,
                (rs, row) -> {
                    Rule rule = new Rule();
                    rule.setId(rs.getInt("id"));
                    rule.setName(rs.getString("name"));
                    return rule;
                }).get(0);
    }

    public AccidentType findType(Integer val) {
        String sql = String.format("select*from atype where id = %d", val);
        return jdbc.query(sql,
                (rs, row) -> {
                    AccidentType type = new AccidentType();
                    type.setId(rs.getInt("id"));
                    type.setName(rs.getString("name"));
                    return type;
                }).get(0);
    }

    public Accident get(Integer id) {
        String sql = String.format("select*from accident where id = %d", id);
        return jdbc.query(sql,
                (rs, row) -> {
                    Accident accident = new Accident();
                    accident.setId(rs.getInt("id"));
                    accident.setName(rs.getString("name"));
                    accident.setText(rs.getString("text"));
                    accident.setAddress(rs.getString("adress"));
                    accident.setType(findType(rs.getInt("atype_id")));
                    accident.setRule(findRule(rs.getInt("rule_id")));
                    return accident;
                }).get(0);
    }
}
