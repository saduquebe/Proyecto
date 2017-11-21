/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author User
 */
public class Mapa extends JPanel{
    private Image foto;
    private ArrayList<Rectangle> bordes;

    public Mapa() {
        this.foto = Toolkit.getDefaultToolkit().getImage("mapa.png");
        this.bordes = new ArrayList<>();
        bordes();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        bordes();
        g.drawImage(this.foto,0,0, this);
    }
    public void bordes(){
        Rectangle box = new Rectangle(258,661,180,60);
        Rectangle box2= new Rectangle(318,601,120,60);
        Rectangle box3= new Rectangle(378,541,60,60);
        Rectangle box4= new Rectangle(542,540,240,60);
        Rectangle box5= new Rectangle(782,480,240,60);
        Rectangle box6= new Rectangle(1022,480,240,240);
        Rectangle box7= new Rectangle(0,720,1920,1080);
        this.bordes.add(box);
        this.bordes.add(box2);
        this.bordes.add(box3);
        this.bordes.add(box4);
        this.bordes.add(box5);
        this.bordes.add(box6);
        this.bordes.add(box7);
    }

    public ArrayList<Rectangle> getBordes() {
        return bordes;
    }

    public void setBordes(ArrayList<Rectangle> bordes) {
        this.bordes = bordes;
    }
    
}
