/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;

import model.RequisicaoModel;
import model.ClienteModel;
import model.MesaModel;



public class RequisicaoController {
    private final ArrayList<RequisicaoModel> listasRequisicoes;
    private final ArrayList<RequisicaoModel> listasEspera;
    private final ArrayList<RequisicaoModel> requisicoesDaListaDeEsperaAtendidas;
    private final ArrayList<MesaModel> mesas;
    
    private MesaController mesaController;
   

    public RequisicaoController(ArrayList<RequisicaoModel> listasRequisicoes, ArrayList<RequisicaoModel> listasEspera,
            ArrayList<RequisicaoModel> requisicoesDaListaDeEsperaAtendidas, ArrayList<MesaModel> mesas) {
        this.listasRequisicoes = listasRequisicoes;
        this.listasEspera = listasEspera;
        this.requisicoesDaListaDeEsperaAtendidas = requisicoesDaListaDeEsperaAtendidas;
        this.mesas = mesas;
    }

    public RequisicaoModel abrirRequisicao(ClienteModel cliente, int quantPessoas) {
        RequisicaoModel requisicao = new RequisicaoModel(LocalDateTime.now(), quantPessoas, cliente);
        decidirDestinoDaRequisicao(requisicao);
        return requisicao;
    }

    public void finalizarRequisicao(RequisicaoModel requisicao) {
        requisicao.setDataSaida(LocalDateTime.now());
        requisicao.getMesa().desocuparMesa();
        verificarListaDeEspera();
    }

    public void adicionarNaListaDeEspera(RequisicaoModel requisicao) {
        listasEspera.add(requisicao);
    }

    public void verificarListaDeEspera() {
        for (RequisicaoModel requisicao : listasEspera) {
            decidirDestinoDaRequisicao(requisicao);
        }
        listasEspera.removeAll(requisicoesDaListaDeEsperaAtendidas);
    }

    private MesaModel verificarMesasDisponiveis(int quantPessoas) {
        for (MesaModel mesa : mesas) {
            if (!mesa.isOcupado() && mesaController.verificaCapacidade(quantPessoas, mesa)) {
                return mesa;
            }
        }
        return null;
    }

    private void decidirDestinoDaRequisicao(RequisicaoModel requisicao) {
        MesaModel m = verificarMesasDisponiveis(requisicao.getQuantPessoas());
        if (m != null) {
            alocarMesa(m);
            adicionarRequisicaoNoVetor(requisicao);
            if (listasEspera.contains(requisicao)) {
                requisicoesDaListaDeEsperaAtendidas.add(requisicao);
            }
            //Sera printado de acordo com o que for adicionado com o JFrame, chamando o respectivo metodo da interface grafica
        }
        if (m == null && !listasEspera.contains(requisicao)) {
            adicionarNaListaDeEspera(requisicao);
        }
    }

    private void adicionarRequisicaoNoVetor(RequisicaoModel requisicao) {
        listasRequisicoes.add(requisicao);
    }
    
    public void alocarMesa(MesaModel mesa) {
    mesa.ocuparMesa();
    }
}