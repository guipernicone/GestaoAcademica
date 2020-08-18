
package sistemadegestao;

import java.util.ArrayList;
import java.util.Collection;

public class aluno{
    private String nome;
    private Collection<Float> notas;
    private int media;

    public aluno(String nome, Collection<Float> notas, int media) {
        this.nome = nome;
        this.notas = notas;
        this.media = media;
    }
 
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Collection<Float> getNotas() {
        return notas;
    }

    public void setNotas(Collection<Float> notas) {
        this.notas = notas;
    }

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }
    
  
}
