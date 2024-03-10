import java.util.Scanner;
import java.util.ArrayList;

public class Filial {
    String nome, endereco, contato;
    int codigo;
    ArrayList<Livro> listaLivros;

    public Filial (int codigo, String nome, String endereco, String contato){
        this.codigo = codigo;
        this.nome = nome;
        this.endereco = endereco;
        this.contato = contato;
    }
    public Filial (){
        Scanner tec = new Scanner (System.in);
        System.out.println("Digite o código da filial: ");
        this.codigo = tec.nextInt();
        System.out.println("Digite o nome da filial: ");
        this.nome = tec.next();
        System.out.println("Digite o endereço da filial: ");
        this.endereco = tec.next();
        System.out.println("Digite o contato da filial: ");
        this.contato = tec.next();

        listaLivros = new ArrayList<>();
    }
    public void info (){
        System.out.println("Código da Filial: " + this.codigo);
        System.out.println("Nome da Filial: " + this.nome);
        System.out.println("Endereço da Filial: " + this.endereco);
        System.out.println("Contato da Filial: " + this.contato);
        System.out.println("Livros em estoque: ");
        for (int i=0; i< listaLivros.size(); i++){
            listaLivros.get(i).info();
        }
    }
    public void cadastraLivro(){
        listaLivros.add(new Livro());
        System.out.println("Livro cadastrado com sucesso!");
    }

    public int getCodigoFilial() {
        return this.codigo;
    }
}
