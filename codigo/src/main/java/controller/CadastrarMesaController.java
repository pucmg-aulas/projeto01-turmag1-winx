package controller;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.CadastrarMesaView;
import restaurante.Mesa;

public class CadastrarMesaController {
    private CadastrarMesaView view;

    public CadastrarMesaController() {
        this.view = new CadastrarMesaView();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.view.getConfirmaBtn().addActionListener((e) -> {
            cadastrarMesa();
        });

        this.view.getCancelaBtn().addActionListener((e) -> {
            cancelar();
        });

        this.view.setVisible(true);
    }

    private void cadastrarMesa() {
        try {
            int tamanho = Integer.parseInt(view.getTamanhoMesaField().getText());
            Mesa mesa = new Mesa(tamanho, false); // Cria uma nova mesa com o tamanho informado
            restaurante.Restaurante.adicionarMesaNoVetor(mesa); // Adiciona a mesa ao restaurante (método estático no Restaurante)
            JOptionPane.showMessageDialog(view, "Mesa cadastrada com sucesso!");
            limparTela();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(view, "Por favor, insira um valor numérico válido para o tamanho da mesa.");
        }
    }

    private void limparTela() {
        this.view.getTamanhoMesaField().setText("");
    }

    private void cancelar() {
        this.view.dispose();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastrarMesaController();
            }
        });
    }
}
