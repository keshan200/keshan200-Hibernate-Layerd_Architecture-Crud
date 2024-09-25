package lk.ijse.dao.impl;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.CustomerDAO;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.ArrayList;
import java.util.List;

public class CusromerDAOImpl implements CustomerDAO {



    @Override
    public boolean save(Customer customer) throws Exception {

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        Object obj = session.save(customer);

        if(obj != null){
            tx.commit();
            session.close();
            return true;
        }
        return false;
    }



    @Override
    public boolean update(Customer customer) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        session.update(customer);
        tx.commit();
        session.close();

        return true;
    }



    @Override
    public boolean delete(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        NativeQuery query = session.createNativeQuery("delete from Customer where id=?1");
        query.setParameter(1, id);
        query.executeUpdate();


        tx.commit();
        session.close();
        return true;
    }

    @Override
    public ArrayList<Customer> getAll() {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        ArrayList<Customer> cus = new ArrayList<>();
        NativeQuery query = session.createNativeQuery("select * from Customer");

        List<Object[]> list = query.list();
        for(Object[] obj : list){
            Customer customer = new Customer(obj[0].toString(),obj[1].toString(),obj[2].toString());

            cus.add(customer);
        }
        tx.commit();
        session.close();
        return cus;
    }

    @Override
    public Customer search(String id) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction tx = session.beginTransaction();

        ArrayList<Customer> cus = new ArrayList<>();
        NativeQuery query = session.createNativeQuery("select * from Customer where id=?1");

        query.setParameter(1, id);
        List<Object[]> list = query.list();

        for(Object[] obj : list){
            Customer customer1 = new Customer(obj[0].toString(),obj[1].toString(),obj[2].toString());
            System.out.println(obj[0].toString()+""+obj[1].toString()+""+obj[2].toString());
            tx.commit();
            session.close();
            return customer1;
        }

        return null;
    }
}
