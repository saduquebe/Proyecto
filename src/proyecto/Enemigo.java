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
 * @author User
 */
public class Enemigo extends Ente{
    private Image foto;
    private Rectangle bordes;
    private int Xsprite=0;
    private int contador=0;
    public Enemigo(int x, int y) {
        super(x, y);
        this.foto= Toolkit.getDefaultToolkit().getImage("32x32-bat-sprite.png");
        this.bordes= new Rectangle(0,0,0,0);
    }
    public void moverenemigo(){
       if(contador==3){
        if(this.Xsprite<3){
        this.Xsprite=this.Xsprite+1;
        }
        else{
            this.Xsprite=0;
            
        }
        contador=0;
        }
        else{contador++;}
    
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

    public Rectangle getBordes() {
        return bordes;
    }

    public void setBordes(Rectangle bordes) {
        this.bordes = bordes;
    }

    

    
}
