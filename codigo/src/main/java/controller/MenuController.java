package controller;

import model.RestauranteModel;
import view.MenuView;
import view.FazerPedidoView;
import view.AbrirRequisicaoView;

public class MenuController {

    private RestauranteModel restauranteModel;
    private MenuView menuView;

    public MenuController(RestauranteModel restauranteModel, MenuView menuView) {
        this.restauranteModel = restauranteModel;
        this.menuView = menuView;
        this.menuView.setController(this);
    }
    
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            RestauranteModel restauranteModel = new RestauranteModel();
            MenuView menuView = new MenuView();
            new MenuController(restauranteModel, menuView);
            menuView.setVisible(true);
        });
    }

    public void abrirFazerPedidoView() {
        FazerPedidoView fazerPedidoView = new FazerPedidoView();
        fazerPedidoView.setVisible(true);
    }

    public void abrirAbrirRequisicaoView() {
        AbrirRequisicaoView abrirRequisicaoView = new AbrirRequisicaoView();
        abrirRequisicaoView.setVisible(true);
    }

}
