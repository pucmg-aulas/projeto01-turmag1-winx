import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {

    public static ArrayList<Mesa> mesas = new ArrayList<>();
    public static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    public static ArrayList<Requisicao> listasEspera = new ArrayList<>();
    public static ArrayList<Requisicao> requisicoesDaListaDeEsperaAtendidas = new ArrayList<>();
    public Requisicao requisicao;

    // Encontrar a requisição que você quer alocar uma mesa sabendo o cliente
    // Abrir requisição que chama cadastrarCliente, não o contrário (para boas
    // práticas)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op = 0;

        Mesa mesa1 = new Mesa(4, false);
        Mesa mesa2 = new Mesa(6, false);
        Mesa mesa3 = new Mesa(8, false);

        mesas.add(mesa1);
        mesas.add(mesa1);
        mesas.add(mesa1);
        mesas.add(mesa1);

        mesas.add(mesa2);
        mesas.add(mesa2);
        mesas.add(mesa2);
        mesas.add(mesa2);

        mesas.add(mesa3);
        mesas.add(mesa3);

        while (op != 7) {
            System.out.println("""
                    ***************MENU*******************************
                    * 1 - Abrir Requisição                           *
                    * 2 - Finalizar Requisição                       *
                    * 3 - Listar requisiçoes na lista de espera      *
                    * 4 - Listar requisiçoes abertas                 *
                    * 5 - Adicionar uma nova mesa                    *
                    * 6 - Listar mesas                               *
                    * 7 - Sair                                       *
                    **************************************************""");
            op = scanner.nextInt();

            switch (op) {
                case 1 -> {
                    abrirRequisicao();
                }
                case 2 -> {
                    // fazer a verificação de requisição para finalizar requisição
                    finalizarRequisicao();
                }
                case 3 -> {
                    // Listar requisições na lista de espera
                    listarRequisicoesNaListaDeEspera();
                }
                case 4 -> {
                    // Listar requisições abertas
                    listarRequisicoesAbertas();
                }
                case 5 -> {
                    // Adicionar uma nova mesa
                    criarMesa();
                }
                case 6 -> {
                    // Listar mesas
                    listarMesas();
                }
                case 7 -> {
                    System.out.println("Até logo!");
                    break;
                }
            }
        }
    }

    private static void listarMesas() {
        System.out.println("\n** Mesas **");
        for (Mesa mesa : mesas) {
            System.out.println((mesas.indexOf(mesa) + 1) + ". Mesa com capacidade para: " + mesa.getQuantidade()
                    + " pessoas." + (mesa.getOcupado() ? " Status: Ocupada" : " Status: Livre") + "\n");
        }
    }

    private static void listarRequisicoesAbertas() {
        System.out.println("\n** Requisições Abertas **");

        for (Requisicao requisicao : listasRequisicoes) {
            System.out.println((listasRequisicoes.indexOf(requisicao) + 1) + ". Cliente: " + requisicao.getClienteNome()
                    + " Mesa contendo: " + requisicao.getQuantPessoas() + " pessoas.\n");
        }
    }

    private static void listarRequisicoesNaListaDeEspera() {
        System.out.println("\n** Requisições na Lista de Espera **");
        for (Requisicao requisicao : listasEspera) {
            System.out.println((listasEspera.indexOf(requisicao) + 1) + ". Cliente: " + requisicao.getClienteNome()
                    + " Mesa para: " + requisicao.getQuantPessoas() + " pessoas.\n");
        }
    }

    private static void abrirRequisicao() {
        Scanner scanner = new Scanner(System.in);
        int quantPessoas;
        Cliente cliente;

        cliente = cadastrarCliente();

        System.out.println("\nVamos abrir uma requisição para " + cliente.getNome());
        System.out.print("Quantidade de pessoas na mesa: ");
        quantPessoas = scanner.nextInt();

        Requisicao requisicao = new Requisicao(LocalDateTime.now(), quantPessoas, cliente);

        decidirDestinoDaRequisicao(requisicao);
    }

    public static Cliente cadastrarCliente() {
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

    public static void perguntarClienteQuerEntrarListaDeEspera(Requisicao requisicao) {
        Scanner scanner = new Scanner(System.in);
        String resposta;

        System.out.print("\nInfelizmente não possuímos uma mesa com capacidade para " + requisicao.getQuantPessoas()
                + " pessoas. \nO cliente deseja entrar na lista de espera? (sim/não) ");
        resposta = scanner.nextLine();

        if (resposta.equals("sim")) {
            adicionarNaListaDeEspera(requisicao);
            System.out.println("\nCliente " + requisicao.getClienteNome() + " entrou na lista de espera.\n");
        } else if (resposta.equals("não")) {
            System.out.println("\nCliente " + requisicao.getClienteNome()
                    + " não deseja entrar na lista de espera. Atendimento finalizado.\n");
        }
    }

    public static Mesa verificarMesasDisponiveis(int quantPessoas) {
        for (Mesa mesa : mesas) {
            if (mesa.getOcupado() == false && mesa.verificaCapacidade(quantPessoas)) {
                return mesa;
            }
        }

        return null;
    }

    public static void adicionarRequisicaoNoVetor(Requisicao requisicao) {
        listasRequisicoes.add(requisicao);
    }

    public static void decidirDestinoDaRequisicao(Requisicao requisicao) {
        Mesa m = verificarMesasDisponiveis(requisicao.getQuantPessoas());
        if (m != null) {
            requisicao.alocarMesa(m); // mesa pode ter um indice para identifica-la?

            adicionarRequisicaoNoVetor(requisicao);

            if (listasEspera.contains(requisicao)) {
                requisicoesDaListaDeEsperaAtendidas.add(requisicao);
            }

            System.out.println("\nO cliente " + requisicao.getClienteNome()
                    + " foi alocado com sucesso a uma mesa com capacidade para " + m.getQuantidade() + " pessoas.\n");
        }
        if (m == null && !listasEspera.contains(requisicao)) {
            perguntarClienteQuerEntrarListaDeEspera(requisicao);
        }
    }

    public static void adicionarNaListaDeEspera(Requisicao requisicao) {

        listasEspera.add(requisicao);

    }

    private static Requisicao pesquisarRequisicao() {
        Scanner scanner = new Scanner(System.in);
        String nomeCliente;

        System.out.print("\nNome do cliente responsavel pela requisição: ");
        nomeCliente = scanner.nextLine();

        for (Requisicao requisicao : listasRequisicoes) {
            if (requisicao.getClienteNome().equals(nomeCliente)) {
                return requisicao;
            }
        }

        return null;
    }

    private static void finalizarRequisicao() {
        Requisicao req;
        req = pesquisarRequisicao();

        req.setDataSaida(LocalDateTime.now());
        req.getMesa().desocuparMesa();
        System.out.println("\nA requisição do cliente " + req.getClienteNome() + " foi finalizada com sucesso.\n");

        verificarListaDeEspera();
    }

    private static void verificarListaDeEspera() {
        for (Requisicao requisicao : listasEspera) {
            decidirDestinoDaRequisicao(requisicao);
        }

        listasEspera.removeAll(requisicoesDaListaDeEsperaAtendidas);
    }

    public static void criarMesa() {

        Scanner scanner = new Scanner(System.in);

        int quantidade;
        System.out.println("Quantos lugares a mesa possui?");
        quantidade = scanner.nextInt();

        Mesa m = new Mesa(quantidade, false);

        adicionarMesaNoVetor(m);
    }

    public static void adicionarMesaNoVetor(Mesa m) {
        mesas.add(m);
        System.out.println("Mesa adicionada com sucesso!");
        verificarListaDeEspera();
    }
}