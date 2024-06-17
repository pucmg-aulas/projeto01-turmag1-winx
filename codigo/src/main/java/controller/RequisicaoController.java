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

    
    
    private RestauranteModel restauranteModel = new RestauranteModel();
    private MesaController mesaController = new MesaController(restauranteModel);

    public RequisicaoModel abrirRequisicao(ClienteModel cliente, int quantPessoas) {
        RequisicaoModel requisicao = new RequisicaoModel(LocalDateTime.now(), quantPessoas, cliente);
        
        //decidirDestinoDaRequisicao(requisicao);
        MesaModel mesa = mesaController.verificarMesasDisponiveis(quantPessoas);
        System.out.println(mesa);
        if(mesaController.verificaCapacidade(quantPessoas, mesa)){
            requisicao.setMesa(mesa);
        }
        restauranteModel.adicionarRequisicaoNoVetor(requisicao);
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

    private void decidirDestinoDaRequisicao(RequisicaoModel requisicao) {
        MesaModel m = mesaController.verificarMesasDisponiveis(requisicao.getQuantPessoas());
        if (m != null) {
            mesaController.alocarMesa(m, requisicao);
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