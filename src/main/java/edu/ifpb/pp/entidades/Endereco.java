package edu.ifpb.pp.entidades;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 * @since 16/04/2011
 * @version 1.1
 * @author Neto Mardocê
 * @author Ricardo Job
 */
@Embeddable
public class Endereco implements Serializable {

    private String cidade;
    private String rua;
    private String bairro;
    private String numero;

    public Endereco() {
    }

    public Endereco(String cidade, String rua, String bairro, String numero) {
        this.cidade = cidade;
        this.rua = rua;
        this.bairro = bairro;
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }
}
