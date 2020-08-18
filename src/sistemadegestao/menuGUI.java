package sistemadegestao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Collection;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class menuGUI extends JFrame{
    private JMenuBar menu;
    private JMenu arquivo;
    private JMenuItem importar;
    private JMenuItem exportar;
    private JMenu criterio;
    private JMenuItem inserirCrit;
    private JMenu addTabela;
    private JMenuItem addAluno;
    private JMenuItem addTurma;
    private JMenuItem sair;
    
    private JPanel panel;
    private JLabel label1;
    private JTable table;
    private JScrollPane scrollPane;
    private JTabbedPane tabbedPane, tabbedPaneatt;
    private DefaultTableModel model, modelatt;
    
    private JButton salvar;
     
    private JPanel pane;
    
    private Object[][] data;
    
    private String[] colunas;
    Collection<turma> Turma;
    
    public int i = 0;
    public menuGUI() {
        super("Sistema de Gestao de Nota");//barra de titulo
        this.data = data;
        this.colunas = colunas;
        this.model = new DefaultTableModel(data, colunas);
        
        setLayout( new FlowLayout());//configura o layout de frame
        
        menu = new JMenuBar();
        setJMenuBar(menu);
        
        arquivo = new JMenu("Arquivo");
        menu.add(arquivo);
        
        importar = new JMenuItem("Importar");
        arquivo.add(importar);
        
        exportar = new JMenuItem("Exportar");
        arquivo.add(exportar);
        
        criterio = new JMenu("Criterio");
        menu.add(criterio);
        
        inserirCrit = new JMenuItem("Inserir Criterio");
        criterio.add(inserirCrit);
        
        sair = new JMenuItem("Sair");
        menu.add(sair);
        
        label1 = new JLabel("Inserir Notas");
        add(label1);
        //panel = new JPanel();
        
        gestaoAcademica gestao = gestaoAcademica.getInstance();        
        if(gestao.getTurma().isEmpty() == false)
        { 
            Turma = gestao.getTurma();
            tabbedPane = new JTabbedPane();
            for(turma t: Turma)
            {
                table = new JTable();
                DefaultTableModel model = new DefaultTableModel(0,0);
                table.setModel(model);
                
                
                colunas = new String[t.getTotalAvali() + 2];
                colunas[0] = " ";
                int i = 1;
                for(Avaliacao ava: t.getAvali())
                {
                    colunas[i] = ava.getNomeAvali();
                    i++;
                }
                colunas[i] = "Media";
                model.setColumnIdentifiers(colunas);
                
                Object[][] dat = t.getData();
                /*for(aluno a: t.getAluno()){
                    model.addRow(new Object[] {a.getNome()});
                }*/
                
                for(int j = 0; j <t.getTotalAluno();j++){
                    model.addRow(dat[j]);
                }
                
                table.setPreferredScrollableViewportSize(new Dimension(500,300));
                table.setFillsViewportHeight(true);
                add(table);
                
                scrollPane = new JScrollPane(table);
                scrollPane.getVerticalScrollBar();
                add(scrollPane);
                
                panel = new JPanel();
                panel.add(scrollPane);
                
                tabbedPane.add(Integer.toString(t.getNturma()),panel);                            
            }
            add(tabbedPane);
            

        }
        else{
                panel = new JPanel();
                table = new JTable();

                panel.setLayout( new BorderLayout());//configura o layout de panel


                table.setPreferredScrollableViewportSize(new Dimension(500,300));
                table.setFillsViewportHeight(true);


                scrollPane = new JScrollPane(table);

                scrollPane.getVerticalScrollBar();
                panel.add(scrollPane,BorderLayout.CENTER);

                add(scrollPane);
        }
        
        salvar = new JButton("Salvar");
        add(salvar);
        
        ButtonHandler handler = new ButtonHandler();
        importar.addActionListener(handler);
        exportar.addActionListener(handler);
        inserirCrit.addActionListener(handler);
        sair.addActionListener(handler);
        salvar.addActionListener(handler);
        table.addMouseListener(handler);
        table.addMouseMotionListener(handler);
    }
      
    private class ButtonHandler implements ActionListener, MouseListener, MouseMotionListener{
        
        public void actionPerformed(ActionEvent event){
            if(event.getSource() == importar){
                InformaTurmaGUI frame1 = new InformaTurmaGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 150);
                frame1.setVisible(true);
                
            }
             if(event.getSource() == exportar){
                InformaTurmaGUI2 frame1 = new InformaTurmaGUI2();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 150);
                frame1.setVisible(true);
               
            }
               
            if(event.getSource() == inserirCrit){
                insereCriteriosGUI frame1 = new insereCriteriosGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(200, 160);
                frame1.setVisible(true);
            }            
            if(event.getSource() == sair){
                System.exit(0);
            }
            if(event.getSource() == salvar){              
                menuGUI frame1 = new menuGUI();
                frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame1.setSize(570, 500);
                frame1.setVisible(true); 
            }
            menuGUI.this.dispose();
        }

        @Override
        public void mouseClicked(MouseEvent e) {
           if(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()) != null)
           {
                InsereNotaGUI frame4 = new InsereNotaGUI(Integer.parseInt(tabbedPane.getTitleAt(tabbedPane.getSelectedIndex())),table.getSelectedRow());
                frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame4.setSize(180, 400);
                frame4.setVisible(true); 
                menuGUI.this.dispose();
           }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        
        }

        @Override
        public void mouseReleased(MouseEvent e) {
           
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        
        }

        @Override
        public void mouseExited(MouseEvent e) {
          
        }

        @Override
        public void mouseDragged(MouseEvent e) {
    
        }

        @Override
        public void mouseMoved(MouseEvent e) {     
        }
    }
    
}
