package lk.ijse;

import lk.ijse.DTO.CustomerDTO;
import lk.ijse.config.FactoryConfiguration;
import lk.ijse.dao.CustomerDAO;
import lk.ijse.dao.impl.DAOFactory;
import lk.ijse.dao.impl.DAOTypes;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class LauncherWrapper {
    public static void main(String[] args) {


       /* Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        Customer customer = new Customer();
        customer.setId("1");
        customer.setName("Keshan");
        customer.setAddress("negombo");



        session.save(customer);
        transaction.commit();
*/

        Launcher.main(args);
    }
}