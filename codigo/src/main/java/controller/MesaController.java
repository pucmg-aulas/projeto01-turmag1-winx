package controller;

import dao.MesaDAO;
import model.Mesa;
import java.util.Iterator;
import javax.swing.table.DefaultTableModel;
import view.MesaView;

public class MesaController {
    
    private MesaView view;
    private MesaDAO mesas;

    public MesaController() {
        this.mesas = MesaDAO.getInstance();
        this.view = new MesaView();
        
        carregaTabela();
        
        this.view.getVerMesas().addActionListener((e) -> {
            carregaTabela();
        });
        
        this.view.setVisible(true);
    }
    
    private void carregaTabela(){
        Object colunas[] = {"Número", "Cliente", "Ocupado", "Quantidade"};
        DefaultTableModel tm = new DefaultTableModel(colunas, 0);
       
        tm.setNumRows(0);
        Iterator<Mesa> it = mesas.getMesas().iterator();
        while (it.hasNext()) {
            Mesa m = it.next();
            tm.addRow(new Object[]{m.getNumero(), m.getCliente().getNome(), m.isOcupado(), m.getQuantidade()});
        }
        view.getMesas().setModel(tm);
    }
}