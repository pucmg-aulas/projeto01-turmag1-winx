/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author thiag
 */

import model.ClienteModel;
import controller.RequisicaoController;

public class ClienteController {

    private RequisicaoController requisicaoController;

    public ClienteController(RequisicaoController requisicaoController) {
        this.requisicaoController = requisicaoController;
    }

    public ClienteModel cadastrarCliente(String nomeCliente, String cpfCliente, Integer qntPessoas) {
        ClienteModel cliente = new ClienteModel(nomeCliente, cpfCliente);
        this.requisicaoController.abrirRequisicao(cliente, qntPessoas);
        return cliente;
    }
}

