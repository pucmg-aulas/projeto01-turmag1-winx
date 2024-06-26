package controller;

import dao.AbstractDAO;
import dao.MesaDAO;
import java.nio.file.Paths;
import model.Mesa;
import java.util.Iterator;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import view.CadastrarMesaView;
import view.MesaView;

public class MesaController {

    private final MesaView view;

    private final MesaDAO mesas;

    public MesaController() {
        this.mesas = MesaDAO.getInstance();
        this.view = new MesaView();

        carregaTabela();


        this.view.setVisible(true);
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void carregaTabela() {
        Object colunas[] = {"Número", "Cliente", "Ocupado", "Capacidade"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        
        // Pode usar diretamente mesas.getMesas() para obter a lista atualizada
        List<Mesa> listaMesas = mesas.getMesas();

        for (Mesa m : listaMesas) {
            String clienteNome = m.getCliente() != null ? m.getCliente().getNome() : "N/A";
            String ocupado = m.isOcupado() ? "Ocupado" : "Livre";
            tm.addRow(new Object[]{m.getNumero(), clienteNome, ocupado, m.getCapacidade()});
        }

        view.getMesas().setModel(tm);
    }

   public void alocarMesa(Cliente cliente, int quantPessoas) {
    Mesa mesaSelecionada = null;

    for (Mesa m : mesas.getMesas()) {
        if (!m.isOcupado() && m.getCapacidade() >= quantPessoas) {
            if (mesaSelecionada == null || m.getCapacidade() < mesaSelecionada.getCapacidade()) {
                mesaSelecionada = m;
            }
        }
    }
    
    if (mesaSelecionada != null) {
        mesaSelecionada.setOcupado(true);
        mesaSelecionada.setCliente(cliente);
        mesas.adicionarMesa(mesaSelecionada); // Atualiza a mesa no DAO
    } 
}

    
    public void atualizarTabelaMesas() {
    carregaTabela(); // Carrega novamente os dados das mesas na tabela
    }
}
