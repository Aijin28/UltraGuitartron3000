package com.sda.javagda40.UltraGuitartron3000.chords;

import com.sda.javagda40.UltraGuitartron3000.database.HibernateUtil;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ChordsController {
    private static SessionFactory factory = HibernateUtil.getSessionFactory();

//    na pewno jest na to ładniejszy sposób, powinno dać się jednym query pobrać parę note'ów
    public static void gettingChord(Chords chord) {
        Transaction transaction = null;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            String first = "SELECT N.note FROM Notes N WHERE N.id = :first_note";
            Query firstQuery = session.createQuery(first);
            firstQuery.setParameter("first_note", chord.getFirsNote());
            String second = "SELECT N.note FROM Notes N WHERE N.id = :second_note";
            Query secondQuery = session.createQuery(second);
            secondQuery.setParameter("first_note", chord.getSecondNote());
            String third = "SELECT N.note FROM Notes N WHERE N.id = :third_note";
            Query thirdQuery = session.createQuery(third);
            thirdQuery.setParameter("first_note", chord.getThirdNote());
            String fourth = "SELECT N.note FROM Notes N WHERE N.id = :fourth_note";
            Query fourthQuery = session.createQuery(fourth);
            fourthQuery.setParameter("first_note", chord.getFourthNote());
            transaction.commit();
        } catch (HibernateError e) {
            if(transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public static void addingChord(String name, int first_note, int secont_note, int third_note, int fourth_note) {
        Transaction transaction = null;
        Integer chordID;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
            Chords newChord = new Chords();
            newChord.setChordName(name);
            newChord.setFirsNote(first_note);
            newChord.setSecondNote(secont_note);
            newChord.setThirdNote(third_note);
            newChord.setFourthNote(fourth_note);
            chordID = (Integer) session.save(newChord);
             transaction.commit();
        } catch (HibernateError e) {
            if(transaction!=null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
