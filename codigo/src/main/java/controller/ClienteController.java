/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author thiag
 */

import java.util.Scanner;
import model.ClienteModel;
import view.CadastrarClienteView;
import controller.RequisicaoController;

public class ClienteController {
    
    private CadastrarClienteView abrirRequisicaoView;
    private RequisicaoController requisicaoController;
    
        public ClienteModel cadastrarCliente(String nomeCliente, String cpfCliente, Integer qntPessoas) {

        ClienteModel cliente = new ClienteModel(nomeCliente, cpfCliente);
        
        requisicaoController.abrirRequisicao(cliente, qntPessoas);

        return cliente;
    }
}
