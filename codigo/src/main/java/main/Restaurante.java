/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.RequisicaoDAO;
import java.time.LocalDateTime;
import model.Requisicao;
import model.Cliente;

/**
 *
 * @author imcat
 */
public class Restaurante extends javax.swing.JFrame {
    
    public static void main(String args[]){
        RequisicaoDAO requisicoesDAO = RequisicaoDAO.getInstance();
        Cliente cliente = new Cliente("Isadora", "078.984.827-78");
        Requisicao requisicao = new Requisicao(LocalDateTime.now(), 4, cliente);
        requisicoesDAO.addRequisicao(requisicao);
    }
}
