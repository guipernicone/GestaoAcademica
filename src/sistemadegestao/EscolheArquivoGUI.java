package sistemadegestao;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EscolheArquivoGUI extends JFrame{
    private JFileChooser fileChooser;
    
    public EscolheArquivoGUI(int numTurma){
       fileChooser = new JFileChooser();
       fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);

       int result = fileChooser.showOpenDialog(this);
       
       if (result == JFileChooser.CANCEL_OPTION)
       {
           menuGUI frame1 = new menuGUI();
           frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame1.setSize(570, 500);
           frame1.setVisible(true);
       }
       else{
        File fileName = fileChooser.getSelectedFile();

        if((fileName == null) || (fileName.getName().equals("")))
        {
           JOptionPane.showMessageDialog(this, "Invalid Name", "Invalid Name", JOptionPane.ERROR_MESSAGE);
           menuGUI frame1 = new menuGUI();
           frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame1.setSize(570, 500);
           frame1.setVisible(true);
        }

        gestaoAcademica gestao = gestaoAcademica.getInstance();
        
        try{
          gestao.importaTurma(fileName,numTurma);    
          turma t = gestao.validaTurma(numTurma);
          Object [][] data;
          data = new Object[100][100];
          int i =0;
          for(aluno a : t.getAluno())
          {
              data[i][0] = a.getNome();
              i++;
          }
          t.setData(data);
        }
        catch(IOException ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        menuGUI frame1 = new menuGUI();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(570, 500);
        frame1.setVisible(true);
       }
       EscolheArquivoGUI.this.dispose();     
    }
}
