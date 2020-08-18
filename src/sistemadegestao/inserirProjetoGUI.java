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
 
public class inserirProjetoGUI extends JFrame{
    private JLabel label1; //JLabel apenas com texto
    private JLabel label2; //JLabel apenas com texto
    private JTextField texto1;
    private JTextField texto2;
    private JTextField texto3;
    private JTextField texto4;
    private JButton inseriProjeto1;
    private JButton inseriProjeto2;
    private int numTurma;
    
    public inserirProjetoGUI(int numTurma){
        super("Sistema de Gestao");//barra de titulo
        setLayout( new FlowLayout());//configura o layout de frame
        
        label1 = new JLabel("Projeto");
        add(label1);
        
        texto1 = new JTextField("Nome", 12);
        add(texto1);
        
        label1 = new JLabel("Peso do projeto");
        add(label1);
        
        texto2 = new JTextField("Peso", 12);
        add(texto2);
          
        inseriProjeto1 = new JButton("Adicionar Projeto");
        add(inseriProjeto1);
        
        inseriProjeto2 = new JButton("Continuar");
        add(inseriProjeto2);
        
        this.numTurma = numTurma;
        
        ButtonHandler handler = new ButtonHandler();
        inseriProjeto1.addActionListener(handler);
        inseriProjeto2.addActionListener(handler);
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == inseriProjeto1){
                String projeto;
                String peso;

                 try {
                    projeto = texto1.getText();
                } catch (NullPointerException e) {
                    projeto = "0";
                }
                 
                try {
                    peso = texto2.getText();
                } catch (NullPointerException e) {
                    peso = "0";
                }
                
                gestaoAcademica gestao = gestaoAcademica.getInstance();
                
                gestao.adicionaCriterio(projeto, Float.parseFloat(peso), numTurma);
               
                inserirProjetoGUI frame3 = new inserirProjetoGUI(numTurma);            
                frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame3.setSize(190, 205);
                frame3.setVisible(true);
            }
            if(event.getSource() == inseriProjeto2){               
                JOptionPane.showMessageDialog(null,"Criterios adicionado com sucesso!");
                gestaoAcademica gestao = gestaoAcademica.getInstance();
                turma t = gestao.validaTurma(numTurma);
                t.setHasCrit(1);
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(570, 500);
                frame1.setVisible(true);
            }
            inserirProjetoGUI.this.dispose();
        }
    }
}