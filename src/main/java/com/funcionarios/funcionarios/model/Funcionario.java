package com.funcionarios.funcionarios.model;

import jakarta.persistence.*;

@Entity
@Table(name="funcionarios")
public class Funcionario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "primeiro_nome")
    private String primeiroNome;

    @Column(name = "ultimo_nome")
    private String ultimoNome;

    @Column(name = "email_id")
    private String emailId;


    public Funcionario() {

    }

    public Funcionario(String primeiroNome, String ultimoNome, String emailId) {
        this.primeiroNome = primeiroNome;
        this.ultimoNome = ultimoNome;
        this.emailId = emailId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPrimeiro_nome() {
        return primeiroNome;
    }

    public void setPrimeiro_nome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimo_nome() {
        return ultimoNome;
    }

    public void setUltimo_nome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }
}
