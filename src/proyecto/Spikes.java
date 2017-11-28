package proyecto;


import java.awt.Image;
import java.awt.Toolkit;
import proyecto.Ente;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Santiago
 */
public class Spikes extends Ente{
    private Image foto;
    public Spikes(int x, int y) {
        super(x, y);
            this.foto=Toolkit.getDefaultToolkit().getImage("Red Crystal Cluster.png");
    }

    public Image getFoto() {
        return foto;
    }

    public void setFoto(Image foto) {
        this.foto = foto;
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
    
}
