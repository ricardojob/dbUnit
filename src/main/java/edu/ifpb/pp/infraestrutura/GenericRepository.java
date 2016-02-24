package edu.ifpb.pp.infraestrutura;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @version 1.0
 * @author Ricardo Job
 */
public class GenericRepository<T> implements GenericDAO<T> {

    private final EntityManager entityManager;
    protected Class<T> clazz;
    private final String persistenceName = "DbUnit_Teste";

    public GenericRepository(Class<T> classz) {
        this.entityManager = Persistence.createEntityManagerFactory(persistenceName).createEntityManager();
        this.clazz = classz;
    }

   
    @Override
    public T find(int i) {
        return entityManager.find(clazz, i);
    }

    @Override
    public boolean save(T e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
        return true;
    }

    @Override
    public List<T> all() {
        Query query = entityManager.createQuery(" Select t From " + clazz.getSimpleName() + " t");
        return query.getResultList();
    }
     @Override
    public int tamanho() {
        return all().size();
    }


}
