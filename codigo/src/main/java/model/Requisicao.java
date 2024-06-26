/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import restaurante.Mesa;
import restaurante.Pedido;

/**
 *
 * @author imcat
 */
public class Requisicao implements Serializable{
    
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int quantPessoas;
    private Cliente cliente;
    private Mesa mesa;
    private static ArrayList<Pedido> listaPedidos = new ArrayList<>();
    private final double TAXA = 0.10;



    public Requisicao(LocalDateTime dataEntrada, int quantPessoas, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.quantPessoas = quantPessoas;
        this.cliente = cliente;
    }

    public void adicionarPedidoNoVetor(Pedido p) {
        listaPedidos.add(p);
        System.out.println("Pedido adicionado a comanda com sucesso!");
    }

    public void alocarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.ocuparMesa();
    }

    public double calculaTotalComTaxa() {
        double total = 0;
        for (Pedido pedido : listaPedidos) {
            total += pedido.getTotal();
        }
        return total * (1 + TAXA);
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

    public Mesa getMesa(){
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
    
    @Override
    public String toString() {
        return getClienteNome() + " - " + mesa;
    }
    
}
