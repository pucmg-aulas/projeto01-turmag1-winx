package controller;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Mesa;
import model.Requisicao;
import view.DetalhesRequisicaoView;

public class DetalhesRequisicaoController {

    private DetalhesRequisicaoView view;

    public DetalhesRequisicaoController() {
        this.view = new DetalhesRequisicaoView();
    }

    public void exibirDetalhesRequisicao(List<Requisicao> requisicoes) {
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"Cliente", "Mesa", "Quantidade de Pessoas", "Total"});

        for (Requisicao requisicao : requisicoes) {
            String cliente = requisicao.getClienteNome();
            Mesa mesa = requisicao.getMesa();
            int qtdPessoas = requisicao.getQuantPessoas();
            model.addRow(new Object[]{cliente, mesa, qtdPessoas});
        }

//        view.getTabelaDetalhes().setModel(model);
        //view.mostrarDetalhes();
    }

    public void mostrarMensagem(String mensagem) {
        JOptionPane.showMessageDialog(view, mensagem);
    }

}
