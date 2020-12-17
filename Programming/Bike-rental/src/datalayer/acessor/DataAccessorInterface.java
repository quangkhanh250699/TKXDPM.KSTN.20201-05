package datalayer.acessor;

import java.util.List;

public interface DataAccessorInterface<T> {
    public T get(int id);
    public List<T> getAll();
    public void update(T t);
    public void save(T t);
    public void delete(T t);
}
