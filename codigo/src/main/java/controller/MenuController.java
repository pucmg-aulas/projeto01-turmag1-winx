package controller;

import model.RestauranteModel;
import view.MenuView;
import view.FazerPedidoView;
import view.CadastrarClienteView;


import javax.swing.JFrame;
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
            menuView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            pedidoView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            new MenuController(restauranteModel, menuView);
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
}