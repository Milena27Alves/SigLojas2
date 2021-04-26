package com.exemplo.strategy;

import com.exemplo.exception.ItemExistenteException;
import com.exemplo.exception.ListaVaziaException;

import java.util.LinkedList;
import java.util.List;

public class Pedido {

    private Cliente cliente;
    private List<Item> itens;
    private double precoTotal;
    private String descricao;

    public Pedido(Cliente cliente, String descricao) {
        this.cliente = cliente;
        this.descricao = descricao;
        this.itens = new LinkedList<>();
    }

    public void realizarPedido(PagamentoStrategy formaPgto){
        formaPgto.pagar(this);
    }

    public void addItem(Item item) throws ItemExistenteException {
        if(!this.itens.contains(item)){
            this.itens.add(item);
            this.setPrecoTotal(item.getPreco());
        } else {
            throw new ItemExistenteException("O item já foi adicionado na lista!");
        }
    }

    public void removerItem(Item item) throws ListaVaziaException{
        if(!itens.isEmpty()){
            itens.remove(item);
        } else {
            throw new ListaVaziaException("Lista vazia!");
        }
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItens() {
        return itens;
    }

    public double getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(double preco) {
        this.precoTotal+=preco;
    }

    public String getDescricao() {
        return this.descricao;
    }
}
