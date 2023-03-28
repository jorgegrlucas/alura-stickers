import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ExtratorDeConteudoDaNasa implements ExtratorDeConteudo{
    public List<Conteudo> extraiConteudos( String json){
        var parser = new JsonParser();
        List<Map<String, String>> listaDeAtributos = parser.parse(json);
        List<Conteudo> conteudos = new ArrayList<>();
        //popular a lista
        for (Map<String, String> atributos : listaDeAtributos) {
            if(atributos.get("media_type").equals("image"))
                conteudos.add(new Conteudo(atributos.get("title"), atributos.get("url")));
        }
        return conteudos;
    }
}
