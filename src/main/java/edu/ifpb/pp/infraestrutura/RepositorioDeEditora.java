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

    public RepositorioDeEditora() {
        this(new GenericRepository<>(Editora.class));
    }

    protected RepositorioDeEditora(GenericDAO<Editora> dao) {
        this.dao = dao;
    }
    
    public boolean salvar(Editora editora){
        return dao.save(editora);
    }

    public Iterator<Editora> listarPessoas(){
        return dao.all().iterator();
    }

    public int tamanho(){
        return dao.tamanho();
    }
}
