/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.Serializable;

/**
 *
 * @author imcat
 */
public class Cliente implements Serializable {

    private String nome;
    private String cpf;

    public Cliente(String nomeCliente, String cpf){
        this.nome = nomeCliente;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}

/*
 * problema: O CPF não é validado (formato ou dígitos verificadores).
    Sugestão:

    public void setCpf(String cpf) {  
        if (cpf == null || !cpf.matches("\\d{11}")) {  
            throw new IllegalArgumentException("CPF deve conter 11 dígitos numéricos");  
        }  
        this.cpf = cpf;  
    }  

    - Evita CPFs mal formatados (ex.: "123.456.789-00" ou "ABC123").

    - Garante integridade mínima dos dados.
 */