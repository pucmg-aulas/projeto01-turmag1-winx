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
import model.RestauranteModel;



public class RequisicaoController {

    
    private MesaController mesaController;
    private RestauranteModel restauranteModel = new RestauranteModel();

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
        restauranteModel.addListaEspera(requisicao);
    }

    public void verificarListaDeEspera() {
        for (RequisicaoModel requisicao : restauranteModel.getListasEspera()) {
            decidirDestinoDaRequisicao(requisicao);
        }
        restauranteModel.removeAllEspera(restauranteModel.getRequisicoesDaListaDeEsperaAtendidas());
    }

    private MesaModel verificarMesasDisponiveis(int quantPessoas) {
        for (MesaModel mesa : restauranteModel.getMesas()) {
            if (!mesa.isOcupado() && mesaController.verificaCapacidade(quantPessoas, mesa)) {
                return mesa;
            }
        }
        return null;
    }

    private void decidirDestinoDaRequisicao(RequisicaoModel requisicao) {
        MesaModel m = verificarMesasDisponiveis(requisicao.getQuantPessoas());
        if (m != null) {
            mesaController.alocarMesa(m);
            restauranteModel.adicionarRequisicaoNoVetor(requisicao);
            if (restauranteModel.getListasEspera().contains(requisicao)) {
                restauranteModel.addRequisicoesDaListaDeEsperaAtendidas(requisicao);
            }
            //Sera printado de acordo com o que for adicionado com o JFrame, chamando o respectivo metodo da interface grafica
        }
        if (m == null && !restauranteModel.getListasEspera().contains(requisicao)) {
            adicionarNaListaDeEspera(requisicao);
        }
    }
}