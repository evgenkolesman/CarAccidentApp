package di.repository;


import di.model.Accident;
import di.model.AccidentType;
import di.model.Rule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class AccidentHibernate {
    private final SessionFactory sf;

    public AccidentHibernate(SessionFactory sf) {
        this.sf = sf;
    }

    @Transactional
    public void saveOrUpdate(Accident accident) {
        Session session = sf.getCurrentSession();
        session.saveOrUpdate(accident);
    }

    @Transactional
    public List<Accident> getAllAccident() {
        Session session = sf.getCurrentSession();
        return session.createQuery("FROM Accident ")
                .list();
    }

    @Transactional
    public List<Rule> getAllRules() {
        Session session = sf.getCurrentSession();
        return session.createQuery("FROM Rule")
                .list();
    }

    @Transactional
    public List<AccidentType> getAllTypes() {
        Session session = sf.getCurrentSession();
        return session
                .createQuery("FROM AccidentType")
                .list();
    }

    public Accident get(Integer id) {
        Session session = sf.getCurrentSession();
        return (Accident) session
                .createQuery("FROM Accident where id=:id").
                setParameter("id", id).uniqueResult();
    }

}
