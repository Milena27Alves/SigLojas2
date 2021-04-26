package com.exemplo.strategy;

import com.exemplo.exception.*;

public class ContaCorrente {
    private String numero;
    private double saldo;
    private Cliente cliente;

    public ContaCorrente(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void debitar(double quantia) throws SaldoInsuficienteException {
        if (getSaldo() >= quantia) {
            this.saldo -= quantia;
            this.getExtrato();
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente!");
        }
    }

    public void creditar(double quantia) {
        this.saldo += quantia;
    }

    public void transferir(ContaCorrente destino, double quantia) throws SaldoInsuficienteException{
        if (getSaldo() >= quantia) {
            this.debitar(quantia);
            destino.creditar(quantia);
        } else {
            throw new SaldoInsuficienteException("Saldo insuficiente para a transferência!");
        }
    }

    public void getExtrato(){
        System.out.println("======= EXTRATO DA CONTA =======\n" +
                "Cliente: " + this.cliente.getNome() +
                "\nSaldo atual: "+getSaldo());
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    public Cliente getCliente() {
    	return this.cliente;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}