import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cliente1 {
    
    public static void main(String argv[]) throws Exception {

        // Leitura do teclado
        Scanner teclado = new Scanner(System.in);

        //Váriaveis para criação do usuário
        String usuario = null;
        String senha = null;
        int idUser = 1;

        //Variaveis para conexão
        ObjectOutputStream output;

        // Inicialização da conexão
        Socket cliente = new Socket("127.0.0.1", 6789);

        //Processo de criação do usuário
        System.out.println("-------------------------");
        System.out.println("Digite seu usuário: ");
        usuario = teclado.next();
        System.out.println("Digite sua senha: ");
        senha = teclado.next();

        Usuario user = new Usuario(idUser++, usuario, senha);

        //output = new ObjectOutputStream(cliente.getOutputStream());
        //output.writeObject(user);

        ObjectInputStream recebe = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream envia = new ObjectOutputStream(cliente.getOutputStream());

        envia.writeObject(user);

        if(recebe != null){
            System.out.println("Menu:" + (recebe.readObject()));
        }

        envia.flush();
        envia.close();

        cliente.close();
    }
}
