package edu.ifpb.pp.infraestrutura;

import java.util.List;

/**
 * @author Ricardo Job
 */
public interface GenericDAO<T> {

    public int tamanho();

    public T find(int i);

    public boolean save(T e);
    
    public List<T> all();

}
