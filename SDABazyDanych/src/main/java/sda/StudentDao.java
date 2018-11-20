package sda;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

// data acces bject
public class StudentDao {
    public boolean saveStudentIntoDatabase(Student student) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Transaction transaction = null;
        try (
                Session session = sessionFactory.openSession()) {
            //otwiera transakcje
            transaction = session.beginTransaction();
            session.save(student);

            transaction.commit();
        } catch (
                SessionException se) {
            // w razie bledu przywroc stan z przed transakcji
            if (transaction != null) {
                transaction.rollback();
            }
            return false;
        }
        return true;
    }

    public List<Student> getAllStudentsFromDatabase() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {

//stworz zapytanie
            Query<Student> query = session.createQuery("from Student st ", Student.class);
// wywolaj zapytanie
            List<Student> students = query.list();
// zwroc wynik
            return students;

        } catch (SessionException se) {
//jesli cos pojdzie nie tak - wypisz komunikat loggerem
            //todo: logger
            System.err.println("Nie udalo sie pobrac z bazy");
        }
        // jesli nie uda sie znalezc zwracamy pusta linie
        return new ArrayList<>();
    }


}


