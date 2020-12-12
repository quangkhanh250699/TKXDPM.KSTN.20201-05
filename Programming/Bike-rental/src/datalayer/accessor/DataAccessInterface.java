package datalayer.accessor;

import java.util.List;

public interface DataAccessInterface<T> {
    T get(String id);
    List<T> getAll();
    void update(T t);
    void save(T t);
    void delete(T t);
}
