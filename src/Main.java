import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        //pegar todos os dados da api usando HttpRequest
        String url = "https://mocki.io/v1/9a7c1ca9-29b4-4eb3-8306-1adb9d159060";
        URI endereco = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(endereco).GET().build();
        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        String body = response.body();

        //Pegar os dados importantes do JSON
        //jackson(lib) parser de JSON
        var parser = new JsonParser();
        List<Map<String, String>> listaDeFilmes = parser.parse(body);

        //exibir
        var geradora = new GeradoraDeFigurinhas();
        for (Map<String, String> filme : listaDeFilmes
             ) {
                
                String urlImagem = filme.get("image");
                String titulo = filme.get("title");
                String nomeDoArquivo = titulo + ".png";
                InputStream inputStream = new URL(urlImagem).openStream();

                
                geradora.cria(inputStream, nomeDoArquivo);

            System.out.println(titulo);
            System.out.println(filme.get("image"));
            System.out.println(filme.get("imDbRating"));
            System.out.println();
        }

        //Desafio1: Most Popular
        //Desafio2: Melhorar saídas
        //Desafio3: Extrair chave para colocar em outro local
        //Desafio4: Utilizar biblioteca externa para o parser
        //Desafio5: Adicionar as notas pessoais
    }
}