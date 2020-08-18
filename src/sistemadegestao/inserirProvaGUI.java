package sistemadegestao;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
 
public class inserirProvaGUI extends JFrame{
    private JLabel label1; //JLabel apenas com texto
    private JLabel label2; //JLabel apenas com texto
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
    private JTextField texto4;
    private JButton inseriProva1;
    private JButton inseriProva2;
    private int numTurma;
    
    public inserirProvaGUI(int numTurma){
        super("Sistema de Gestao");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Prova");
        add(label1);
        
        texto1 = new JTextField("Nome", 12);
        add(texto1);
        
        label1 = new JLabel("Peso da prova");
        add(label1);
        
        texto2 = new JTextField("Peso", 12);
        add(texto2);
          
        inseriProva1 = new JButton("Adicionar Prova");
        add(inseriProva1);
        
        inseriProva2 = new JButton("Continuar");
        add(inseriProva2);
        
        this.numTurma = numTurma;
        
        ButtonHandler handler = new ButtonHandler();
        inseriProva1.addActionListener(handler);
        inseriProva2.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == inseriProva1){
                String prova;
                String peso;

                 try {
                    prova = texto1.getText();
                } catch (NullPointerException e) {
                    prova = "0";
                }
                 
                try {
                    peso = texto2.getText();
                } catch (NullPointerException e) {
                    peso = "0";
                }
                
                gestaoAcademica gestao = gestaoAcademica.getInstance();
                
                gestao.adicionaCriterio(prova, Float.parseFloat(peso), numTurma);
                 
                
                inserirProvaGUI frame3 = new inserirProvaGUI(numTurma);            
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(180, 205);
                frame3.setVisible(true);
            }
            if(event.getSource() == inseriProva2){
                inserirProjetoGUI frame3 = new inserirProjetoGUI(numTurma);            
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(190, 205);
                frame3.setVisible(true);
            }
            inserirProvaGUI.this.dispose();
        }
    }
}