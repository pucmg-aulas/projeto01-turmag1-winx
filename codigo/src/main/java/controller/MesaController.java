package controller;

import model.MesaModel;
import model.RequisicaoModel;
import model.RestauranteModel;

public class MesaController {
    
    private RestauranteModel restauranteModel;
    
    public MesaController(RestauranteModel restauranteModel) {
        this.restauranteModel = restauranteModel;
    }
    
    public boolean verificaCapacidade(int quantPessoas, MesaModel mesa){
        return quantPessoas <= mesa.getQuantidade();
    }
    
    public void alocarMesa(MesaModel mesa, RequisicaoModel requisicao) {
        requisicao.setMesa(mesa);
        mesa.ocuparMesa();
    }
    
    public void iniciarMesas(){
        MesaModel mesa1 = new MesaModel(4, false);
        MesaModel mesa2 = new MesaModel(6, false);
        MesaModel mesa3 = new MesaModel(8, false);
        
        restauranteModel.getMesas().add(mesa1);
        restauranteModel.getMesas().add(mesa2);
        restauranteModel.getMesas().add(mesa3);
        System.out.println(restauranteModel.getMesas());
    }
    
    public MesaModel verificarMesasDisponiveis(int quantPessoas) {
        for (MesaModel mesa : restauranteModel.getMesas()) {
            System.out.println(mesa);
            if (!mesa.isOcupado() && verificaCapacidade(quantPessoas, mesa)) {
                return mesa;
            }
        }
        return null;
    }
}
