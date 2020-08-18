package sistemadegestao;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class insereCriteriosGUI extends JFrame{
    private JLabel label1;
    private JLabel label2;
    private JTextField texto1;
    private JButton buttonInsCri1;//Voltar
    private JButton buttonInsCri2;
    
     public insereCriteriosGUI(){
        super("Sistema de Gestao de Nota");//barra de titulo
        setLayout( new FlowLayout());
        
        label1 = new JLabel("Inserir Criterios");
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
                gestaoAcademica gestao = gestaoAcademica.getInstance();
                
                String numTurma;
                
                try {
                     numTurma = texto1.getText();
                } catch (NullPointerException e) {
                    numTurma = "0";
                }
                turma Turma = gestao.validaTurma(Integer.parseInt(numTurma));
                if(Turma != null){
                    if(Turma.getHasCrit() == 0){
                        inserirTrabalhoGUI frame1 = new inserirTrabalhoGUI(Integer.parseInt(numTurma));
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setSize(200, 205);
                        frame1.setVisible(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"Criterios ja declarados para essa turma");
                        menuGUI frame1 = new menuGUI();
                        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        frame1.setSize(570, 500);
                        frame1.setVisible(true);
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null,"Turma nao cadastrada");
                    menuGUI frame1 = new menuGUI();
                    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    frame1.setSize(570, 500);
                    frame1.setVisible(true);
                }
            }
            insereCriteriosGUI.this.dispose();
        }
    }
}