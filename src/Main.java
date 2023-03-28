import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //pegar todos os dados da api usando HttpRequest
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        // String url = "https://api.nasa.gov/planetary/apod?api_key=na72Fw88OjYAbMFxfyHrSlXCIIYC9jqLM9YkQKsd&start_date=2023-03-20&end_date=2023-03-27";
        var http = new ClienteHttp();
        String json = http.buscaDados(url);

        //Pegar os dados importantes do JSON
        //jackson(lib) parser de JSON
       

        //exibir
        // var extrator = new ExtratorDeConteudoDaNasa();
        ExtratorDeConteudo extrator = new ExtratorDeConteudoDoImdb();
        List<Conteudo> conteudos = extrator.extraiConteudos(json);
        var geradora = new GeradoraDeFigurinhas();

        for (Conteudo conteudo : conteudos
             ) {
                    String nomeDoArquivo = conteudo.getTitulo() + ".png";
                    InputStream inputStream = new URL(conteudo.getUrlImagem()).openStream();             
                    geradora.cria(inputStream, nomeDoArquivo);
                    System.out.println(conteudo.getTitulo());
                    System.out.println();
                }
        
        //Desafio1: Most Popular
        //Desafio2: Melhorar saídas
        //Desafio3: Extrair chave para colocar em outro local
        //Desafio4: Utilizar biblioteca externa para o parser
        //Desafio5: Adicionar as notas pessoais

        //Aula3
        //Desafio1: trocar classe conteudo para record
        //Desafio2: pesquisar exceções, utilizar exceção própria
        //Desafio3: explorar mapear direto usando uma stream/lambda java8
        //Desafio4: utilizar enum para salvar url e extrator de conteudo
        //Desafio5: utilizar outra API(Marvel) 
    }
}