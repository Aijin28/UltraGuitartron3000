package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChordsDao {
    private final HibernateFactory hibernateFactory = new HibernateFactory();

    public void fillingChords(){
        EntityDao<Chords> chordsEntityDao = new EntityDao<>();
        ChordsDao chordDao = new ChordsDao();
        if (chordDao.findByChordName("maj7").isEmpty()) {
            Chords xmaj7 = new Chords("maj7", 0, 4, 7, 11);
            chordsEntityDao.saveOrUpdate(xmaj7);
        }
        if (chordDao.findByChordName("7").isEmpty()) {
            Chords x7 = new Chords("7", 0, 4, 7, 10);
            chordsEntityDao.saveOrUpdate(x7);
        }
        if (chordDao.findByChordName("min7").isEmpty()) {
            Chords xmin7 = new Chords("min7", 0, 3, 7, 10);
            chordsEntityDao.saveOrUpdate(xmin7);

        }
        if (chordDao.findByChordName("min7/5b").isEmpty()) {
            Chords xmin75b = new Chords("min7/5b", 0, 3, 6, 10);
            chordsEntityDao.saveOrUpdate(xmin75b);
        }
    }

    public Optional<Chords> findByChordName(String chordTypeChoice) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<Chords> criteriaQuery = cb.createQuery(Chords.class);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<Chords> rootTable = criteriaQuery.from(Chords.class);

            // wykonanie zapytania
            criteriaQuery.select(rootTable).where(
                    cb.equal(rootTable.get("chordName"), chordTypeChoice)
            );

            // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
            // używanie klas których będziecie używać na JPA (Spring)

            return Optional.ofNullable(session.createQuery(criteriaQuery).getSingleResult());
        } catch (HibernateException | NoResultException he) {
            System.err.println(he.getMessage());
        }
        return Optional.empty();
    }

    public List<String> findChordNames() {
        List<String> list = new ArrayList<>();
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();

            try (Session session = sessionFactory.openSession()) {

                // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
                CriteriaBuilder cb = session.getCriteriaBuilder();

                // obiekt reprezentujący zapytanie
                CriteriaQuery<String> criteriaQuery = cb.createQuery(String.class);         // czego szukamy

                // obiekt reprezentujący tabelę bazodanową.
                // do jakiej tabeli kierujemy nasze zapytanie?
                Root<Chords> rootTable = criteriaQuery.from(Chords.class);                  // gdzie szukamy

                // wykonanie zapytania
                criteriaQuery.select(rootTable.get("chordName"));

                // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
                // używanie klas których będziecie używać na JPA (Spring)

                list.addAll(session.createQuery(criteriaQuery).list());

            } catch (HibernateException he) {
                he.printStackTrace();
            }
        return list;
    }

    public void delete(Integer id) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Chords chordToDelete = (Chords) session.load(Chords.class, id);
            session.delete(chordToDelete);
            session.flush();
            transaction.commit();
        } catch (HibernateException he) {
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

}
