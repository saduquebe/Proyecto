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
public class Moneda extends Ente {
    private Image foto;
    private int Xsprite=0;
    public Moneda(int x, int y) {
        super(x, y);
        this.foto=Toolkit.getDefaultToolkit().getImage("Full Coins.png");
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
    
}
