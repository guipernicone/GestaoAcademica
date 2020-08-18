
package sistemadegestao;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class controlaArquivo {
        private BufferedReader input = null;
        String line = "";
        String cvsSplit = ", ";
        gestaoAcademica gestao = gestaoAcademica.getInstance();
        Collection<Float> notas = null;
        Collection<String> nomea = null;
        Collection<Float> peso = null;
    public void exportFile(String diretorio,Collection<aluno> Aluno) throws IOException{
       FileWriter fileWriter = new FileWriter(diretorio);
       try {
 
            for(aluno a: Aluno)
            {
                fileWriter.append(a.getNome());
                fileWriter.append(", ");
                for(Float f: a.getNotas())
                {
                    fileWriter.append(String.valueOf(f));
                    fileWriter.append(", ");
                }
                fileWriter.append(String.valueOf(a.getMedia()));
                fileWriter.append(", ");
                fileWriter.append("\n");
            }
       }
       catch(IOException e){
         throw new IOException("Erro ao salvar Arquivo");  
       }
       fileWriter.flush();
       fileWriter.close();
    }
    public void importFile(String diretorio, Collection<aluno> Aluno)throws FileNotFoundException, IOException{
       input  = new BufferedReader( new FileReader(diretorio));
       try{
             while ((line = input.readLine()) != null) {
                String[] str = line.split(cvsSplit);             
                for(String st: str)
                    Aluno.add(new aluno(st,notas,0));     
            }
        }
        catch (NoSuchElementException elementException)
        {
            System.err.println("Arquivo com formato inapropriado");
            input.close();
            System.exit(1);
        }
        catch (IllegalStateException stateException){
            System.err.println("Erro de leitura do arquivo");
            System.exit(1);
        }
    }
}
//C:\Users\Guilherme\Documents\Faculdade\4.Quarto Semestre\Paradigmas da programcao B\AlunosExemploProjetoFinal.csv