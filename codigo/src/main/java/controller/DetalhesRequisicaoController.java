package controller;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.Mesa;
import model.Requisicao;
import view.DetalhesRequisicaoView;

public class DetalhesRequisicaoController {

    private DetalhesRequisicaoView view;
    private Requisicao requisicao;

    public DetalhesRequisicaoController(DetalhesRequisicaoView view, Requisicao requisicao) {
        this.view = view;
        this.requisicao = requisicao;
    }

    // Método para carregar e exibir os detalhes da requisição na tabela
    private void carregaTabela() {
        Object colunas[] = {"Número", "Cliente", "Ocupado", "Capacidade"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        
        // Pode usar diretamente mesas.getMesas() para obter a lista atualizada
        Requisicao req;
       

        view.getTbRequisicoes().setModel(tm);
    }

   public void atualizarTabela(){
       carregaTabela();
   }
}