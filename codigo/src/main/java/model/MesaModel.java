/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author thiag
 */public class MesaModel {
    private int quantidade;
    private boolean ocupado;

    public MesaModel(int quantidade, boolean ocupado){
        this.quantidade = quantidade;
        this.ocupado = ocupado;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public boolean getOcupado(){
        return ocupado;
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
    
    public void setOcupado() {
        this.ocupado = true;
    }
    
    public boolean isOcupado(){
        return this.ocupado;
    }
}
