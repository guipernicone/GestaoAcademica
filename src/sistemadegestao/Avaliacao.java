package sistemadegestao;
public class Avaliacao {
    private String nomeAvali;
    private float peso;

    
    public Avaliacao(String nomeAvali, float peso) {
        this.nomeAvali = nomeAvali;
        this.peso = peso;
    }
        
    public String getNomeAvali() {
        return nomeAvali;
    }

    public void setNomeAvali(String nomeAvali) {
        this.nomeAvali = nomeAvali;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }


    
   
}
