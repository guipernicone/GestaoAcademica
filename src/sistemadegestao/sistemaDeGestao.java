package sistemadegestao;

import java.util.Scanner;
import java.util.InputMismatchException;
import javax.swing.JFrame;

public class sistemaDeGestao{

    public static void main(String[] args){
	menuGUI frame1 = new menuGUI();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(570, 500);
        frame1.setVisible(true);        
    }
}