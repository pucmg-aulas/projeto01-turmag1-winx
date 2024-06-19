/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import dao.Requisicoes;
import java.time.LocalDateTime;
import model.Requisicao;
import restaurante.Cliente;

/**
 *
 * @author imcat
 */
public class Restaurante {
    Requisicoes requisicoes = Requisicoes.getInstance();
    Cliente cliente = new Cliente("Isadora", "078.984.827-78");
    Requisicao requisicao = new Requisicao(LocalDateTime.now(), 4, cliente);
    requisicoes.addRequisicao(requisicao);
    
}
