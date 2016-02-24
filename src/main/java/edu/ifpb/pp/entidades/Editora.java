package edu.ifpb.pp.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @since 16/04/2011
 * @version 1.1
 * @author Neto Mardocê
 * @author Ricardo Job
 */
@Entity
public class Editora implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String nome;
    private String email;
    private String site;
    @OneToMany(mappedBy = "editora", cascade = {CascadeType.ALL})
    private List<Livro> publicacoes;
    @Embedded
    private Endereco endereco;

    public Editora() {
        this.publicacoes = new ArrayList<>();
    }

    public Editora(String nome, String email, String site) {
        this();
        this.nome = nome;
        this.email = email;
        this.site = site;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getSite() {
        return site;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void addPublicacao(Livro livro) {
        this.publicacoes.add(livro);
    }

    public void removePublicacao(Livro livro) {
        this.publicacoes.remove(livro);
    }
}
