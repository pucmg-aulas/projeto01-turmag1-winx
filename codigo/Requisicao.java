import java.time.LocalDateTime;

public class Requisicao {

    LocalDateTime dataEntrada;
    LocalDateTime dataSaida;
    int quantPessoas;
    Cliente cliente;
    Mesa mesa;


    public Requisicao(LocalDateTime dataEntrada, int quantPesooas, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.quantPessoas = quantPesooas;
        this.cliente = cliente;
    }


    public void alocarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.ocuparMesa();

    }

    public void finalizarAtendimento(){
        
    }
    



    
}
