package di.model;

import javax.persistence.*;
import java.text.MessageFormat;
import java.util.Objects;
import java.util.Set;

/**
 * Entity with data accidents
 * @id
 * @name naming of accident
 * @text description of accident
 * @address address where was accident
 * @type accident type data
 * @rule rule data
 */

@Entity
@Table(name = "accident")
public class Accident {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String text;
    @Column(name = "adress")
    private String address;
    @ManyToOne
    @JoinColumn(name = "atype_id")
    private AccidentType type;
    @ManyToOne
    @JoinColumn(name = "rule_id")
    private Rule rule;

    public Accident() {
    }

    public Accident(int id, String name, String text, String address, AccidentType type, Rule rule) {
        this.id = id;
        this.name = name;
        this.text = text;
        this.address = address;
        this.type = type;
        this.rule = rule;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public AccidentType getType() {
        return type;
    }

    public void setType(AccidentType type) {
        this.type = type;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Accident accident = (Accident) o;
        return id == accident.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return MessageFormat.format(
                "Accident'{'id={0}, name=''{1}'', text=''{2}'', address=''{3}'', type={4}, rule={5}'}'",
                id, name, text, address, type, rule);
    }
}
