package com.exemplo.strategy;

public class Cartao {
    private TipoCartao tipo;
    private String numero;
    private Fatura fatura;
    private Cliente proprietario;

    public Cartao(String num, TipoCartao t){
        this.numero = num;
        this.tipo = t;
        this.fatura = new Fatura();
    }

    public void acrescentarNaFatura(Compra compra){
       this.fatura.addCompra(compra);
       consultarFatura();
    }

    public void consultarFatura(){
       this.fatura.exibirFatura();
    }

    public void setProprietario(Cliente proprietario) {
        this.proprietario = proprietario;
    }

    public Cliente getProprietario() {
        return this.proprietario;
    }

    public Fatura getFatura() {
        return fatura;
    }
}
