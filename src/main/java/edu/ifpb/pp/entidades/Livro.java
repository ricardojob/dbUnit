package edu.ifpb.pp.entidades;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * @since 16/04/2011
 * @version 1.1
 * @author Neto Mardocê
 * @author Ricardo Job
 */
@Entity
@Table(uniqueConstraints = {
    @UniqueConstraint(columnNames = "isbn")})
public class Livro implements Serializable {

    @Id
    @GeneratedValue
    private int id;
    private String titulo;
    private String ISBN;
    private double valor;
    private String anoPublicacao;
    @ManyToOne
    private Editora editora;
    @Enumerated(EnumType.STRING)
    private Origem origem;

    public enum Origem {

        Nacional,
        Estrangeira
    }

    public Livro() {
    }

    
    public Livro( String titulo, String ISBN, double valor, String anoPublicacao, Editora editora, Origem origem) {
         
        this.titulo = titulo;
        this.ISBN = ISBN;
        this.valor = valor;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.origem = origem;
    }

    public String getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(String anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getISBN() {
        return ISBN;
    }

    public Editora getEditora() {
        return editora;
    }

    public int getId() {
        return id;
    }

    public Origem getOrigem() {
        return origem;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getValor() {
        return valor;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }

    public void setOrigem(Origem origem) {
        this.origem = origem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
