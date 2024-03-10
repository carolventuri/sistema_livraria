import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner tec = new Scanner(System.in);

    static ArrayList<Filial> listaFiliais = new ArrayList<>();


    //opcao 1 do menu:
    public static void cadastraLivro(){
        int cadastro = 0;
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();

        for (int i=0; i<listaFiliais.size(); i++){
            if (listaFiliais.get(i).codigo == codigoFilial){
                listaFiliais.get(i).listaLivros.add(new Livro());
                System.out.println("Livro cadastrado com sucesso!");
                i = listaFiliais.size();
                cadastro++;
            }
        }
        if (cadastro == 0){
            System.out.println("Digite um número de código válido para determinar a filial.");
        }
    }
    // opcao 2 do menu:
    public static void listaLivrosEstoque () {
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).getCodigoFilial() == codigoFilial){
                for (int j = 0; j < listaFiliais.get(i).listaLivros.size(); j++) {
                    listaFiliais.get(i).listaLivros.get(j).info();
                }
            }
        }
    }
    // opcao 3 do menu:
    public static void nomeBusca (){
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).getCodigoFilial() == codigoFilial) {
                System.out.println("Digite o nome do livro a ser buscado:");
                String nomebusca = tec.next();
                int achou = 0;
                for (int j=0; j<listaFiliais.get(i).listaLivros.size(); j++){
                    if (listaFiliais.get(i).listaLivros.get(j).titulo.contains (nomebusca)) {
                        System.out.println("Livro(s) encontrado(s). Informações:");
                        listaFiliais.get(i).listaLivros.get(j).info();
                        achou++;
                    }
                }
                if (achou == 0){
                    System.out.println("Não há livro com o título " +nomebusca+ " cadastrado no sistema.");
                }
            }
        }
    }
    // opcao 4 do menu:
    public static void areaBusca (){
        int achou = 0;
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).codigo == codigoFilial) {
                System.out.println("Digite a área do livro a ser buscada:");
                String areabusca = tec.next();
                for (int j = 0; j < listaFiliais.get(i).listaLivros.size(); j++) {
                    if (listaFiliais.get(i).listaLivros.get(j).area.contains (areabusca)) {
                        achou++;
                        System.out.println("Foram encontrados livro(s) para a área pesquisada. Seguem abaixo as informações:");
                        listaFiliais.get(i).listaLivros.get(j).info();
                    }
                }
            }

        }
        if (achou == 0) {
            System.out.println("Não há livro cadastrado no sistema para a área informada.");
        }
    }
    // opcao 5 do menu:
    public static void precoMenorBusca(){
        int achou=0;
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).getCodigoFilial() == codigoFilial) {
                System.out.println("Digite o valor para busca de livros com valor menor: ");
                int valorMaximo = tec.nextInt();
                for (int j = 0; j < listaFiliais.get(i).listaLivros.size(); j++) {
                    if (listaFiliais.get(i).listaLivros.get(j).valor < valorMaximo) {
                        achou++;
                    }
                }
                if (achou == 0) {
                    System.out.println("Não há livro cadastrado no sistema com valor menor do que " + valorMaximo + " reais.");
                } else {
                    System.out.println("Foram encontrados " + achou + " livro(s) com valor menor do que " + valorMaximo + " reais. Seguem abaixo as informações:");
                }
                for (int k = 0; k < listaFiliais.get(i).listaLivros.size(); k++) {
                    if (listaFiliais.get(i).listaLivros.get(k).valor < valorMaximo) {
                        listaFiliais.get(i).listaLivros.get(k).info();
                    }
                }
            }
        }
    }
    // opcao 6 do menu:
    public static void quantidadeEstoqueBusca (){
        int achou=0;
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).getCodigoFilial() == codigoFilial) {
                System.out.println("Digite o intervalo de estoque a ser buscado: ");
                System.out.println("Digite a quantidade mínima: ");
                int qtdMinima = tec.nextInt();
                System.out.println("Digite a quantidade máxima: ");
                int qtdMaxima = tec.nextInt();
                achou = 0;
                for (int j = 0; j < listaFiliais.get(i).listaLivros.size(); j++) {
                    if (listaFiliais.get(i).listaLivros.get(j).estoque <= qtdMaxima && listaFiliais.get(i).listaLivros.get(j).estoque >= qtdMinima) {
                        listaFiliais.get(i).listaLivros.get(j).info();
                        achou++;
                    }
                }
                if (achou == 0) {
                    System.out.println("Não foram encontrados livros com quantidade em estoque entre " + qtdMinima + " e " + qtdMaxima + " unidades.");
                } else {
                    System.out.println("Foram encontrados " + achou + " livro(s) com quantidade em estoque entre " + qtdMinima + " e " + qtdMaxima + " unidades na filial #FL" + codigoFilial);
                }
            }
        }
    }
    // opcao 7 do menu:
    public static void valortotalEstoqueBusca () {

        double valortotalEstoque = 0;
        int achou = 0;
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).getCodigoFilial() == codigoFilial) {
                for (int j = 0; j < listaFiliais.get(i).listaLivros.size(); j++) {
                    valortotalEstoque += ((listaFiliais.get(i).listaLivros.get(j).estoque) * (listaFiliais.get(i).listaLivros.get(j).valor));
                }
                System.out.printf("O valor total em estoque da filial #FL %d é: R$ %.2f.", codigoFilial, valortotalEstoque);
                System.out.println();
            }
        }
    }
    // opcao 8 do menu:
    public static void carregaArquivoDadosLivraria() throws FileNotFoundException {
        FileInputStream arquivoDadosLivraria = new FileInputStream("src/dadoslivraria.txt");
        Scanner arquivo = new Scanner(arquivoDadosLivraria);
        Filial filialAtual = null;

        while (arquivo.hasNextLine()) {
            String linha = arquivo.nextLine();
            String[] campo = linha.split(",");

            if (campo[0].contains("#FL")) {
                filialAtual = new Filial(Integer.parseInt(campo[0].replace("#FL", "")), campo[1], campo[2], campo[3]);
                filialAtual.listaLivros = new ArrayList<>();
                listaFiliais.add(filialAtual);

            }
            if (filialAtual != null && campo.length > 4) {
                filialAtual.listaLivros.add (new Livro(campo[0], campo[1], Integer.parseInt(campo[2]),
                        campo[3], campo[4], Double.parseDouble(campo[5].replace("R$", "")),
                        Integer.parseInt(campo[6])));
            }
        }
        System.out.println("Arquivo carregado com sucesso!");
    }

    // opcao 9 do menu:
    public static void atualizaArquivoDadosLivraria () throws IOException {
        FileOutputStream arquivoDadosLivraria = new FileOutputStream("src/dadoslivraria.txt");
        PrintWriter escreveArquivo = new PrintWriter(arquivoDadosLivraria);

        for (Filial filial: listaFiliais) {
            String linhaFilial = ("#FL" + filial.codigo + "," + filial.nome + "," + filial.endereco + "," + filial.contato);
            escreveArquivo.println(linhaFilial);

            for (Livro livro: filial.listaLivros) {
                String linhaLivro = (livro.codigo + "," + livro.titulo + "," + livro.ano + "," + livro.area + ","
                        + livro.editora + ","  + "R$" + livro.valor +  "," + livro.estoque);
                escreveArquivo.println(linhaLivro);
            }
        }
        System.out.println("Arquivo de dados atualizado com sucesso!");
        escreveArquivo.close();
    }
    //opcao 10 do menu
    public static void cadastraFilial(){
        listaFiliais.add(new Filial());
    }
    //opcao 11 do menu
    public static void listagemEstoque() {
        int achou = 0;
        double valorEstoque, somaValorEstoque = 0;
        System.out.println("Digite o codigo da filial: ");
        int codigoFilial = tec.nextInt();
        for (int i = 0; i < listaFiliais.size(); i++) {
            if (listaFiliais.get(i).getCodigoFilial() == codigoFilial) {
                System.out.println("Listagem dos livros em estoque na filial " + codigoFilial + ": ");
                for (int j=0; j< listaFiliais.get(i).listaLivros.size(); j++){
                    listaFiliais.get(i).listaLivros.get(j).info();
                    valorEstoque = (listaFiliais.get(i).listaLivros.get(j).estoque * listaFiliais.get(i).listaLivros.get(j).valor);
                    somaValorEstoque += valorEstoque;
                    achou++;
                }
            }
        }
        if (achou == 0){
            System.out.println("Não há livros em estoque cadastrados para a filial informada.");
        }else{
            System.out.println();
            System.out.println("O valor total em livros no estoque da filial "+ codigoFilial + " é: R$ " +somaValorEstoque);
        }
    }

    //opcao 12 do menu
    public static void buscaCodigoLivro (){
        int achou = 0;
        double valorTotalEstoque = 0;
        System.out.println("Digite o código do livro a ser buscado: ");
        String codigoLivroBusca = tec.next();

        for (int i=0; i< listaFiliais.size(); i++){
            for (int j=0; j < listaFiliais.get(i).listaLivros.size(); j++) {
                if (codigoLivroBusca.equals(listaFiliais.get(i).listaLivros.get(j).getCodigoLivro())) {
                    System.out.println(">>>>>>>>Cod#" + listaFiliais.get(i).listaLivros.get(j).codigo);
                    System.out.println("Título/Editora: " + listaFiliais.get(i).listaLivros.get(j).titulo + " / " + listaFiliais.get(i).listaLivros.get(j).editora);
                    System.out.println("Categoria: " + listaFiliais.get(i).listaLivros.get(j).area);
                    System.out.println("Ano: " + listaFiliais.get(i).listaLivros.get(j).ano);
                    achou++;
                }
            }
            break;
        }
        if (achou > 0){
            for (int i=0; i< listaFiliais.size(); i++){
                for (int j=0; j < (listaFiliais.get(i).listaLivros.size()); j++) {
                    if (codigoLivroBusca.equals(listaFiliais.get(i).listaLivros.get(j).getCodigoLivro())) {
                        Livro livroAtual = listaFiliais.get(i).listaLivros.get(j);

                        System.out.printf("Valor: R$ %.1f >>> Filial %s, estoque: %d unidades.%n",
                                livroAtual.valor, listaFiliais.get(i).nome,
                                livroAtual.estoque);

                        valorTotalEstoque += (listaFiliais.get(i).listaLivros.get(j).valor*listaFiliais.get(i).listaLivros.get(j).estoque);
                    }
                }
            }
            System.out.println("Valor total em estoque: R$ " + valorTotalEstoque);
        }else{
            System.out.println("O livro contendo o código informado não existe no estoque.");
        }
    }


    public static void main(String[] args) throws IOException {
        Scanner tec = new Scanner(System.in);

        int opcao = -1;

        carregaArquivoDadosLivraria();

        while (opcao!=0) {
            System.out.println();
            System.out.println("Opções do menu: ");
            System.out.println();
            System.out.println("1 – Cadastrar novo livro");
            System.out.println("2 – Listar livros");
            System.out.println("3 – Buscar livros por nome");
            System.out.println("4 – Buscar livros por área");
            System.out.println("5 – Buscar quais livros tem preço menor que um valor");
            System.out.println("6 – Buscar por quantidade em estoque");
            System.out.println("7 – Exibir o valor total em estoque");
            System.out.println("8 - Carregar estoque");
            System.out.println("9 - Atualizar arquivo de estoque");
            System.out.println("10 - Cadastra Filial");
            System.out.println("11 - Listagem estoque da Filial");
            System.out.println("12 - Busca por código do livro");
            System.out.println("0 – Encerrar as atividades");
            System.out.println();

            System.out.println("Digite o número correspondente à opção do menu desejada: ");

            opcao = tec.nextInt();
            System.out.println();

            if (opcao<0 || opcao>12){
                System.err.println("Opção inválida. Por favor, digite um número entre as opções disponíveis no menu. ");
            }

            switch (opcao) {
                case 1 -> cadastraLivro();
                case 2 -> listaLivrosEstoque ();
                case 3 -> nomeBusca();
                case 4 -> areaBusca();
                case 5 -> precoMenorBusca();
                case 6 -> quantidadeEstoqueBusca();
                case 7 -> valortotalEstoqueBusca();
                case 8 -> carregaArquivoDadosLivraria ();
                case 9 -> atualizaArquivoDadosLivraria ();
                case 10 -> cadastraFilial();
                case 11 -> listagemEstoque();
                case 12 -> buscaCodigoLivro () ;
                case 0 -> {
                    System.out.println("Gostaria de atualizar o arquivo de estoque?");
                    System.out.println("Digite 1 para atualizar o arquivo de estoque ou 0 para sair do sistema.");
                    int x = tec.nextInt();
                    while (x < 0 || x > 1) {
                        System.out.println("Digite 1 para atualizar o arquivo de estoque ou 0 para sair do sistema.");
                        x = tec.nextInt();
                    }
                    if (x == 0) {
                        System.out.println("Até logo!!!");
                    } else {
                        atualizaArquivoDadosLivraria();
                    }
                }
            }
        }
    }
}
