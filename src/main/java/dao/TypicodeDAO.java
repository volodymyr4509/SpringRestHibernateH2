package dao;

import dto.Typicode;

import java.util.List;

/**
 * Created by volodymyr on 28.06.16.
 */
public interface TypicodeDAO {

    boolean save(Typicode typicode);

    boolean update(Typicode typicode);

    Typicode getByID(Long id);

    boolean delete(Typicode typicode);

    List<Typicode> getAll();

}
