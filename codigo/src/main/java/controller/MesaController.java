package controller;

import dao.MesaDAO;
import model.Mesa;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import model.Cliente;
import view.MesaView;

public class MesaController {

    private final MesaView view;
    private final MesaDAO mesas;

    public MesaController() {
        this.mesas = MesaDAO.getInstance();
        this.view = new MesaView();

        carregaTabela();

        this.view.getVerMesas().addActionListener((e) -> {
            carregaTabela();
        });

        this.view.setVisible(true);
        this.view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void carregaTabela() {
        Object colunas[] = {"Número", "Cliente", "Ocupado", "Capacidade"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);

        tm.setNumRows(0);
        Iterator<Mesa> it = mesas.getMesas().iterator();
        while (it.hasNext()) {
            Mesa m = it.next();
            String clienteNome = m.getCliente() != null ? m.getCliente().getNome() : "N/A";
            String ocupado = m.isOcupado() ? "Ocupado" : "Livre";
            tm.addRow(new Object[]{m.getNumero(), clienteNome, ocupado, m.getCapacidade()});
        }
        view.getMesas().setModel(tm);
    }

    public void alocarMesa(Cliente cliente, int quantPessoas) {
        Mesa mesaMenorCapacidade = null;

        for (Mesa m : mesas.getMesas()) {
            if (!m.isOcupado() && m.getCapacidade() >= quantPessoas) {
                if (mesaMenorCapacidade == null || m.getCapacidade() < mesaMenorCapacidade.getCapacidade()) {
                    mesaMenorCapacidade = m;
                }
            }
        }

        // Agora mesaMenorCapacidade contém a mesa com a menor capacidade disponível que caiba quantPessoas
        if (mesaMenorCapacidade != null) {
            mesaMenorCapacidade.setOcupado(true);
            mesaMenorCapacidade.setCliente(cliente);
        } 
    }
}
