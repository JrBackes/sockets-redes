import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Cliente2 {
    
    public static void main(String argv[]) throws Exception {

        // Leitura do teclado
        Scanner teclado = new Scanner(System.in);

        //Váriaveis para criação do usuário
        String frase;
        int escolha = 0;
        String usuario = null;
        String senha = null;
        int idUser = 1;
        Jogo j;

        //Variaveis para conexão
        ObjectOutputStream output;

        // Inicialização da conexão
        BufferedReader doUsuario = new BufferedReader(new InputStreamReader(System.in)); 
        Socket cliente = new Socket("127.0.0.1", 6789);

        //Processo de criação do usuário
        System.out.println("-------------------------");
        System.out.println("Digite seu usuário: ");
        usuario = teclado.next();
        System.out.println("Digite sua senha: ");
        senha = teclado.next();

        Usuario user = new Usuario(idUser++, usuario, senha);
        System.out.println(user);
        DataOutputStream paraServidor = new DataOutputStream(cliente.getOutputStream());
        BufferedReader doServidor = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
        // Estrutura Menu
        while (escolha != 99) {
            System.out.println("  ");
            System.out.println("Selecione uma opção abaixo:");
            System.out.println("1 - Ver resultados");
            System.out.println("2 - Ver partidas");
            System.out.println("3 - Fazer aposta");
            System.out.println("4 - Ver minhas apostas");
            System.out.println("99 - Para sair");
            escolha = teclado.nextInt();
            paraServidor.writeByte(escolha);
            frase = doServidor.readLine();
            System.out.println(frase + '\n');

        }
        
        //output = new ObjectOutputStream(cliente.getOutputStream());
        //output.writeObject(user);

        //ObjectInputStream recebe = new ObjectInputStream(cliente.getInputStream());
        //ObjectOutputStream envia = new ObjectOutputStream(cliente.getOutputStream());

        //envia.writeObject(user);

        //if(recebe != null){
            //System.out.println("Menu:" + (recebe.readObject()));
        //}

        paraServidor.flush();
        paraServidor.close();
        teclado.close();
        cliente.close();
    }
}
