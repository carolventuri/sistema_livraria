import java.util.Scanner;

public class Livro {
    String titulo, codigo, editora, area;
    int ano, estoque;
    double valor;

    public Livro() {
        Scanner tec = new Scanner(System.in);
        System.out.println("Digite o título do livro: ");
        this.titulo = tec.nextLine();
        System.out.println("Digite o código do livro: ");
        this.codigo = tec.nextLine();
        System.out.println("Digite a editora: ");
        this.editora = tec.nextLine();
        System.out.println("Digite a área do livro: ");
        this.area = tec.nextLine();
        System.out.println("Digite o ano de publicação: ");
        this.ano = tec.nextInt();
        System.out.println("Digite a quantidade em estoque: ");
        this.estoque = tec.nextInt();
        System.out.println("Digite o valor do livro: ");
        this.valor = tec.nextDouble();
        tec.nextLine();
    }

    public Livro(String codigo, String titulo, int ano, String area, String editora, double valor, int estoque) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.ano = ano;
        this.area = area;
        this.editora = editora;
        this.valor = valor;
        this.estoque = estoque;

    }

    public void info() {
        System.out.println();
        System.out.println(">>>>>>>>Código: " + this.codigo);
        System.out.println("Título/Editora: " + this.titulo + " / " + this.editora);
        System.out.println("Área: " + this.area);
        System.out.println("Ano: " + this.ano);
        System.out.printf("Valor: R$ %.2f\n", this.valor);
        System.out.println("Estoque: " + this.estoque);
        double valorEstoque = (this.estoque * this.valor);
        System.out.printf("Valor total em estoque: R$ %.2f\n", (valorEstoque));
    }
    public String getCodigoLivro() {
        return this.codigo;
    }
}