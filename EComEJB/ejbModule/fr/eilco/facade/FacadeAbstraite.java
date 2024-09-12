package fr.eilco.facade;

import java.util.ArrayList;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public abstract class  FacadeAbstraite<T> {
	
	public abstract void create(T entity);
    public abstract void edit(T entity);
    public abstract void remove(T entity);
    public abstract T find(Object id);
    public abstract ArrayList<T> findAll();
}
