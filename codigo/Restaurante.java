import java.time.LocalDateTime;
import java.util.ArrayList;

public class Restaurante{

    public static ArrayList<Mesa> mesas = new ArrayList<>();
    public static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    public static ArrayList<Requisicao> listasEspera = new ArrayList<>();

    public static void main(String[] args) {


        Cliente cliente1 = new Cliente("Danilo", "067.958.847-65"); 

        Mesa mesa1 = new Mesa(4, false);
        Mesa mesa2 = new Mesa(6, false);
        Mesa mesa3 = new Mesa(8, false);
        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);

        //adicionar get e set pros atributos
        Requisicao requisicao1 = new Requisicao(LocalDateTime.now(), 4, cliente1);
        
        Mesa m = verificarMesasDisponiveis(requisicao1.quantPessoas);
        if (m != null){
            requisicao1.alocarMesa(m);
        }
        //tratar pra quando for null e ter que colocar no array lista de espera

        System.out.println("Branch features added!");
        
    }

    public void adicionarMesaNoVetor(){

        

    }

    public void adicionarNaListaDeEspera(){
        
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
            if (mesa.verificaCapacidade(quantPessoas)){
                return mesa;
            }
        }

        return null;     
    }
}