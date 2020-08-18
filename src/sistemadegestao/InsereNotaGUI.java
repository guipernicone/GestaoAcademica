package sistemadegestao;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Collection;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InsereNotaGUI extends JFrame {
    private JLabel label1;
    private JLabel[] label;
    private JTextField[] texto;
    private JButton voltar;
    private JButton adicionar;
    private int numT;
    private int numA;
    public InsereNotaGUI(int numTurma, int numAluno){
       super("Sistema de Gestao");
       setLayout( new FlowLayout());
       
       gestaoAcademica gestao = gestaoAcademica.getInstance(); 
       turma Turma = gestao.validaTurma(numTurma);
      
       numT = numTurma;
       numA = numAluno;
       label = new JLabel[Turma.getTotalAvali()];
       texto = new JTextField[Turma.getTotalAvali()];
       Collection<Avaliacao> Avali = Turma.getAvali();
       int i = 0;
       label1 = new JLabel("             Insere Notas               ");
       add(label1);
       for(Avaliacao ava: Avali){
           System.out.printf("%s\n",ava.getNomeAvali());
           label[i] = new JLabel(ava.getNomeAvali());
           texto[i] = new JTextField(ava.getNomeAvali(),12);
           add(label[i]);
           add(texto[i]);
           i++;
       }
       System.out.printf("%d", numA);
       
       adicionar = new JButton("Adicionar");
       add(adicionar);
       
       voltar = new JButton("Voltar");
       add(voltar);
       InsereNotaGUI.ButtonHandler handler = new InsereNotaGUI.ButtonHandler();
       adicionar.addActionListener(handler);
       voltar.addActionListener(handler); 
    }
    
    private class ButtonHandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == adicionar){
                String nome;
                gestaoAcademica gestao = gestaoAcademica.getInstance(); 
                turma Turma = gestao.validaTurma(numT);
                Collection<Avaliacao> Avali = Turma.getAvali();
                int i = 0;
                float media = 0;
                Object[][] dat = Turma.getData();
                
                //dat = new Object[Turma.getTotalAluno()][Turma.getTotalAvali() + 2];
                for(Avaliacao ava: Avali){
                    nome = texto[i].getText();
                    dat[numA][i + 1] = Float.parseFloat(nome);
                    media = media + Float.parseFloat(nome)* (ava.getPeso());
                    i++;
                }
                dat[numA][i + 1] = media;
                Turma.setData(dat);
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(570, 500);
                frame1.setVisible(true);        
            }
            if(event.getSource() == voltar){
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(570, 500);
                frame1.setVisible(true);                 
            }
            InsereNotaGUI.this.dispose();
        }
    }
}