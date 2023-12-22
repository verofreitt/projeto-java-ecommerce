package com.ecommerce.ui;

import com.ecommerce.model.Produto;

public class EcommerceApp {
    public static void main(String[] args) {
        inicializarCatalogoProdutos();

        Menu.exibirMenu();
    }
    private static void inicializarCatalogoProdutos() {
        CatalogoProdutos.adicionarProduto(new Produto("Camiseta", 29.99));
        CatalogoProdutos.adicionarProduto(new Produto("Calça Jeans", 59.99));
        CatalogoProdutos.adicionarProduto(new Produto("Tênis Esportivo", 79.99));
        CatalogoProdutos.adicionarProduto(new Produto("Mochila", 39.99));
        CatalogoProdutos.adicionarProduto(new Produto("Bone", 19.99)); 
        CatalogoProdutos.adicionarProduto(new Produto("Luvas", 14.99)); 
    }
}
