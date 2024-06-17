package controller;

import model.RestauranteModel;
import view.MenuView;
import view.FazerPedidoView;
import view.CadastrarClienteView;


import javax.swing.JFrame;
import view.ListarRequisicoesView;
public class MenuController {

    private RestauranteModel restauranteModel;
    private MenuView menuView;
    private FazerPedidoView fazerPedidoView;

    public MenuController(RestauranteModel restauranteModel, MenuView menuView) {
        this.restauranteModel = restauranteModel;
        this.menuView = menuView;
        this.menuView.setController(this);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            RestauranteModel restauranteModel = new RestauranteModel();
            MenuView menuView = new MenuView();
            FazerPedidoView pedidoView = new FazerPedidoView();
            ListarRequisicoesView requisicoesView = new ListarRequisicoesView();
            menuView.setVisible(true);
        });
    }

    public void abrirFazerPedidoView() {
        FazerPedidoView fazerPedidoView = new FazerPedidoView();
        fazerPedidoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        fazerPedidoView.setVisible(true);
    }

    public void abrirAbrirRequisicaoView() {
        CadastrarClienteView abrirRequisicaoView = new CadastrarClienteView();
        abrirRequisicaoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        abrirRequisicaoView.setVisible(true);
    }
    
        public void abrirAbrirListarRequisicaoView() {
        ListarRequisicoesView requisicoesView = new ListarRequisicoesView();
        requisicoesView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        requisicoesView.setVisible(true);
    }
}