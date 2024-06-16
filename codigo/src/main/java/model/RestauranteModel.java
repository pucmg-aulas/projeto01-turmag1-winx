/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import restaurante.Mesa;
import restaurante.Produto;
import restaurante.Requisicao;

/**
 *
 * @author thiag
 */
public class RestauranteModel {

    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    private static ArrayList<Requisicao> listasEspera = new ArrayList<>();
    private static ArrayList<Requisicao> requisicoesDaListaDeEsperaAtendidas = new ArrayList<>();
    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    public RestauranteModel() {
    }

    public static ArrayList<Mesa> getMesas() {
        return mesas;
    }

    public static ArrayList<Requisicao> getListasRequisicoes() {
        return listasRequisicoes;
    }

    public static ArrayList<Requisicao> getListasEspera() {
        return listasEspera;
    }

    public static ArrayList<Requisicao> getRequisicoesDaListaDeEsperaAtendidas() {
        return requisicoesDaListaDeEsperaAtendidas;
    }

    public static ArrayList<Produto> getListaProdutos() {
        return listaProdutos;
    }
}
