package com.ecommerce.ui;

import com.ecommerce.model.Cliente;
import com.ecommerce.model.Pedido;
import com.ecommerce.model.Produto;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private static final Scanner scanner = new Scanner(System.in);
    
    private static final Pedido pedido = new Pedido(new Cliente("Cliente Teste", "Endereço Teste"));

    public static void exibirMenu() {
    	
    	System.out.print("Como gostaria de ser chamade? \n");
    	String nomeCliente = scanner.nextLine();
        
        
        System.out.println("\nBem-vinde " + nomeCliente + " ao nosso e-commerce!\n");

    	
        int escolha = 0;

        do {
            try {
            	System.out.println("╔══════════════════════════════════╗");
            	System.out.println("║        Menu Principal            ║");
            	System.out.println("╠══════════════════════════════════╣");
            	System.out.println("║ 1. Listar Produtos               ║");
            	System.out.println("║ 2. Adicionar Produto ao Carrinho ║");
            	System.out.println("║ 3. Visualizar Carrinho           ║");
            	System.out.println("║ 4. Finalizar Compra              ║");
            	System.out.println("║ 0. Sair                          ║");
            	System.out.println("╚══════════════════════════════════╝");

                System.out.print("Escolha uma opção: ");
                escolha = scanner.nextInt();

                switch (escolha) {
                    case 1:
                        listarProdutos();
                        break;
                    case 2:
                        adicionarProdutoAoCarrinho();
                        break;
                    case 3:
                        visualizarCarrinho();
                        break;
                    case 4:
                        finalizarCompra();
                        break;
                    case 0:
                        System.out.println("Saindo do sistema. Volte sempre!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); 
            }

        } while (escolha != 0);
    }

    private static void listarProdutos() {
        List<Produto> produtos = CatalogoProdutos.obterProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível no catálogo.");
        } else {
            System.out.println("Lista de Produtos:");
            for (int i = 0; i < produtos.size(); i++) {
                Produto produto = produtos.get(i);
                System.out.println((i + 1) + ". " + produto.getNome() + " - R$" + produto.getPreco());
            }
        }
    }

    private static void adicionarProdutoAoCarrinho() {
        List<Produto> produtos = CatalogoProdutos.obterProdutos();
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto disponível para adicionar ao carrinho.");
        } else {
            try {
                System.out.print("Escolha o número do produto a adicionar: ");
                int escolhaProduto = scanner.nextInt();
                if (escolhaProduto >= 1 && escolhaProduto <= produtos.size()) {
                    Produto produtoSelecionado = produtos.get(escolhaProduto - 1);
                    System.out.print("Digite a quantidade desejada: ");
                    int quantidade = scanner.nextInt();
                    pedido.adicionarItemVenda(produtoSelecionado, quantidade);
                    System.out.println("Produto adicionado ao carrinho com sucesso!");
                } else {
                    System.out.println("Escolha inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Por favor, insira um número válido.");
                scanner.next(); 
            }
        }
    }

    private static void visualizarCarrinho() {
        pedido.exibirItensVenda();
        System.out.println("Total do Carrinho: R$" + pedido.calcularTotal());
    }

    private static void finalizarCompra() {
        System.out.println("Compra finalizada. Obrigado por utilizar nosso e-commerce!");
    }
}
