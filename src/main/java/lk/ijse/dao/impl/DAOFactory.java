package lk.ijse.dao.impl;

import lk.ijse.dao.CustomerDAO;
import lk.ijse.dao.SuperDAO;

public class DAOFactory {


    private static DAOFactory daoFactory;


    private DAOFactory() {}


   public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            daoFactory = new DAOFactory();
        }
        return daoFactory;
   }



   public SuperDAO getSuperDAO(DAOTypes daoType) {
        switch (daoType){
            case customer :
                return new CusromerDAOImpl();
        }
     return null;
    }

}
