package sistemadegestao;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class inserirTrabalhoGUI extends JFrame{
    private JLabel label1; //JLabel apenas com texto
    private JLabel label2; //JLabel apenas com texto
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
    private JTextField texto4;
    private JButton inseriTrab1;
    private JButton inseriTrab2;
    private int numTurma;
    
    public inserirTrabalhoGUI(int numTurma){
        super("Sistema de Gestao");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Trabalho");
        add(label1);
        
        texto1 = new JTextField("Nome", 12);
        add(texto1);
        
        label1 = new JLabel("Peso do trabalho");
        add(label1);
        
        texto2 = new JTextField("Peso", 12);
        add(texto2);
        
        inseriTrab1 = new JButton("Adicionar Trabalho");
        add(inseriTrab1);
        
        inseriTrab2 = new JButton("Continuar");
        add(inseriTrab2);
        
        this.numTurma = numTurma;
        
        ButtonHandler handler = new ButtonHandler();
        inseriTrab1.addActionListener(handler);
        inseriTrab2.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == inseriTrab1){
                String trabalho;
                String peso;
                 try {
                    trabalho = texto1.getText();
                } catch (NullPointerException e) {
                    trabalho = "0";
                }
                 
                try {
                    peso = texto2.getText();
                } catch (NullPointerException e) {
                    peso = "0";
                }
                gestaoAcademica gestao = gestaoAcademica.getInstance();
                
                gestao.adicionaCriterio(trabalho, Float.parseFloat(peso), numTurma);
                
                inserirTrabalhoGUI frame3 = new inserirTrabalhoGUI(numTurma);            
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(200, 205);
                frame3.setVisible(true);
            }
            if(event.getSource() == inseriTrab2){
                inserirProvaGUI frame3 = new inserirProvaGUI(numTurma);            
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(180, 205);
                frame3.setVisible(true);
            }
            inserirTrabalhoGUI.this.dispose();
        }
    }
}