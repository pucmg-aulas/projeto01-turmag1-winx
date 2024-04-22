import java.time.LocalDateTime;

public class Requisicao {

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private int quantPessoas;
    private Cliente cliente;
    private Mesa mesa;


    public Requisicao(LocalDateTime dataEntrada, int quantPessoas, Cliente cliente) {
        this.dataEntrada = dataEntrada;
        this.quantPessoas = quantPessoas;
        this.cliente = cliente;
    }


    public void alocarMesa(Mesa mesa) {
        this.mesa = mesa;
        mesa.ocuparMesa();
    }

    public void finalizarRequisicao(){
        this.dataSaida = LocalDateTime.now();
        mesa.desocuparMesa();
    }

    


    



    
}
