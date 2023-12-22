package com.ecommerce.model;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private Cliente cliente;
    private List<ItemVenda> itensVenda;

    public Pedido(Cliente cliente) {
        this.setCliente(cliente);
        this.itensVenda = new ArrayList<>();
    }

    public void adicionarItemVenda(Produto produto, int quantidade) {
        ItemVenda item = new ItemVenda(produto, quantidade);
        itensVenda.add(item);
    }

    public void exibirItensVenda() {
        System.out.println("Itens do Carrinho:");
        for (ItemVenda item : itensVenda) {
            System.out.println(item.getQuantidade() + "x " + item.getProduto().getNome() + " - R$" + item.getProduto().getPreco() * item.getQuantidade());
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itensVenda) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
}

