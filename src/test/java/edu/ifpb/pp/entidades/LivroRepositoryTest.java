package edu.ifpb.pp.entidades;

import edu.ifpb.pp.infraestrutura.GenericDAO;
import edu.ifpb.pp.infraestrutura.GenericRepository;
import edu.ifpb.pp.infraestrutura.db.DBUnitHelper;

import org.junit.After;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @since 17/11/2014
 * @version 1.0
 * @author Ricardo Job
 */
public class LivroRepositoryTest {

    private GenericDAO<Livro> repository;

    @Before
    public void setUp() throws Exception {
        new DBUnitHelper().cleanInsert("/tabelas/editora.xml");
        new DBUnitHelper().cleanInsert("/tabelas/livro.xml");
        repository = new GenericRepository<>(Livro.class);
    }

    @Test
    public void testFind() {
        Livro livro = repository.find(1);
        assertNotNull(livro);
        assertEquals("ipad", livro.getTitulo());
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
