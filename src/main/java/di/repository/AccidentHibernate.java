package di.repository;


import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    public void save(Accident accident) {
        try (Session session = sf.openSession()) {
            session.save(accident);
        }
    }

    public void update(Accident accident) {
        try (Session session = sf.openSession()) {
            session.update(accident);
        }
    }

    public List <Accident> getAllAccident() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("FROM Accident ")
                    .list();
        }
    }

    public List<Rule> getAllRules() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("FROM Rule")
                    .list();
        }
    }


    public List<AccidentType> getAllTypes() {
        try (Session session = sf.openSession()) {
            return session
                    .createQuery("FROM AccidentType")
                    .list();
        }
    }

    public Accident get(Integer id) {
        try (Session session = sf.openSession()) {
            return (Accident) session
                    .createQuery("FROM Accident where id=:id").
                    setParameter("id", id).uniqueResult();
        }
    }
}
