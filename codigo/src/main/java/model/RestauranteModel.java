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

    private  ArrayList<MesaModel> mesas = new ArrayList<>();
    private  ArrayList<RequisicaoModel> listasRequisicoes = new ArrayList<>();
    private  ArrayList<RequisicaoModel> listasEspera = new ArrayList<>();
    private  ArrayList<RequisicaoModel> requisicoesDaListaDeEsperaAtendidas = new ArrayList<>();
    private  ArrayList<Produto> listaProdutos = new ArrayList<>();

    public RestauranteModel() {
        this.mesas = new ArrayList<>();
        this.listasRequisicoes = new ArrayList<>();
        this.listasEspera = new ArrayList<>();
        this.requisicoesDaListaDeEsperaAtendidas = new ArrayList<>();
        this.listaProdutos = new ArrayList<>();
    }

    public ArrayList<MesaModel> getMesas() {
        return this.mesas;
    }

    public ArrayList<RequisicaoModel> getListasRequisicoes() {
        return this.listasRequisicoes;
    }

    public ArrayList<RequisicaoModel> getListasEspera() {
        return this.listasEspera;
    }

    public ArrayList<RequisicaoModel> getRequisicoesDaListaDeEsperaAtendidas() {
        return this.requisicoesDaListaDeEsperaAtendidas;
    }

    public ArrayList<Produto> getListaProdutos() {
        return this.listaProdutos;
    }

    public void addListaEspera(RequisicaoModel requisicao) {
        this.listasEspera.add(requisicao);
    }

    public void removeAllEspera(ArrayList<RequisicaoModel> requisicoesDaListaDeEsperaAtendidas) {
        this.listasEspera.removeAll(requisicoesDaListaDeEsperaAtendidas);
    }
    
    public void addRequisicoesDaListaDeEsperaAtendidas(RequisicaoModel requisicao){
        this.requisicoesDaListaDeEsperaAtendidas.add(requisicao);
    }
    
    public void adicionarRequisicaoNoVetor(RequisicaoModel requisicao) {
        listasRequisicoes.add(requisicao);
    }
}
