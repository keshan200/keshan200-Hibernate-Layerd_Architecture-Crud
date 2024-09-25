package lk.ijse.bo;

import lk.ijse.bo.impl.CustomerBOImpl;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory() {

    }



    public static BOFactory getBoFactory() {
        if (boFactory == null) {
            boFactory = new BOFactory();
        }
        return boFactory;
    }


    public SuperBO getSuperBO(BOTypes botype) {
        switch (botype) {
            case Customerbo:
                return new CustomerBOImpl();

        }
        return null;
    }

}
