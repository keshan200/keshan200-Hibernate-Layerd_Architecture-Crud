package lk.ijse.bo;

import lk.ijse.DTO.CustomerDTO;
import lk.ijse.entity.Customer;

import java.util.ArrayList;

public interface CustomerBO extends SuperBO {


    boolean saveCustomer(CustomerDTO customerDto) throws Exception;
    boolean updateCustomer(CustomerDTO customerDto);
    boolean deleteCustomer(String customer);

    ArrayList<CustomerDTO> getAllCustomers();
    Customer searchCustomer(String id);
}
