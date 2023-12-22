package com.ecommerce.ui;

import com.ecommerce.model.Produto;

import java.util.ArrayList;
import java.util.List;

public class CatalogoProdutos {
    private static final List<Produto> produtos = new ArrayList<>();

    public static void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public static List<Produto> obterProdutos() {
        return new ArrayList<>(produtos);
    }
}
