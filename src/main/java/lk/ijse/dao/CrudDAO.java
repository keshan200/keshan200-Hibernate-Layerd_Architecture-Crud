package lk.ijse.dao;

import java.util.ArrayList;

public interface CrudDAO<T> extends SuperDAO {



    boolean save(T dto) throws Exception;
    boolean update(T dto);
    boolean delete(String dto);

    ArrayList<T> getAll();
}
