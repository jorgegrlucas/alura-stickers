import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class GeradoraDeFigurinhas {


    public void cria(InputStream inputStream, String nomeArquivo) throws IOException {
        // InputStream inputStream = new FileInputStream(new File("entrada/filme.jpg"));
        // InputStream inputStream2 = new URL("https://m.media-amazon.com/images/M/MV5BMTMxNTMwODM0NF5BMl5BanBnXkFtZTcwODAyMTk2Mw@@._V1_UX128_CR0,3,128,176_AL_.jpg").openStream();
        //leitura da imagem
        BufferedImage imagemOriginal = ImageIO.read(inputStream);
        System.out.println(imagemOriginal);

        //criar nova imagem em memória com transparencia e tamanho novo
        var largura = imagemOriginal.getWidth();
        var altura = imagemOriginal.getHeight();
        int novaAltura = (int) ((int) altura * 1.2);
        var novaImagem = new BufferedImage(largura, novaAltura,BufferedImage.TRANSLUCENT);
        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0 ,0 , null);
        

        //copiar a imagem original para a nova imagem em memória

        //configurar a fonte
        graphics.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 24));
        graphics.setColor(Color.YELLOW);

        //escrever uma frase na nova imagem
        graphics.drawString("topzera", 0, (int)(novaAltura-(novaAltura*0.07)));
        

        //escrever a imagem nova em um arquivo
        ImageIO.write(novaImagem, "png", new File("saida/"+nomeArquivo));
    }

    //Desafio1: Imagens melhores
    //Desafio2: Adicionar os posters
    //Desafio3: Melhorar os textos adicionados, centralizar, usar fontes dos memes(impact) contorno preto(outline), adicionar a imagem do selo
    //Desafio4: Inputstream

}
