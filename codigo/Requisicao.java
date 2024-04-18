import java.time.LocalDateTime;

public class Requisicao {

    public LocalDateTime dataEntrada;
    public LocalDateTime dataSaida;
    public int quantPessoas;
    public Cliente cliente;
    public Mesa mesa;


    public Requisicao(LocalDateTime dataEntrada, int quantPesooas, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.quantPessoas = quantPesooas;
        this.cliente = cliente;
    }


    public void alocarMesa(Mesa mesa) {
       
        for(Mesa mesas: Restaurante.mesas){
            if(mesa.quantidade >= quantPessoas && mesa.ocupado == false){
                this.mesa = mesa;
                mesa.ocuparMesa();
                break;
            }
        }
        if (this.mesa == null){
            Restaurante.adicionarNaListaDeEspera(this);
        }
    }

    public void finalizarRequisicao(){
        
        this.dataSaida = LocalDateTime.now();
        mesa.desocuparMesa();

    }


    



    
}
