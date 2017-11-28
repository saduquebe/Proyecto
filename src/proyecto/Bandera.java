/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Santiago
 */
public class Bandera extends Ente{
    private int contador=0;
    private Image foto;
    private int Xsprite=0;
    public Bandera(int x, int y) {
        super(x, y);
        this.foto=Toolkit.getDefaultToolkit().getImage("OA animated flag.png");
    }
    public void moverbandera(){
                if(contador==4){
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

    @Override
    public void setY(int y) {
        super.setY(y); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getY() {
        return super.getY(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setX(int x) {
        super.setX(x); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getX() {
        return super.getX(); //To change body of generated methods, choose Tools | Templates.
    }

    public int getXsprite() {
        return Xsprite;
    }

    public void setXsprite(int Xsprite) {
        this.Xsprite = Xsprite;
    }
    
}
