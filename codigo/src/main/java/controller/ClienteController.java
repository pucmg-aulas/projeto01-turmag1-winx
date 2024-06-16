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

public class ClienteController {
    
    private CadastrarClienteView abrirRequisicaoView;
    
        public ClienteModel cadastrarCliente(String nomeCliente, String cpfCliente) {

        ClienteModel cliente = new ClienteModel(nomeCliente, cpfCliente);
        
        System.out.println(cliente.getNome());

        return cliente;
    }
}
