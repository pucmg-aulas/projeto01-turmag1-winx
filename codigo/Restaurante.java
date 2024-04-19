import java.time.LocalDateTime;
import java.util.ArrayList;

public class Restaurante{

    public static ArrayList<Mesa> mesas = new ArrayList<>();
    public static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    public static ArrayList<Requisicao> listasEspera = new ArrayList<>();

    public static void main(String[] args) {


        Mesa mesa1 = new Mesa(4, true);
        Mesa mesa2 = new Mesa(6, true);
        Mesa mesa3 = new Mesa(8, true);
        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);

        Cliente cliente1 = new Cliente("Danilo", "067.958.847-65");

        //adicionar get e set pros atributos
        Requisicao requisicao1 = new Requisicao(LocalDateTime.now(), 4, cliente1);
        
        Mesa m = verificarMesasDisponiveis(requisicao1.quantPessoas);
        if (m != null){
            requisicao1.alocarMesa(m);
        }
        if (m == null){
            adicionarNaListaDeEspera(requisicao1);
        }
        //tratar pra quando for null e ter que colocar no array lista de espera

    }

    public void adicionarMesaNoVetor(){

        

    }

    public static void adicionarNaListaDeEspera(Requisicao requisicao){
        
        listasEspera.add(requisicao);

    }

    public void retirarDaListaDeEspera() {

    for (Mesa mesa : mesas) {
            for (Requisicao requisicao : listasEspera) {
                if (mesa.verificaCapacidade(requisicao.quantPessoas)){
                    requisicao.alocarMesa(mesa);
                    listasEspera.remove(requisicao);
                }
            }
        }
    }

    public void atualizarMesaDisponivel() {


    }
    
    //mudar void-->Mesa
    public static Mesa verificarMesasDisponiveis(int quantPessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.ocupado == false && mesa.verificaCapacidade(quantPessoas)){
                return mesa;
            }
        }

        return null;     
    }
}