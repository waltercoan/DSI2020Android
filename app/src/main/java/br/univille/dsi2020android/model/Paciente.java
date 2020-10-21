package br.univille.dsi2020android.model;

import java.util.Date;

public class Paciente {
    private long id;
    private String nome;
    private String sexo;
    private Date dataNascimento;

    public String toString(){
        return this.nome;
    }
    public long getId() {
        return id;
    }
    public Date getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setId(long id) {
        this.id = id;
    }
}
