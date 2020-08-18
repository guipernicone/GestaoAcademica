package sistemadegestao;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.AbstractTableModel;

public class InformaTurmaGUI2 extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JTextField texto1;
    private JButton buttonInsCri1;//Voltar
    private JButton buttonInsCri2;
    
     public InformaTurmaGUI2(){
        super("Sistema de Gestao de Nota");//barra de titulo
        setLayout( new FlowLayout());
        
        label1 = new JLabel("Informa Turma");
        add(label1);
        
        label2 = new JLabel("Inserir numero da turma");
        add(label2);
        
        texto1 = new JTextField("Numero", 12);
        add(texto1);
        
        buttonInsCri1 = new JButton("Voltar");
        add(buttonInsCri1);
        
        buttonInsCri2 = new JButton("Continuar");
        add(buttonInsCri2);
        
        ButtonHandler handler = new ButtonHandler();
        buttonInsCri1.addActionListener(handler);
        buttonInsCri2.addActionListener(handler);
          
     }
     private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
           if(event.getSource() ==  buttonInsCri1){
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(570, 500);
                frame1.setVisible(true);    
           }   
            if(event.getSource() ==  buttonInsCri2){
                String numTurma;
                
                numTurma = texto1.getText();
                
                gestaoAcademica gestao = gestaoAcademica.getInstance();
                
                if(gestao.validaTurma( Integer.parseInt(numTurma)) != null){
                    EscolheSaveGUI frame2;
                    frame2 = new EscolheSaveGUI( Integer.parseInt(numTurma));
                    frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame2.setSize(400,300);
                    frame2.setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Turma nao cadastrada");
                    menuGUI frame1 = new menuGUI();
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setSize(570, 500);
                    frame1.setVisible(true); 
                }
                
            }
            InformaTurmaGUI2.this.dispose();
        }
    }
}