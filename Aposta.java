public class Aposta{

    private int id;
    private Jogo jogo;
    private int apostaGM;
    private int apostaGV;
    private Usuario usuario;
    private String data;

    public Aposta(int identificador, Jogo jogo, int golsMandante, int golsVisitante, Usuario usuario, String dataAposta){
        id = identificador;
        this.jogo = jogo;
        apostaGM = golsMandante;
        apostaGV = golsVisitante;
        this.usuario = usuario;
        data = dataAposta;
    }

    public int getId(){
        return id;
    }

    public void setJogo(Jogo game){
        this.jogo = game;
    }

    public void getJogo(){
        System.out.println("Jogo: " + jogo.getId() + " | " + jogo.getMandante() + " x " + jogo.getVisitante());
    }

    // Ajustar a função para setar a DATA (Pode ser usando o tipo Data ou SPLIT)
     public void setData(String data){
        this.data = data;
    }
    
    // Ajustar a função para setar a DATA (Pode ser usando o tipo Data ou SPLIT)
    public String getData(){
        return data;
    }

    public void setGolsMandante(int gols){
        this.apostaGM = gols;
    }
    
    public int getGolsMandante(){
        return apostaGM;
    }

    public void setGolsVisitante(int gols){
        this.apostaGV = gols;
    }
    
    public int getGolsVisitante(){
        return apostaGV;
    }

    public void setUsuario(Usuario user){
        usuario = user;
    }

    public Usuario getUsuario(){
        return usuario;
    }

    public void getResumoAposta(){
        System.out.println("Id: " + id);
        System.out.println("Aposta: " + jogo.getMandante() + " " + getGolsMandante() + " x " + getGolsVisitante() + " " + jogo.getVisitante() + " - " + jogo.getData() );

    }

}