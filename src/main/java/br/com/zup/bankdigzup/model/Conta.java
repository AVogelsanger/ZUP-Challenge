package br.com.zup.bankdigzup.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Conta extends AbstractEntity{

    private Integer agencia;

    private Integer conta;

    private Integer digito;

    private Double saldo;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "proposta_id")
    private Proposta proposta;

    public Conta() {
    }

    public Conta(Integer agencia, Integer conta, Integer digito, Double saldo, Proposta proposta) {
        this.agencia = agencia;
        this.conta = conta;
        this.digito = digito;
        this.saldo = saldo;
        this.proposta = proposta;
    }

    public Integer getAgencia() {
        return agencia;
    }

    public void setAgencia(Integer agencia) {
        this.agencia = agencia;
    }

    public Integer getConta() {
        return conta;
    }

    public void setConta(Integer conta) {
        this.conta = conta;
    }

    public Integer getDigito() {
        return digito;
    }

    public void setDigito(Integer digito) {
        this.digito = digito;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Proposta getProposta() {
        return proposta;
    }

    public void setProposta(Proposta proposta) {
        this.proposta = proposta;
    }
}
