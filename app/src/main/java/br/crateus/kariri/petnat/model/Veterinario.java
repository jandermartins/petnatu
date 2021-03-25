package br.crateus.kariri.petnat.model;

import br.crateus.kariri.petnat.activity.Endereco;

public class Veterinario {
    private String id;
    private String nome;
    private String cmfv;
    private String cpf;
    private String especialidade;

    public Veterinario(){

    }

    public Veterinario(String id, String nome, String cmfv, String cpf, String especialidade) {
        this.id = id;
        this.nome = nome;
        this.cmfv = cmfv;
        this.cpf = cpf;
        this.especialidade = especialidade;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCmfv() {
        return cmfv;
    }

    public void setCmfv(String cmfv) {
        this.cmfv = cmfv;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
