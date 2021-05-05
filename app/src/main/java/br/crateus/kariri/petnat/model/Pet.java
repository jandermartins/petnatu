package br.crateus.kariri.petnat.model;

import android.text.Editable;

import java.util.Date;

public class Pet {
    private String idPet;

    public String getIdPet() {
        return idPet;
    }

    public Pet(){

    }

    public void setIdPet(String idPet) {
        this.idPet = idPet;
    }

    private String idVeterinario;
    private String cpfTutor;
    private String nome;
    private String especie;
    private String raca;
    private String peso;
    private String sexo;
    private String nascimento;
    private boolean castrado;
    private String exame;

    public String getExame() {
        return exame;
    }

    public void setExame(String exame) {
        this.exame = exame;
    }

    public Pet(String uid, String s, String toString, String string, String s1, String toString1, String string1, String link) {

    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Pet(String idPet, String idVeterinario, String cpfTutor, String nome, String especie, String raca, String peso, String sexo, String nascimento, String exame) {
        this.idPet = idPet;
        this.idVeterinario = idVeterinario;
        this.cpfTutor = cpfTutor;
        this.nome = nome;
        this.especie = especie;
        this.raca = raca;
        this.peso = peso;
        this.sexo = sexo;
        this.nascimento = nascimento;
        this.castrado = castrado;
        this.exame = exame;
    }

    public String getCpfTutor() {
        return cpfTutor;
    }

    public void setCpfTutor(String cpfTutor) {
        this.cpfTutor = cpfTutor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    public boolean isCastrado() {
        return castrado;
    }

    public void setCastrado(boolean castrado) {
        this.castrado = castrado;
    }
}