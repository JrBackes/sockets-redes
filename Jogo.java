public class Jogo{
    
    private int id;
    private String man;
    private String vis;
    private String dataJogo;
    private int golsMan;
    private int golsVis;


    public Jogo (int identificador,String mandante, String visitante, String dataDoJogo, int golsMandante, int golsVisitante){
        this.id = identificador;
        this.man = mandante;
        this.vis = visitante;
        this.dataJogo = dataDoJogo;
        this.golsMan = golsMandante;
        this.golsVis = golsVisitante;
    }

    public int getId(){
        return id;
    }

    public void setMandante(String mandante){
        this.man = mandante;
    }

    public String getMandante(){
        return man;
    }

    public void setVisitante(String visitante){
        this.vis = visitante;
    }
    
    public String getVisitante(){
        return vis;
    }

     public void setData(String data){
        this.dataJogo = data;
    }
    
    public String getData(){
        return dataJogo;
    }

    public void setGolsMandante(int gols){
        this.golsMan = gols;
    }
    
    public int getGolsMandante(){
        return golsMan;
    }

    public void setGolsVisitante(int gols){
        this.golsVis = gols;
    }
    
    public int getGolsVisitante(){
        return golsVis;
    }

    public void getPartida(){
        System.out.println("ID: " + getId() + " | "+ getMandante() +" x " + getVisitante() + " ---------- Data: " + getData());

    }

    public void getResultado(){
        System.out.println("ID: " + getId() + " | "+ getMandante() + " " + getGolsMandante() + " x " + getGolsVisitante() +" "+getVisitante() + " ---------- Data: " + getData());
    }
    

}


