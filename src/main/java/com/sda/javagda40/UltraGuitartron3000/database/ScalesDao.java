package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.chords.Chords;
import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ScalesDao {
    private final HibernateFactory hibernateFactory = new HibernateFactory();
    public List<String> findAllScaleNames(){
        List<String> list = new ArrayList<>();

        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<String> criteriaQuery = cb.createQuery(String.class);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<Scales> rootTable = criteriaQuery.from(Scales.class);

            // wykonanie zapytania
            criteriaQuery.select(rootTable.get("scaleName"));

            // specification
            list.addAll(session.createQuery(criteriaQuery).list());

        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return list;
    }

    public Optional<Scales> findByScalesName(String scaleChoice) {
        SessionFactory sessionFactory = hibernateFactory.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

            // narzędzie do tworzenia zapytań i kreowania klauzuli 'where'
            CriteriaBuilder cb = session.getCriteriaBuilder();

            // obiekt reprezentujący zapytanie
            CriteriaQuery<Scales> criteriaQuery = cb.createQuery(Scales.class);

            // obiekt reprezentujący tabelę bazodanową.
            // do jakiej tabeli kierujemy nasze zapytanie?
            Root<Scales> rootTable = criteriaQuery.from(Scales.class);

            // wykonanie zapytania
            criteriaQuery.select(rootTable).where(
                    cb.equal(rootTable.get("scaleName"), scaleChoice)
            );

            // poznanie uniwersalnego rozwiązania które działa z każdą bazą danych
            // używanie klas których będziecie używać na JPA (Spring)

            return Optional.ofNullable(session.createQuery(criteriaQuery).getSingleResult());
        } catch (HibernateException he) {
            he.printStackTrace();
        }
        return Optional.empty();
    }

    public void fillingScales(){
        EntityDao<Scales> scalesEntityDao = new EntityDao<>();
        ScalesDao scalesDao = new ScalesDao();
        if (scalesDao.findByScalesName("Jońska").isEmpty()) {
            Scales ionian = new Scales("Jońska",1,3,5,6,8,10,12);
            scalesEntityDao.saveOrUpdate(ionian);
        }
        if (scalesDao.findByScalesName("Dorycka").isEmpty()) {
            Scales dorian = new Scales("Dorycka",1,3,4,6,8,10,11);
            scalesEntityDao.saveOrUpdate(dorian);
        }
        if (scalesDao.findByScalesName("Frygijska").isEmpty()) {
            Scales phrygian = new Scales("Frygijska",1,2,4,6,8,9,11);
            scalesEntityDao.saveOrUpdate(phrygian);
        }
        if (scalesDao.findByScalesName("Lidyjska").isEmpty()) {
            Scales lydian = new Scales("Lidyjska",1,3,5,7,8,10,12);
            scalesEntityDao.saveOrUpdate(lydian);
        }
        if (scalesDao.findByScalesName("Miksolidyjska").isEmpty()) {
            Scales mixolydian = new Scales("Miksolidyjska",1,3,5,6,8,10,11);
            scalesEntityDao.saveOrUpdate(mixolydian);
        }
        if (scalesDao.findByScalesName("Eolska").isEmpty()) {
            Scales aeolian = new Scales("Eolska",1,3,4,6,8,9,11);
            scalesEntityDao.saveOrUpdate(aeolian);
        }
        if (scalesDao.findByScalesName("Lokrycka").isEmpty()) {
            Scales locrian = new Scales("Lokrycka",1,2,4,6,8,9,11);
            scalesEntityDao.saveOrUpdate(locrian);
        }
        if (scalesDao.findByScalesName("Molowa harmoniczna").isEmpty()) {
            Scales harmonicMinor = new Scales("Molowa harmoniczna", 1, 3, 4, 6, 8, 9, 12);
            scalesEntityDao.saveOrUpdate(harmonicMinor);
        }
        if (scalesDao.findByScalesName("Frygijska dominantowa").isEmpty()) {
            Scales phyrgianDominant = new Scales("Frygijska dominantowa", 1, 2, 5, 6, 8, 9, 11);
            scalesEntityDao.saveOrUpdate(phyrgianDominant);
        }
    }
}
