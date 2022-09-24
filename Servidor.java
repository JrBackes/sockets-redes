import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Servidor {
    
    public static void main(String argv[]) throws Exception {
        // Usado durante o código
        Jogo[] jogos = new Jogo[6];
        Aposta[] apostas = new Aposta[6];
        Usuario user;

        //Criação da conexão
        ServerSocket socketRecepcao = new ServerSocket(6789);
        System.out.println("Servidor ouvindo a porta 6789");

        Socket cliente = socketRecepcao.accept();
        //System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());

        jogos[0] = new Jogo(1, "Internacional", "Bahia", "21/08/2022", 2, 3);
        jogos[1] = new Jogo(2, "Grêmio", "Vasco", "25/08/2022", 1, 2);
        jogos[2] = new Jogo(3, "São Paulo", "Corinthians", "30/10/2022", 4, 1);
        jogos[3] = new Jogo(4, "Flamengo", "Fluminense", "10/10/2022", 3, 1);
        jogos[4] = new Jogo(5, "Brasil de Pelotas", "Palmeiras", "12/10/2022", 1, 0);
        jogos[5] = new Jogo(6, "Juventude", "Caxias", "01/10/2022", 1, 1);

        ObjectInputStream input = new ObjectInputStream(cliente.getInputStream());

        user = (Usuario) input.readObject();
        System.out.println("Usuário: " + user.getUsuario() + " Pass: " + user.getPassword());

        cliente.close();

    }
}
