/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class Proyecto extends JFrame {

public Proyecto(){
    Iniciar();
}
    public static void main(String[] args) {
        Proyecto proyecto= new Proyecto();
        proyecto.setVisible(true);
    }

    private void Iniciar() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(new Dimension(1920,1080));
        this.add(new Vista());
    }
    
}
