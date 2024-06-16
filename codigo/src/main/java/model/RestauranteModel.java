/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import restaurante.Mesa;
import restaurante.Produto;
import restaurante.Requisicao;

/**
 *
 * @author thiag
 */
public class RestauranteModel {

    private static ArrayList<MesaModel> mesas = new ArrayList<>();
    private static ArrayList<RequisicaoModel> listasRequisicoes = new ArrayList<>();
    private static ArrayList<RequisicaoModel> listasEspera = new ArrayList<>();
    private static ArrayList<RequisicaoModel> requisicoesDaListaDeEsperaAtendidas = new ArrayList<>();
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public RestauranteModel() {
    }

    public static ArrayList<MesaModel> getMesas() {
        return mesas;
    }

    public static ArrayList<RequisicaoModel> getListasRequisicoes() {
        return listasRequisicoes;
    }

    public static ArrayList<RequisicaoModel> getListasEspera() {
        return listasEspera;
    }

    public static ArrayList<RequisicaoModel> getRequisicoesDaListaDeEsperaAtendidas() {
        return requisicoesDaListaDeEsperaAtendidas;
    }

    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }

    public void addListaEspera(RequisicaoModel requisicao) {
        this.listasEspera.add(requisicao);
    }

    public void removeAllEspera(ArrayList<RequisicaoModel> requisicoesDaListaDeEsperaAtendidas) {
        listasEspera.removeAll(requisicoesDaListaDeEsperaAtendidas);
    }
    
    public void addRequisicoesDaListaDeEsperaAtendidas(RequisicaoModel requisicao){
        this.requisicoesDaListaDeEsperaAtendidas.add(requisicao);
    }
    
    public void adicionarRequisicaoNoVetor(RequisicaoModel requisicao) {
        listasRequisicoes.add(requisicao);
    }
}
