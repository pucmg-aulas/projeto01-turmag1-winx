import java.time.LocalDateTime;

public class Requisicao {

    public LocalDateTime dataEntrada;
    public LocalDateTime dataSaida;
    public int quantPessoas;
    public Cliente cliente;
    public Mesa mesa;


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

    public String formataDataHora(LocalDateTime dataSaida){

        
        return "";
    }


    



    
}
