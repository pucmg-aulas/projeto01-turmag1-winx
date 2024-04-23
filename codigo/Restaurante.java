import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante{

    public static ArrayList<Mesa> mesas = new ArrayList<>();
    public static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    public static ArrayList<Requisicao> listasEspera = new ArrayList<>();
    public Requisicao requisicao;

    // Encontrar a requisição que você quer alocar uma mesa sabendo o cliente
    // Abrir requisição que chama cadastrarCliente, não o contrário (para boas práticas)



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op = 0;

        Mesa mesa1 = new Mesa(4, true);
        Mesa mesa2 = new Mesa(6, false);
        Mesa mesa3 = new Mesa(8, true);
        mesas.add(mesa1);
        mesas.add(mesa2);
        mesas.add(mesa3);

        

        while(op != 3) {
            System.out.println("""
                           ***************MENU**************
                           * 1 - Abrir Requisição          *
                           * 2 - Finalizar Requisição      *
                           * 3 - Sair                      *
                           *********************************""");
            op = scanner.nextInt();

            switch(op){
                case 1 -> {
                    abrirRequisicao();
                }
                case 2 -> {
                    // fazer a verificação de requisição para finalizar requisição
                }
                case 3 -> {
                    break;
                }
            }   
        }

    }

    private static void abrirRequisicao() {
        Scanner scanner = new Scanner(System.in);
        int quantPessoas;
        Cliente cliente;

        cliente = cadastrarCliente();

        System.out.println("\nVamos abrir uma requisição para "+ cliente.getNome());
        System.out.print("Quantidade de pessoas na mesa: ");
        quantPessoas = scanner.nextInt();
        

        Requisicao requisicao = new Requisicao(LocalDateTime.now(), quantPessoas, cliente);

        decidirDestinoDaRequisicao(requisicao);
    }

    public static Cliente cadastrarCliente(){
        Scanner scanner = new Scanner(System.in);
        String nomeCliente, cpf;

        System.out.println("--- Bem vindo! ---\n");
        System.out.print("Nome do cliente: ");
        nomeCliente = scanner.nextLine();

        System.out.print("CPF: (no formato 000.000.000-00) ");
        cpf = scanner.nextLine();

        Cliente cliente = new Cliente(nomeCliente, cpf);

        return cliente;
    }


    public void adicionarMesaNoVetor(){

        

    }

    public static void adicionarNaListaDeEspera(Requisicao requisicao){

        listasEspera.add(requisicao);

    }

    public static void perguntarClienteQuerEntrarListaDeEspera(Requisicao requisicao){
        Scanner scanner = new Scanner(System.in);
        String resposta;

        System.out.print("\nInfelizmente não possuímos uma mesa com capacidade para " + requisicao.getQuantPessoas() +" pessoas. \nO cliente deseja entrar na lista de espera? (sim/não) ");
        resposta = scanner.nextLine();
        

        if (resposta.equals("sim")){
            adicionarNaListaDeEspera(requisicao);
            System.out.println("\nCliente "+ requisicao.getClienteNome() + " entrou na lista de espera.\n");
        } else if (resposta.equals("não")) {
            System.out.println("\nCliente "+ requisicao.getClienteNome() + " não deseja entrar na lista de espera. Atendimento finalizado.\n");
        }
    }

    public void retirarDaListaDeEspera() {

    for (Mesa mesa : mesas) {
            for (Requisicao requisicao : listasEspera) {
                if (mesa.verificaCapacidade(requisicao.getQuantPessoas())){
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
            if (mesa.getOcupado() == false && mesa.verificaCapacidade(quantPessoas)){
                return mesa;
            }
        }

        return null;     
    }

    public static void decidirDestinoDaRequisicao(Requisicao requisicao){
        Mesa m = verificarMesasDisponiveis(requisicao.getQuantPessoas());
                if (m != null){
                    requisicao.alocarMesa(m); // mesa pode ter um indice para identifica-la?
                    listasRequisicoes.add(requisicao);
                    System.out.println("\nO cliente "+ requisicao.getClienteNome() + " foi alocado com sucesso a uma mesa com capacidade para "+ m.getQuantidade() + " pessoas.\n");
                }
                if (m == null){
                    perguntarClienteQuerEntrarListaDeEspera(requisicao);
                }
    }
    


}