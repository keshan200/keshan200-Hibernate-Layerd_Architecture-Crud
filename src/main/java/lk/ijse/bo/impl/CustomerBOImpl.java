package lk.ijse.bo.impl;

import lk.ijse.DTO.CustomerDTO;
import lk.ijse.bo.CustomerBO;
import lk.ijse.dao.CustomerDAO;
import lk.ijse.dao.impl.DAOFactory;
import lk.ijse.dao.impl.DAOTypes;
import lk.ijse.entity.Customer;

import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {


    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getSuperDAO(DAOTypes.customer);


    @Override
    public boolean saveCustomer(CustomerDTO customer) throws Exception {
        return customerDAO.save(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
    }

    @Override
    public boolean updateCustomer(CustomerDTO customer) {
        return customerDAO.update(new Customer(customer.getId(), customer.getName(), customer.getAddress()));
    }

    @Override
    public boolean deleteCustomer(String id) {
        return customerDAO.delete(id);
    }

    @Override
    public ArrayList<CustomerDTO> getAllCustomers() {

        ArrayList<Customer> all = customerDAO.getAll();
        ArrayList<CustomerDTO> customerDTOs = new ArrayList<>();

        for (Customer customer : all) {
            customerDTOs.add(new CustomerDTO(customer.getId(), customer.getName(), customer.getAddress()));
        }
        return customerDTOs;
    }

    @Override
    public Customer searchCustomer(String id) {
        return customerDAO.search(id);
    }
}
