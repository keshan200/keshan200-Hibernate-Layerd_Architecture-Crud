package lk.ijse.dao;

import lk.ijse.entity.Customer;

import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<Customer> {

    boolean save( Customer customer) throws Exception;
    boolean update(Customer customer);
    boolean delete(String id);

    ArrayList<Customer> getAll();
    Customer search( String id);



}
