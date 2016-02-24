package edu.ifpb.pp.entidades;

import edu.ifpb.pp.infraestrutura.GenericDAO;
import edu.ifpb.pp.infraestrutura.GenericRepository;
import edu.ifpb.pp.infraestrutura.db.DBUnitHelper;

import org.junit.After;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @version 1.0
 * @author Ricardo Job
 */
public class EditoraRepositoryTest {

    private GenericDAO<Editora> repository;

    @Before
    public void setUp() throws Exception {
        new DBUnitHelper().cleanInsert("/tabelas/editora.xml");
        new DBUnitHelper().cleanInsert("/tabelas/livro.xml");
        repository = new GenericRepository<>(Editora.class);
    }

    @Test
    public void testFind() {
        Editora editora = repository.find(3);
        assertNotNull(editora);
        assertEquals("Chespirito", editora.getNome());
    }

    @Test
    public void testInsert() {
        Editora e = new Editora("Aula de Práticas", "chave@gmail.com", "chave.com");
        e.setEndereco(new Endereco("Cidade", "rua", "d", "12"));
        Livro livro = new Livro("L1", "11", 26.5, "2014", e, Livro.Origem.Nacional);
        e.addPublicacao(livro);

        repository.save(e);

        Editora editora = repository.find(e.getId());
        assertNotNull(editora);
        assertFalse("Chaves".equals(editora.getNome()));
        assertEquals("Aula de Práticas", editora.getNome());
        
    }

    @Test
    public void deveListarTodosOsTiposDaNotificacao() throws Exception {
        assertTrue(repository.tamanho() == 1);
    }

    @After
    public void tearDown() throws Exception {
        new DBUnitHelper().deleteAll("/tabelas/livro.xml");
        new DBUnitHelper().deleteAll("/tabelas/editora.xml");
    }
}
