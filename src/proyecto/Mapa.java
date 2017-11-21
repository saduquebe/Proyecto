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
    private int x;
    private int y;
    private Image foto;
    private Rectangle[] bordes;

    public Mapa() {
        this.x=0;
        this.y=0;
        this.foto = Toolkit.getDefaultToolkit().getImage("fondonuevo.png");
        this.bordes = new Rectangle[7];
        bordes();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        bordes();
        g.drawImage(this.foto,this.x,this.y, this);
    }
    public void bordes(){
        Rectangle box = new Rectangle(258+this.x,661,180,60);
        Rectangle box2= new Rectangle(318+this.x,601,120,60);
        Rectangle box3= new Rectangle(378+this.x,541,60,60);
        Rectangle box4= new Rectangle(542+this.x,540,240,60);
        Rectangle box5= new Rectangle(782+this.x,480,240,60);
        Rectangle box6= new Rectangle(1022+this.x,480,240,240);
        Rectangle box7= new Rectangle(0+this.x,720,3840,60);
        this.bordes[0]=box;
        this.bordes[1]=box2;
        this.bordes[2]=box3;
        this.bordes[3]=box4;
        this.bordes[4]=box5;
        this.bordes[5]=box6;
        this.bordes[6]=box7;
        
    }

    public Rectangle[] getBordes() {
        return bordes;
    }

    public void setBordes(Rectangle[] bordes) {
        this.bordes = bordes;
    }



    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
