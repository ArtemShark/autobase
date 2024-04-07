package com.company.autobase.services;
import java.util.List;

public interface CRUDInterface<T> {
    List<T> saveList(List<T> objectsList);
    T save(T object);
    void delete(T object);
    void deleteList();
    T update(T object);

    List<T> find();
}
