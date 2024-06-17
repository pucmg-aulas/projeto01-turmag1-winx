/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import restaurante.Mesa;
import restaurante.Pedido;

/**
 *
 * @author thiag
 */
public class RequisicaoModel {
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int quantPessoas;
    private ClienteModel cliente;
    private MesaModel mesa;
    private ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private final double TAXA = 0.10;
    
    public RequisicaoModel(LocalDateTime dataEntrada, int quantPessoas, ClienteModel cliente) {
        this.dataEntrada = dataEntrada;
        this.quantPessoas = quantPessoas;
        this.cliente = cliente;
    }
    
    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public String getClienteNome(){
        return cliente.getNome();
    }

    public void setDataSaida(LocalDateTime dataSaida){
        this.dataSaida = dataSaida;
    }

    public MesaModel getMesa(){
        return mesa;
    }

    public double getTAXA() {
        return TAXA;
      }

    public int getQuantPessoas() {
        return quantPessoas; 
    }

    public ArrayList<Pedido> getListaPedidos() { 
        return listaPedidos;
    }
}
