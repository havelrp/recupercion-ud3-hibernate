package model.dao;

import model.entities.Usuario;

import java.util.List;
public interface InterfaceDAO<T> {
    void create(T t);
    List<T> find();
    void update(T t);
    void delete(T t);
}