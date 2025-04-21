/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.RequisicoesDAO;
import java.time.LocalDateTime;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.AbrirRequisicaoView;
import model.Requisicao;
import model.Cliente;

/**
 *
 * @author imcat
 */
public class AbrirRequisicaoController {
    private final RequisicoesDAO requisicoes;
    private final AbrirRequisicaoView view;
    private  MesaController mesaController = new MesaController();
    
    public AbrirRequisicaoController(){
        this.view = new AbrirRequisicaoView();
        this.mesaController = new MesaController();
        this.requisicoes = RequisicoesDAO.getInstance();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            abrirRequisicao();
            sair();



            /*
             *  problema: Lógica de negócio (abrirRequisicao()) acoplada ao listener da view.

                sugestão:
                    - Extraia a ação para um método privado (ex.: onConfirmarClick()).
                    - Trate exceções aqui, não dentro de abrirRequisicao().

                Exemplo:

                    this.view.getConfirmaBtn().addActionListener((e) -> {
                        try {
                            onConfirmarClick();
                        } catch (IllegalArgumentException ex) {
                            showError(ex.getMessage()); // Método auxiliar para exibir erros
                        }
                    });
                            */
        });
        
//        this.view.getCancelaBtn().addActionListener((e) -> {
//            cancelar();
//        });
        
        this.view.setVisible(true);
        
        //adicionar os listeners aqui
        // 
    }
    
    //public void abreView(){this.view.setVisible(true);}
    private void sair() {
        this.view.dispose();
    }
     
    public void abrirRequisicao(){
        //pegar os dados dos campos da view
        String nomeCliente = view.getNomeClienteField().getText();
        String cpfCliente = view.getCpfField().getText();
        int quantPessoas = Integer.parseInt(view.getQuantPessoasField().getText());

        /*
         *  problema: conversão sem tratamento de erros. Se o texto não for um número, quebrará a aplicação.

            Solução:
                - Use try-catch ou valide com regex antes:

            try {
                int quantPessoas = Integer.parseInt(quantPessoasStr);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Número de pessoas inválido!");
            }

         */
        
        Cliente cliente = new Cliente(nomeCliente, cpfCliente);
        mesaController.alocarMesa(cliente, quantPessoas);
        Requisicao r = new Requisicao(LocalDateTime.now(), quantPessoas, cliente);
        
        requisicoes.addRequisicao(r);
        
        JOptionPane.showMessageDialog(view, "Requisicao salva com sucesso!");
        
        limparTela();
        
        // devemos fazer tratamento de exceção
        // controller comunica a model com o dao
    } 
    
    private void limparTela(){
        
        this.view.getNomeClienteField().setText("");
        this.view.getCpfField().setText("");
        this.view.getQuantPessoasField().setText("");
    }
    
    private void cancelar() {
        this.view.dispose();
    }
    
}

/*
 * sugestão de melhoria: Esta classe está assumindo muitas responsabilidades (coordenação de view, alocação de mesas e persistência). Considere dividir em:

    - RequisicaoService: Para lógica de negócio (validações, alocação).

    - ClienteService: Para validação de CPF/nome.
 */
