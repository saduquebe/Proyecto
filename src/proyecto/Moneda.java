/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Toolkit;

/**
 *
 * @author Santiago
 */
public class Moneda extends Ente {
    private Image foto;
    private int contador=0;
    private int Xsprite=0;
    private Rectangle bordes;
    public Moneda(int x, int y) {
        super(x, y);
        this.foto=Toolkit.getDefaultToolkit().getImage("Full Coins.png");
        this.bordes= new Rectangle(this.getX(),this.getY(),32,32);
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public int getXsprite() {
        return Xsprite;
    }

    public void setXsprite(int Xsprite) {
        this.Xsprite = Xsprite;
    }
            public void movermoneda(){
        if(contador==3){
        if(this.Xsprite<7){
        this.Xsprite=this.Xsprite+1;
        }
        else{
            this.Xsprite=0;
            
        }
        contador=0;
        }
        else{contador++;}
    }

    public Rectangle getBordes() {
        return bordes;
    }

    public void setBordes(Rectangle bordes) {
        this.bordes = bordes;
    }
            
}
