package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.trainee.Trainee;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TraineeDao {
    private final HibernateFactory hibernateFactory = new HibernateFactory();
    public void fillingUsers() {
        EntityDao<Trainee> traineeEntityDao = new EntityDao<>();
        TraineeDao traineeDao = new TraineeDao();
        if (traineeDao.findByUserName("Admin").isEmpty()) {
            Trainee admin = new Trainee("Admin", true);
            traineeEntityDao.saveOrUpdate(admin);
        }
        if (traineeDao.findByUserName("User").isEmpty()) {
            Trainee user = new Trainee("User");
            traineeEntityDao.saveOrUpdate(user);
        }
    }

    public Optional<Trainee> findByUserName(String traineeChoice) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<Trainee> criteriaQuery = cb.createQuery(Trainee.class);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<Trainee> rootTable = criteriaQuery.from(Trainee.class);

            // wykonanie zapytania
            criteriaQuery.select(rootTable).where(
                    cb.equal(rootTable.get("name"), traineeChoice)
            );

            // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
            // używanie klas których będziecie używać na JPA (Spring)

            return Optional.ofNullable(session.createQuery(criteriaQuery).getSingleResult());
        } catch (HibernateException | NoResultException he) {
            System.err.println(he.getMessage() + ". Loading trainee -- " + traineeChoice);
        }
        return Optional.empty();
    }

    public List<String> findUserNames() {
        List<String> list = new ArrayList<>();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<String> criteriaQuery = cb.createQuery(String.class);         // czego szukamy

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<Trainee> rootTable = criteriaQuery.from(Trainee.class);                  // gdzie szukamy

            // wykonanie zapytania
            criteriaQuery.select(rootTable.get("name"));

            // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
            // używanie klas których będziecie używać na JPA (Spring)

            list.addAll(session.createQuery(criteriaQuery).list());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

}
