package controller;

import dao.MesaDAO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import view.CadastrarMesaView;
import model.Mesa;

public class CadastrarMesaController {
    private CadastrarMesaView view;
    private MesaDAO mesaDao;

    public CadastrarMesaController() {
        this.view = new CadastrarMesaView();
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        this.mesaDao = mesaDao.getInstance();
        
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
            
            Mesa m = new Mesa(tamanho, false, mesaDao.getMesas().size() + 1, null); // Cria uma nova mesa com o tamanho informado
            
            mesaDao.adicionarMesa(m);
            
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
}
