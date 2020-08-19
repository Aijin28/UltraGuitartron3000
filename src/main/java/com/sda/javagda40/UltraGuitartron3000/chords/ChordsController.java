package com.sda.javagda40.UltraGuitartron3000.chords;

import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class ChordsController {
    private static SessionFactory factory;

    public static void gettingChord(Chords chord) {
        Transaction transaction;
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
            e.printStackTrace();
        }
    }

    public static void addingChord(String name, int first_note, int secont_note, int third_note, int fourth_note) {
        Transaction transaction;
        try (Session session = factory.openSession()) {
            transaction = session.beginTransaction();
             String addedChord = "INSERT INTO Chords (name, firstNote, secondNote, thirdNote, fourthNote)" +
                    "VALUES (?, ?, ?, ?, ?)";
             Query addingQuery = session.createQuery(addedChord);
             addingQuery.setParameter(1, name);
             addingQuery.setParameter(2, first_note);
             addingQuery.setParameter(3, secont_note);
             addingQuery.setParameter(4, third_note);
             addingQuery.setParameter(5, fourth_note);
             transaction.commit();
        } catch (HibernateError e) {
            e.printStackTrace();
        }
    }
}
