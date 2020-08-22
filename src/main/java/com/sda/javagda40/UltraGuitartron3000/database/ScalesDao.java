package com.sda.javagda40.UltraGuitartron3000.database;

import com.sda.javagda40.UltraGuitartron3000.scales.Scales;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

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
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void fillingScales(){
        EntityDao<Scales> scalesDAO = new EntityDao<>();
        Scales ionian = new Scales("Jońska",1,3,5,6,8,10,12);
        scalesDAO.saveOrUpdate(ionian);
        Scales dorian = new Scales("Dorycka",1,3,4,6,8,10,11);
        scalesDAO.saveOrUpdate(dorian);
        Scales phrygian = new Scales("Frygijska",1,2,4,6,8,9,11);
        scalesDAO.saveOrUpdate(phrygian);
        Scales lydian = new Scales("Lidyjska",1,3,5,7,8,10,12);
        scalesDAO.saveOrUpdate(lydian);
        Scales mixolydian = new Scales("Miksolidyjska",1,3,5,6,8,10,11);
        scalesDAO.saveOrUpdate(mixolydian);
        Scales aeolian = new Scales("Eolska",1,3,4,6,8,9,11);
        scalesDAO.saveOrUpdate(aeolian);
        Scales locrian = new Scales("Lokrycka",1,2,4,6,8,9,11);
        scalesDAO.saveOrUpdate(locrian);
        Scales harmonicMinor = new Scales("Molowa harmoniczna", 1, 3, 4, 6, 8, 9, 12);
        scalesDAO.saveOrUpdate(harmonicMinor);
        Scales phyrgianDominant = new Scales("Frygijska dominantowa", 1, 2, 5, 6, 8, 9, 11);
        scalesDAO.saveOrUpdate(phyrgianDominant);
    }
}
