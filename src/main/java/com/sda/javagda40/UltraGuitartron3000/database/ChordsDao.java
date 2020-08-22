package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChordsDao {
    private final HibernateFactory hibernateFactory = new HibernateFactory();

    // TODO: uzupełnić pozostałe chord'y - jeśli są w bazie, to nie dodajemy ich
    public void fillingChords(){
        EntityDao<Chords> chordsDAO = new EntityDao<>();
        ChordsDao chordDao = new ChordsDao();
        if (!chordDao.findByChordName("maj7").isPresent()) {
            Chords xmaj7 = new Chords("maj7", 1, 5, 8, 12);
            chordsDAO.saveOrUpdate(xmaj7);
        }
        if (!chordDao.findByChordName("7").isPresent()) {
            Chords x7 = new Chords("7", 1, 5, 8, 11);
            chordsDAO.saveOrUpdate(x7);
        }
        if (!chordDao.findByChordName("min7").isPresent()) {
            Chords xmin7 = new Chords("min7", 1, 4, 8, 11);
            chordsDAO.saveOrUpdate(xmin7);

        }
        if (!chordDao.findByChordName("min7/5b").isPresent()) {
            Chords xmin75b = new Chords("min7/5b", 1, 4, 7, 11);
            chordsDAO.saveOrUpdate(xmin75b);
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
        } catch (HibernateException he) {
            he.printStackTrace();
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

}
