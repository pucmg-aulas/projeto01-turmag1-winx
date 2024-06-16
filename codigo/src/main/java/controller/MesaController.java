/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import model.MesaModel;

public class MesaController {
    
    public boolean verificaCapacidade(int quantPessoas, MesaModel mesa){
        return quantPessoas <= mesa.getQuantidade();
    }
}
