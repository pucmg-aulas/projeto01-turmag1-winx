import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante{

    public static ArrayList<Mesa> mesas = new ArrayList<>();
    public static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    public static ArrayList<Requisicao> listasEspera = new ArrayList<>();
    public static Requisicao requisicao;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op;

        Mesa mesa1 = new Mesa(4, false);
        Mesa mesa2 = new Mesa(6, true);
        Mesa mesa3 = new Mesa(8, true);
        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);

        System.out.println("""
                           ***************MENU***************
                           * 1 - Abrir Requisição           *
                           * 2 - Alocar uma mesa ao Cliente *
                           * 3 - Sair                      *
                           **********************************""");
        op = scanner.nextInt();

        while(op != 3){
            switch(op){
            case 1 -> {
                requisicao = cadastrarCliente();
            }
            case 2 -> {
                Mesa m = verificarMesasDisponiveis(requisicao.quantPessoas);
                if (m != null){
                    requisicao.alocarMesa(m);
                    System.out.println("Cliente alocado para mesa"); // mesa pode ter um indice para identifica-la?
                }
                if (m == null){
                    System.out.println("Infelizmente não temos uma mesa disponível para esse cliente!");
                }
            }
            case 3 -> {
                break;
            }
            }
            
            System.out.println("""
                ***************MENU***************
                * 1 - Abrir Requisição           *
                * 2 - Alocar uma mesa ao Cliente *
                * 3 -  Sair                      *
                **********************************""");
            op = scanner.nextInt();
            System.out.println("");
          
        }

        scanner.close();

    }

    private static Requisicao abrirRequisicao(Cliente cliente) {
        Scanner scanner = new Scanner(System.in);
        int quantPessoas;

        System.out.println("Vamos abrir uma requisição para "+ cliente.nome);
        System.out.print("Quantidade de pessoas: ");
        quantPessoas = scanner.nextInt();


        Requisicao requisicao = new Requisicao(LocalDateTime.now(), quantPessoas, cliente);
        
        scanner.close();
        return requisicao;
    }

    public static Requisicao cadastrarCliente(){
        Scanner scanner = new Scanner(System.in);
        String nome_cliente, cpf;

        System.out.println("--- Bem vindo! ---\n");
        System.out.print("Nome do cliente: ");
        nome_cliente = scanner.nextLine();

        System.out.println("CPF: (no formato 000.000.000-00)");
        cpf = scanner.nextLine();

        scanner.close();

        Cliente cliente = new Cliente(nomeCliente, cpf);

        return abrirRequisicao(cliente);
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