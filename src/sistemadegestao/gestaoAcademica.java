
package sistemadegestao;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class gestaoAcademica {
    private static gestaoAcademica instance;
    private static Collection<turma> Turma;
    
    private gestaoAcademica(){
        Turma = new ArrayList();
    }
    
    public static gestaoAcademica getInstance() {
        if (instance == null){
            instance = new gestaoAcademica();
        }
        return instance;
    }
  
    public Collection<turma> getTurma() {
        return Turma;
    }
    public void exportaTurma(File fileName,int numTurma) throws IOException{
        String diretorio;
        diretorio = fileName.getPath();
        //System.out.printf("%s",diretorio);
        
        controlaArquivo arquivo = new controlaArquivo();
        turma t = validaTurma(numTurma);
       try{
        arquivo.exportFile(diretorio, t.getAluno());
       }
       catch(IOException ex){
           throw ex;
       }
        
    }
    public void importaTurma(File fileName,int numTurma)throws IOException{
         String diretorio;
         diretorio = fileName.getPath();
         controlaArquivo arquivo = new controlaArquivo();
         for (turma t : Turma){
            if (t.getNturma() == numTurma){
                Turma.remove(t);
                break;
            }
         }
         try{
            Collection<aluno> Aluno = new ArrayList();
            arquivo.importFile(diretorio,Aluno);
            Turma.add( new turma(numTurma,Aluno,null,0));
         }
         catch(IOException ex){
             throw ex;
         }
    }
     
    public void adicionaCriterio(String nome, float peso, int nTurma){
        for (turma t : Turma){
            if (t.getNturma() == nTurma){
                t.setAvali(nome, peso);
                t.setTotalAvali(t.getTotalAvali() + 1);               
            }
         }
    }  
    
    public turma validaTurma(int numTurma) {
        for (turma t : Turma){
            if (t.getNturma() == numTurma){
                return t;
            }
        }
       return null;
    }
    public void atualizaData(int nTurma){
        Object[][] dat;
        turma T = validaTurma(nTurma);
        dat = new Object[T.getTotalAluno()][T.getTotalAvali() + 2];
        int i = 0;
        for(aluno a : T.getAluno())
        {
              dat[i][0] = a.getNome();
              i++;
        }
        T.setData(dat);     
    }  
}
