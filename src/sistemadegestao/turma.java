
package sistemadegestao;

import java.util.ArrayList;
import java.util.Collection;

public class turma {
    private int Nturma;
    private Collection<aluno> Aluno;
    private Collection<Avaliacao> Avali;
    private int hasCrit;
    private int totalAluno;
    private int totalAvali;
    private Object[][] data;

    public turma(int Nturma,Collection<aluno> Aluno, Collection<Avaliacao> Avali,int hasCrit) {
        this.Avali = new ArrayList();
        this.Nturma = Nturma;
        this.hasCrit = hasCrit;
        this.Aluno = Aluno;
        this.totalAluno = this.Aluno.size();
        if(Avali == null){
           this.totalAvali =  0;
        }
        else
        this.totalAvali = this.Avali.size();
        data = new Object[100][100];
    }

     public int getTotalAluno() {
        return totalAluno;
    }

    public void setTotalAluno(int totalAluno) {
        this.totalAluno = totalAluno;
    }

    public void setTotalAvali(int totalAvali) {
        this.totalAvali = totalAvali;
    }

    public int getTotalAvali() {
        return totalAvali;
    }
    
    public int getHasCrit() {
        return hasCrit;
    }

    public void setHasCrit(int hasCrit) {
        this.hasCrit = hasCrit;
    }

    public Collection<aluno> getAluno() {
        return Aluno;
    }

    public int getNturma() {
        return Nturma;
    }

    public void setNturma(int Nturma) {
        this.Nturma = Nturma;
    }

    public Collection<Avaliacao> getAvali() {
        return Avali;
    }

    public void setAvali(String nome, float peso) {
        Avali.add(new Avaliacao(nome,peso));
    }   
    
       public Object[][] getData() {
        return data;
    }

    public void setData(Object[][] data) {
        this.data = data;
    }
}
