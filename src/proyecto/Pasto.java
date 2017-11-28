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
public class Pasto extends Ente{
    private Image foto;
    private Image fototierra;
    public Pasto(int x, int y) {
        super(x, y);
        this.foto= Toolkit.getDefaultToolkit().getImage("grass_128x128.png");
        this.fototierra=Toolkit.getDefaultToolkit().getImage("dirt_128x128.png");
    }

    @Override
    public void setY(int y) {
        super.setY(y); 
    }

    @Override
    public int getY() {
        return super.getY(); 
    }

    @Override
    public void setX(int x) {
        super.setX(x);
    }

    @Override
    public int getX() {
        return super.getX(); 
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
    }

    public Image getFototierra() {
        return fototierra;
    }

    public void setFototierra(Image fototierra) {
        this.fototierra = fototierra;
    }
    
    
    
}
