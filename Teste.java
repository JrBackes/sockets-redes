import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.util.*;

public class Teste {

    public static void main(String[] args) throws ParseException {

        // Arrays utilizados
        Jogo[] jogos = new Jogo[6]; // Servidor
        Aposta[] apostas = new Aposta[6]; // Servidor

        // Leitura do teclado
        Scanner teclado = new Scanner(System.in); // Cliente

        // Váriaveis
        int escolha = 0;
        int idJogo = 0;
        int idAposta = 1;
        Jogo jogoAposta = null;
        int golsMandante = 0;
        int golsVisitante = 0;
        String usuario = null; // Servidor
        String senha = null; // Servidor
        int idUser = 1; // Servidor

        Aposta aposta = null;

        // Criação dos Jogos
        jogos[0] = new Jogo(1, "Internacional", "Bahia", "21/08/2022", 2, 3);
        jogos[1] = new Jogo(2, "Grêmio", "Vasco", "25/08/2022", 1, 2);
        jogos[2] = new Jogo(3, "São Paulo", "Corinthians", "30/10/2022", 4, 1);
        jogos[3] = new Jogo(4, "Flamengo", "Fluminense", "10/10/2022", 3, 1);
        jogos[4] = new Jogo(5, "Brasil de Pelotas", "Palmeiras", "12/10/2022", 1, 0);
        jogos[5] = new Jogo(6, "Juventude", "Caxias", "01/10/2022", 1, 1);

        System.out.println("Processo de Login: ");
        System.out.println("Digite seu usuário: ");
        usuario = teclado.next();
        System.out.println("Digite sua senha: ");
        senha = teclado.next();

        Usuario user = new Usuario(idUser++, usuario, senha); // Até aqui ok no server

        // Menu
        // OK - Opção 1 - Ver todos resultados;
            // Fazer validação sobre os jogos que ele já apostou;
            // Mostrar somente após a data;
        // OK - Opção 2 - Ver todas as partidas;
        // OK - Opção 3 - Fazer apostas;
        // Ok - Opção 4 - Sair

        // OK - Fazer contador para ser o id da aposta
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

            if (escolha == 1) {

                // Validação de jogos que  passaram **** FEITO
                int cont1 = 0;
                for (int i = 0; i < jogos.length; i++) {
                    final Date dataAtual = new Date();
                    final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    final Date dataJogo = formato.parse(jogos[i].getData());
                    if (!dataAtual.before(dataJogo)) {
                        System.out.print(jogos[i].getResultado());
                        cont1++;
                    }
                    if (cont1 == 0) {
                        System.out.println("  ");
                        System.out.println("Não há partidas para exibir");
                    }
                    
                }

            } else if (escolha == 2) {
                // OK
                int cont = 0;
                for (int i = 0; i < jogos.length; i++) {

                    final Date dataAtual = new Date();
                    final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    final Date dataJogo = formato.parse(jogos[i].getData());
                    if (dataAtual.before(dataJogo)) {
                        System.out.print(jogos[i].getPartida());
                        cont++;
                    }
                }

                if (cont == 0) {
                    System.out.println("  ");
                    System.out.println("Infelizmente não há partidas para exibir");
                }
            } else if (escolha == 3) {
                int valido = 0;

                while (valido == 0) {
                    System.out.println("  ");
                    System.out.println("Digite o ID do jogo que deseja apostar:");
                    idJogo = teclado.nextInt();
                    final Date dataAtual = new Date();
                    final SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    try { // trata o erro caso seja inserida uma ID de jogo invalida
                        final Date dataJogo = formato.parse(jogos[idJogo - 1].getData());
                        // Formatar a Data para exibição***FEITO
                        System.out.println(jogos[idJogo - 1].getData());
                        if (dataAtual.before(dataJogo)) { // verifica se a data do jogo escolhido é valida
                            if (idJogo > 0 && idJogo <= jogos.length + 1) {
                                for (int i = 0; i < jogos.length; i++) {
                                    int id = jogos[i].getId();
                                    // Debug
                                    System.out.println("ID Jogo " + id + " Id Selecionado" + idJogo);
                                    if (idJogo == id) {
                                        jogoAposta = jogos[i];
                                        // Debug
                                        System.out.println("ID Jogo" + id + " Id Selecionado" + idJogo);
                                        valido = 1;
                                    }
                                }
                            }

                            System.out.println("Partida a ser feita a aposta:");
                            jogoAposta.getPartida();

                        } else {
                            System.out.println("  ");
                            System.out.println("A DATA do jogo escolhido é invalida");
                            valido = 0;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("  ");
                        System.out.println("Partida não encotrada, insira outro jogo");
                    }
                }
                // teria que retornar para ecolher outra ID
                System.out.println("  ");
                System.out.println("Agora você pode nos passar o placar");
                System.out.println("Gols para o time da casa '" + jogoAposta.getMandante() + "' :");
                golsMandante = teclado.nextInt();
                System.out.println("Gols para o time visitante '" + jogoAposta.getVisitante() + "' :");
                golsVisitante = teclado.nextInt();

                //CONVERTER DATAAPOSTA EM STRING ***** FEITO
                Date dataAtual = new Date();
                DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                String dataAposta = dateFormat.format(dataAtual);
                aposta = new Aposta(idAposta++, jogoAposta, golsMandante, golsVisitante, user, dataAposta);
                aposta.getResumoAposta();
                // Adiciona a aposta no array de apostas
                for (int i = 0; i < apostas.length; i++) {
                    if (apostas[i] == null) {
                        System.out.println("Inserindo nas apostas: " + aposta);
                        apostas[i] = aposta;
                        break;
                    }
                }
            } else if (escolha == 4) {

               try {
                for (int i = 0; i < apostas.length; i++) {
                    if (apostas[i].getUsuario() == user) {
                        System.out.println("Apostas do usuário " + user.getUsuario());
                        apostas[i].getResumoAposta();
                        
                    }
                }
            }catch(NullPointerException e ){
                System.out.println(" ");
                System.out.println("Estas são todas as suas apostas");
            }
            }

        }
    }
}