package by.it_academy.jd2.Mk_JD2_98_23.dao.api;

import java.util.List;

public interface ICRUDdao<T> {
    List<T> get();
    T get(int id);
    T save(T gen);
}
