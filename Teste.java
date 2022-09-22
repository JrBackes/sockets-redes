
public class Teste{

public static void main(String[] args) {

    Jogo[] jogos = new Jogo[6];

    
    jogos[0] = new Jogo(1,"Internacional","Bahia","21/09/2022",2,3);
    jogos[1] = new Jogo(2,"Grêmio","Vasco","25/09/2022",1,2);
    jogos[2] = new Jogo(3,"São Paulo","Corinthians","30/09/2022",4,1);
    jogos[3] = new Jogo(4,"Flamengo","Fluminense","10/10/2022",3,1);
    jogos[4] = new Jogo(5,"Brasil de Pelotas","Palmeiras","12/10/2022",1,0);
    jogos[5] = new Jogo(6,"Juventude","Caxias","01/08/2022",1,1);

    Usuario user1 = new Usuario(1, "junior", "aabb");

    Aposta aposta = new Aposta(1, jogos[1], 2, 3, user1, "01/08/2022");
    
    for(int i=0; i<jogos.length;i++){
        jogos[i].getPartidaAposta();
    }

}

}