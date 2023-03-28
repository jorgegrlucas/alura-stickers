import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDoImdb implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos( String json){
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();
        //popular a lista
        for (Map<String, String> atributos : listaDeAtributos) {
            conteudos.add(new Conteudo(atributos.get("title"), atributos.get("image").replaceAll("(@+)(.*)jpg$", "$1.jpg")));
        }
        return conteudos;
    }
}
