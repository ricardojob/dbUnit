package edu.ifpb.pp.infraestrutura;

import edu.ifpb.pp.entidades.Editora;
import java.util.Iterator;

/**
 * @version 1.0
 * @author Ricardo Job
 * Esta classe será utilizada no teste de integração com Mock
 */
public class RepositorioDeEditora{

    private GenericDAO<Editora> dao;

    protected RepositorioDeEditora() {
        this(new GenericRepository<>(Editora.class));
    }

    public RepositorioDeEditora(GenericDAO<Editora> dao) {
        this.dao = dao;
    }
    
    public boolean salvar(Editora editora){
        return dao.save(editora);
    }

    public Iterator<Editora> listarEditora(){
        return dao.all().iterator();
    }

    public int tamanho(){
        return dao.tamanho();
    }
}
