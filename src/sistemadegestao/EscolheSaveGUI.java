package sistemadegestao;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class EscolheSaveGUI extends JFrame{
    private JFileChooser fileChooser;
    private int numT;
    public EscolheSaveGUI(int numTurma){
       fileChooser = new JFileChooser();
       fileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
       numT = numTurma;
       int result = fileChooser.showSaveDialog(this);
       
       if (result == JFileChooser.CANCEL_OPTION)
       {
           menuGUI frame1 = new menuGUI();
           frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
           frame1.setSize(570, 500);
           frame1.setVisible(true);
       }
       else{
        File fileName = fileChooser.getSelectedFile();
        
        gestaoAcademica gestao = gestaoAcademica.getInstance();
        try{
            gestao.exportaTurma(fileName, numTurma);
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage());
        }
        menuGUI frame1 = new menuGUI();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(570, 500);
        frame1.setVisible(true);
       }
       EscolheSaveGUI.this.dispose();     
    }
}
