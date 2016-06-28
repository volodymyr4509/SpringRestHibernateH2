package dao;

import dto.Typicode;
import org.hibernate.Session;
import org.hibernate.Transaction;
import util.HibernateHelper;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by volodymyr on 28.06.16.
 */
public class TypicodeDAOImpl implements TypicodeDAO {

    public boolean save(Typicode typicode) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;

        try {
            transaction = session.beginTransaction();
            session.save(typicode);
            transaction.commit();
            status = true;
        } catch (Exception ex) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    public boolean update(Typicode typicode) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;

        try {
            transaction = session.beginTransaction();
            session.update(typicode);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return status;
    }


    public Typicode getByID(Long id) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        Typicode typicode = null;

        try {
            transaction = session.beginTransaction();
            typicode = (Typicode) session.get(Typicode.class, id);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return typicode;
    }


    public boolean delete(Typicode typicode) {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        boolean status = false;

        try {
            transaction = session.beginTransaction();
            session.delete(typicode);
            transaction.commit();
            status = true;
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }

        return status;
    }

    public List<Typicode> getAll() {
        Session session = HibernateHelper.getSessionFactory().openSession();
        Transaction transaction = null;
        List<Typicode> typicodes = new ArrayList<>();

        try {
            transaction = session.beginTransaction();
            typicodes = session.createCriteria(Typicode.class).list();
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return typicodes;
    }


}
