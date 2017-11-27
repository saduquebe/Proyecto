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
public class Mapa {
    private int x;
    private int y;
    private Image foto;
    private Rectangle[] bordes;
    private Caja[] cajas;
    public Mapa() {
        this.x=0;
        this.y=0;
        this.foto = Toolkit.getDefaultToolkit().getImage("layer-1.png");
        this.bordes = new Rectangle[16];
        this.cajas= new Caja[15];
        cajas();
        bordes();
    }

    public void bordes(){
        for (int i = 0; i < 15; i++) {
            this.bordes[i]=new Rectangle(this.cajas[i].getX()+this.x,this.cajas[i].getY(),60,60);
        }
        this.bordes[15]=new Rectangle(0,725,1920,1);
    }
    public void cajas(){
        this.cajas[0]=new Caja(258+this.x,661);
        this.cajas[1]=new Caja(318+this.x,601);
        this.cajas[2]=new Caja(378+this.x,541);
        this.cajas[3]=new Caja(542+this.x,660);
        this.cajas[4]=new Caja(902+this.x,660);
        this.cajas[5]=new Caja(1022+this.x,660);
        this.cajas[6]=new Caja(602+this.x,660);
        this.cajas[7]=new Caja(662+this.x,660);
        this.cajas[8]=new Caja(722+this.x,660);
        this.cajas[9]=new Caja(722+this.x,600);
        this.cajas[10]=new Caja(602+this.x,600);
        this.cajas[11]=new Caja(662+this.x,600);
        this.cajas[12]=new Caja(662+this.x,540);
        this.cajas[13]=new Caja(782+this.x,660);
        this.cajas[14]=new Caja(962+this.x,660);
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

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Caja[] getCajas() {
        return cajas;
    }

    public void setCajas(Caja[] cajas) {
        this.cajas = cajas;
    }
    
}
