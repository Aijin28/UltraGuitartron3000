package com.sda.javagda40.UltraGuitartron3000.chords;


import com.sda.javagda40.UltraGuitartron3000.database.HibernateFactory;
import com.sda.javagda40.UltraGuitartron3000.utils.NotesArray;
import org.hibernate.HibernateError;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ChordsController {
    private static final SessionFactory factory = new HibernateFactory().getSessionFactory();

//    //    na pewno jest na to ładniejszy sposób, powinno dać się jednym query pobrać parę note'ów
//    public static void gettingChord(Optional<Chords> optionalChord) {
//        Transaction transaction = null;
//        try (Session session = factory.openSession()) {
//            if (optionalChord.isPresent()) {
//                Chords chord = optionalChord.get();
//                transaction = session.beginTransaction();
//                String first = "SELECT N.note FROM Notes N WHERE N.id = :first_note";
//                Query firstQuery = session.createQuery(first);
//                firstQuery.setParameter("first_note", chord.getFirsNote());
//                String second = "SELECT N.note FROM Notes N WHERE N.id = :second_note";
//                Query secondQuery = session.createQuery(second);
//                secondQuery.setParameter("second_note", chord.getSecondNote());
//                String third = "SELECT N.note FROM Notes N WHERE N.id = :third_note";
//                Query thirdQuery = session.createQuery(third);
//                thirdQuery.setParameter("third_note", chord.getThirdNote());
//                String fourth = "SELECT N.note FROM Notes N WHERE N.id = :fourth_note";
//                Query fourthQuery = session.createQuery(fourth);
//                fourthQuery.setParameter("fourth_note", chord.getFourthNote());
//                transaction.commit();
//            } else {
//                System.out.println("Nie ma takeigo akordu.");
//            }
//        } catch (HibernateError e) {
//            if (transaction != null) transaction.rollback();
//            e.printStackTrace();
//        }
//    }

    public static List<String> gettingChordFromArray(Optional<Chords> optionalChord, String choice) {
        List<String> chosenChord = new ArrayList<>();
        if (optionalChord.isPresent()) {
            Chords chord = optionalChord.get();
            List<String> notesArray = NotesArray.getNotesArray();
            int zmienna = notesArray.indexOf(choice);
//            -1 wykorzystane, ponieważ listy indexuje się od 0, a chciałem zachować prawidłową numerację stopni w akordach
            chosenChord.add(notesArray.get(chord.getFirsNote() -1 + zmienna));
            chosenChord.add(notesArray.get(chord.getSecondNote() -1 + zmienna));
            chosenChord.add(notesArray.get(chord.getThirdNote() -1 + zmienna));
            chosenChord.add(notesArray.get(chord.getFourthNote() -1 + zmienna));
        return chosenChord;
        } else System.out.println("Nie ma takiego akordu.");
        return null;
    }

    public static void addingChord(String name, int first_note, int secont_note, int third_note, int fourth_note) throws InterruptedException {
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
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
        Thread.sleep(1000L);
    }
}
