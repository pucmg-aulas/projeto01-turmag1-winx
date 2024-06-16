/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;

import java.util.ArrayList;
import model.ClienteModel;
import restaurante.Mesa;
import restaurante.Produto;
import restaurante.Requisicao;
        
public class RestauranteController {
    private ArrayList<Mesa> mesas;
    private ArrayList<Requisicao> listasRequisicoes;
    private ArrayList<Requisicao> listasEspera;
    private ArrayList<Requisicao> requisicoesDaListaDeEsperaAtendidas;
    private ArrayList<Produto> listaProdutos;

    public RestauranteController() {
        // Inicializa as listas e mesas
        // Adiciona produtos à listaProdutos
    }

    public void abrirRequisicao(ClienteModel cliente, int quantPessoas) {
        // Lógica para abrir uma requisição
    }

    public void finalizarRequisicao(Requisicao requisicao) {
        // Lógica para finalizar uma requisição
    }

    public void listarMesas() {
        // Retorna a lista de mesas
    }

    public void listarRequisicoesAbertas() {
        // Retorna a lista de requisições abertas
    }

    public void listarRequisicoesNaListaDeEspera() {
        // Retorna a lista de requisições na lista de espera
    }

    public void adicionarMesa(int quantidade) {
        // Adiciona uma nova mesa
    }

    public Produto selecionarProduto(int opcao) {
        // Retorna o produto selecionado pelo usuário
    }

    public void fazerPedido(Requisicao requisicao, Produto produto, int quantidade) {
        // Lógica para fazer um pedido
    }

    public void resumoRequisicao(Requisicao requisicao) {
        // Retorna um resumo da requisição
    }

    // Outros métodos de controle conforme necessário
}
