/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
/**
 *
 * @author imcat
 */
public class Mesa implements Serializable {
    private int capacidade;
    private boolean ocupado;
    private int numero;
    private Cliente cliente;

    public Mesa(int quantidade, boolean ocupado, int numero, Cliente cliente){
        this.capacidade = quantidade;
        this.ocupado = ocupado;
        this.numero = numero;
    }

    public int getCapacidade(){
        return capacidade;
    }
    
    public void setOcupado(boolean status){
        this.ocupado = status;
    }

    public void ocuparMesa(){
        this.ocupado = true;
    }

    public void desocuparMesa(){
        this.ocupado = false;
    }

    public static boolean verificarDisponibilidade() {
        return true;
    }

    public boolean verificaCapacidade(int quantPessoas){
        return quantPessoas <= capacidade;
    }

    public void setOcupado() {
        this.ocupado = true;
    }
    
    public int getNumero(){
        return numero;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
   
}