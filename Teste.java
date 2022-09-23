import java.util.*;

public class Teste{

public static void main(String[] args) {

    // Arrays utilizados
    Jogo[] jogos = new Jogo[6];
    Aposta[] apostas = new Aposta[6];

    // Leitura do teclado
    Scanner teclado = new Scanner(System.in);

    //Váriaveis
    int escolha = 0;
    int idJogo = 0;
    int idAposta = 1;
    int idUser = 1;
    Jogo jogoAposta = null;
    int golsMandante = 0;
    int golsVisitante = 0;
    String usuario = null;
    String senha = null;

    Aposta aposta = null;

    //

    // Criação dos Jogos
    jogos[0] = new Jogo(1,"Internacional","Bahia","21/09/2022",2,3);
    jogos[1] = new Jogo(2,"Grêmio","Vasco","25/09/2022",1,2);
    jogos[2] = new Jogo(3,"São Paulo","Corinthians","30/09/2022",4,1);
    jogos[3] = new Jogo(4,"Flamengo","Fluminense","10/10/2022",3,1);
    jogos[4] = new Jogo(5,"Brasil de Pelotas","Palmeiras","12/10/2022",1,0);
    jogos[5] = new Jogo(6,"Juventude","Caxias","01/08/2022",1,1);

    System.out.println("Processo de Login: ");
    System.out.println("Digite seu usuário: ");
    usuario = teclado.next();
    System.out.println("Digite sua senha: ");
    senha = teclado.next();
   
    Usuario user = new Usuario(idUser++,usuario, senha);

    
    
    // Menu
    // OK - Opção 1 - Ver todos resultados;
        // Fazer validação sobre os jogos que ele já apostou;
        // Mostrar somente após a data;
    // OK - Opção 2 - Ver todas as partidas;
    // OK - Opção 3 - Fazer apostas;

    // OK - Fazer contador para ser o id da aposta
    // Estrutura Menu
    System.out.println("Selecione uma opção abaixo:");
    System.out.println("1 - Ver resultados");
    System.out.println("2 - Ver partidas");
    System.out.println("3 - Fazer aposta");
    System.out.println("4 - Ver minhas apostas");
    escolha = teclado.nextInt();
  
        if (escolha == 1) {
            //Inserir validação para ver somente partidas que já foram feitas apostas para aquele usuário
            for(int i=0; i<jogos.length;i++){
                jogos[i].getResultado();
            }
            
        } else if (escolha == 2){
            //Inserir validação para ver somente partidas disponiveis para aposta
            for(int i=0; i<jogos.length;i++){
                jogos[i].getPartida();
            }
        } else if (escolha == 3){
        
                System.out.println("Digite o ID do jogo que deseja apostar:");
                idJogo = teclado.nextInt();
                    if(idJogo > 0 && idJogo < jogos.length-1){
                        for(int i=0;i<jogos.length-1;i++){
                            int id = jogos[i].getId();
                                if (idJogo == id){
                                    jogoAposta = jogos[i];
                                }
                        }
                        System.out.println("Partida a ser feita a aposta:");
                        jogoAposta.getPartida();
                        
                    }else {
                        System.out.println("Partida não encotrada, insira outro jogo");
                    }
                    System.out.println("Agora você pode nos passar o placar");
                    System.out.println("Gols para o time da casa '" + jogoAposta.getMandante() + "' :");
                    golsMandante = teclado.nextInt();
                    System.out.println("Gols para o time visitante '" + jogoAposta.getVisitante() + "' :");
                    golsVisitante = teclado.nextInt();
            
    }else if (escolha == 4){
        for(int i=0;i<apostas.length;i++){
            int cont = 0;
            if (cont == 0){
                System.out.println("O usuário " + user.getUsuario() +" não tem nenhuma aposta confirmada");
            } else if(apostas[i].getUsuario() == user){
                System.out.println("Apostas do usuário " + user.getUsuario());
                apostas[i].getResumoAposta();
                cont++;
            }
        }
    }
    aposta = new Aposta(idAposta++, jogoAposta, golsMandante, golsVisitante, user, "01/08/2022");
    aposta.getResumoAposta();
    
    for(int i=0;i<apostas.length;i++){
        if (apostas[i] == null){
            apostas[i] = aposta;
            break;
        }
    }

}
}
