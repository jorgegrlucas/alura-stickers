import javax.imageio.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeradoraDeFigurinhas {


    public void cria() throws IOException {
        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(new File("entrada/filme.jpg"));

        //criar nova imagem em memócia com transparencia e tamanho novo
        var largura = imagemOriginal.getWidth();
        var altura = imagemOriginal.getHeight();
        var novaAltura = altura + 200;
        var novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0 ,0 , null);
        ImageIO.write(novaImagem, "png", new File("saida/figurinha. png"));

        //copiar a imagem original para a nova imagem em memória

        //escrever uma frase na nova imagem

        //escrever a imagem nova em um arquivo
    }

    public static void main(String[] args) throws IOException {
        var geradora = new GeradoraDeFigurinhas();
        geradora.cria();
    }


}
