package restaurante;
import model.Cliente;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import model.Mesa;
import model.Requisicao;

public class Restaurante {

    private static ArrayList<Mesa> mesas = new ArrayList<>();
    private static ArrayList<Requisicao> listasRequisicoes = new ArrayList<>();
    private static ArrayList<Requisicao> listasEspera = new ArrayList<>();
    private static ArrayList<Requisicao> requisicoesDaListaDeEsperaAtendidas = new ArrayList<>();

    private static ArrayList<Produto> listaProdutos = new ArrayList<>();

    // Encontrar a requisição que você quer alocar uma mesa sabendo o cliente
    // Abrir requisição que chama cadastrarCliente, não o contrário (para boas
    // práticas)

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int op = 0;

      //  Mesa mesa1 = new Mesa(4, false, 1);
       // Mesa mesa2 = new Mesa(6, false, 2);
       // Mesa mesa3 = new Mesa(8, false, 3);

      // mesas.add(mesa1);
       // mesas.add(mesa2);
       // mesas.add(mesa3);

        listaProdutos.add(new Bebida("Água", 4.00, 20));
        listaProdutos.add(new Bebida("Suco", 6.00, 20));
        listaProdutos.add(new Bebida("Refrigerante", 8.00, 20));
        listaProdutos.add(new Bebida("Cerveja", 12.00, 20));
        listaProdutos.add(new Bebida("Taça de vinho", 10.00, 20));
        listaProdutos.add(new Prato("Moqueca de Tilápia", 59.00, 20));
        listaProdutos.add(new Prato("Falafel Assado", 55.00, 20));
        listaProdutos.add(new Prato("Salada Primavera com Macarrão Konjac", 45.00, 20));
        listaProdutos.add(new Prato("Escondidinho de Frango", 39.00, 20));
        listaProdutos.add(new Prato("Strogonoff", 39.00, 20));
        listaProdutos.add(new Prato("Caçarola de carne com legumes", 45.00, 20));

        while (op != 9) {
            System.out.println("""
                    ***************MENU*******************************
                    * 1 - Abrir Requisição                           *
                    * 2 - Finalizar Requisição                       *
                    * 3 - Listar requisiçoes na lista de espera      *
                    * 4 - Listar requisiçoes abertas                 *
                    * 5 - Adicionar uma nova mesa                    *
                    * 6 - Listar mesas                               *
                    * 7 - Fazer pedido                               *
                    * 8 - Total da requisição                        *
                    * 9 - Sair                                       *
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
                    fazerPedido();
                }
                case 8 -> {
                    resumoRequisicao2();
                }
                case 9 -> {
                    System.out.println("Até logo!");
                    break;
                }
            }
        }
    }

    private static void listarMesas() {
        System.out.println("\n** Mesas **");
       // for (Mesa mesa : mesas) {
        //    System.out.println((mesas.indexOf(mesa) + 1) + ". Mesa com capacidade para: " + mesa.getQuantidade()
        //            + " pessoas." + (mesa.getOcupado() ? " Status: Ocupada" : " Status: Livre") + "\n");
        //}
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
            if (mesa.isOcupado() == false && mesa.verificaCapacidade(quantPessoas)) {
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
                    + " foi alocado com sucesso a uma mesa com capacidade para " + m.getCapacidade() + " pessoas.\n");
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

        resumoRequisicao(req);

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

        //Mesa m = new Mesa(quantidade, false, 2);

        //adicionarMesaNoVetor(m);
    }

    public static void adicionarMesaNoVetor(Mesa m) {
        mesas.add(m);
        System.out.println("Mesa adicionada com sucesso!");
        verificarListaDeEspera();
    }

    // SPRINT 2

    public static void fazerPedido(){
        Scanner scanner = new Scanner(System.in);
        Requisicao requisicao = null;
        Produto produtoPedido = null;
        int quantidade = 0;

        requisicao = pesquisarRequisicao();
        if (requisicao == null) {
            System.out.println("\nNão é possível encontrar  a requisição desse cliente. \nConfira se digitou certo.");
            return;
        }

        System.out.print("\nQual produto quer pedir : ");
        produtoPedido = selecionarProduto();

        System.out.print("\nQual a quantidade desse produto ? ");
        quantidade = scanner.nextInt();

        if (!verificaEstoque(produtoPedido, quantidade)) {
            System.out.println("\nNão é possível concluir o pedido com essa quantidade. \nO atual estoque do produto " + produtoPedido.getNome() + " é: " + produtoPedido.getEstoque());
            return;
        }

        //Pedido p = new Pedido(calculaTotalPedido(produtoPedido, quantidade), requisicao, produtoPedido, quantidade );
        Pedido p = new Pedido(calculaTotalPedido(produtoPedido, quantidade), produtoPedido, quantidade );
        //requisicao.adicionarPedidoNoVetor(p);
        System.out.println("\nTotal do pedido : " + calculaTotalPedido(produtoPedido, quantidade));
        produtoPedido.atualizaEstoque(-quantidade);
    }

    private static double calculaTotalPedido(Produto produto, int quantidade){
        return produto.getPreco() * (double)quantidade;
    }

    private static Produto selecionarProduto() {
        Scanner scanner = new Scanner(System.in);
        int op = 0;
        Produto produtoSelecionado = null;


        while (op != 12) {
            System.out.println("""
                \n  ***************MENU*******************************
                    * 1 - Moqueca de Tilápia                         *
                    * 2 - Falafel Assado                             *
                    * 3 - Salada Primavera com Macarrão Konjac       *
                    * 4 - Escondidinho de Frango                     *
                    * 5 - Strogonoff                                 *
                    * 6 - Caçarola de Carne com legumes              *
                    * 7 - Água                                       *
                    * 8 - Suco                                       *
                    * 9 - Refrigerante                               *
                    * 10 - Cerveja                                   *
                    * 11 - Taça de Vinho                             *
                    * 12 - Cancelar Pedido                           *
                    **************************************************""");
            op = scanner.nextInt();

            switch (op) {
                case 1 -> {
                    produtoSelecionado = pesquisarProduto("Moqueca de Tilápia");
                    break;
                }
            
                case 2 -> {
                    produtoSelecionado = pesquisarProduto("Falafel Assado");
                    break;
                }
            
                case 3 -> {
                    produtoSelecionado = pesquisarProduto("Salada Primavera com Macarrão Konjac");
                    break;
                }
            
                case 4 -> {
                    produtoSelecionado = pesquisarProduto("Escondidinho de Frango");
                    break;
                }
            
                case 5 -> {
                    produtoSelecionado = pesquisarProduto("Strogonoff");
                    break;
                }
            
                case 6 -> {
                    produtoSelecionado = pesquisarProduto("Caçarola de Carne com legumes");
                    break;
                }
            
                case 7 -> {
                    produtoSelecionado = pesquisarProduto("Água");
                    break;
                }
            
                case 8 -> {
                    produtoSelecionado = pesquisarProduto("Suco");
                    break;
                }
            
                case 9 -> {
                    produtoSelecionado = pesquisarProduto("Refrigerante");
                    break;
                }
            
                case 10 -> {
                    produtoSelecionado = pesquisarProduto("Cerveja");
                    break;
                }
            
                case 11 -> {
                    produtoSelecionado = pesquisarProduto("Taça de vinho");
                    break;
                }
            
                case 12 -> {
                    System.out.println("Pedido Cancelado.");
                    break;
                }
            }
            if (produtoSelecionado != null) {
                return produtoSelecionado;
            }
        }
        return null;
    }

    private static Produto pesquisarProduto(String name) {
        for (Produto produto : listaProdutos) {
            if (produto.getNome().equals(name)) {
                return produto;
            }
        }
        return null;
    }

    private static boolean verificaEstoque(Produto produto, int quantidade) {
        return produto.getEstoque() >= quantidade;
    }

    private static void resumoRequisicao2(){
        Requisicao req;
        req = pesquisarRequisicao();

        resumoRequisicao(req);
    }

    private static void resumoRequisicao(Requisicao req) {

        DecimalFormat df = new DecimalFormat("#.##");

        System.out.println("\nTotal do Comanda : " + df.format(req.calculaTotalComTaxa()));

        System.out.println("\nTotal dividido: " + df.format(req.calculaTotalComTaxa() / req.getQuantPessoas()) + " por pessoa");
    }
}