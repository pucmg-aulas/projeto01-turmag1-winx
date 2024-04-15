import java.time.LocalDateTime;

public class Requisicao {

    LocalDateTime dataEntrada;
    LocalDateTime dataSaida;
    int quantPesooas;
    Cliente cliente;
    Mesa mesa;


    public Requisicao(LocalDateTime dataEntrada, LocalDateTime dataSaida, int quantPesooas, Cliente cliente, Mesa mesa) {
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.quantPesooas = quantPesooas;
        this.cliente = cliente;
        this.mesa = mesa;
    }


    public void alocarMesa() {

        if(Mesa.verificarDisponibilidade()){

        }
    }

    public void finalizarAtendimento(){
        
    }
    



    
}
