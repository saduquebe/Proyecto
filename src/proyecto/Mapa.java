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
    private Rectangle[] bordescajas;
    private Rectangle[] bordesmonedas;
    private Caja[] cajas;
    private Moneda[] monedas;
    public Mapa() {
        this.x=0;
        this.y=0;
        this.foto = Toolkit.getDefaultToolkit().getImage("layer-1.png");
        this.bordescajas = new Rectangle[16];
        this.bordesmonedas= new Rectangle[20];
        this.cajas= new Caja[15];
        this.monedas= new Moneda[20];
        cajas();
        monedas();
        bordes();
    }

    public void bordes(){
        for (int i = 0; i < this.monedas.length; i++) {
            this.bordesmonedas[i]=new Rectangle(this.monedas[i].getX()+this.x,this.monedas[i].getY(),32,32);
        }
        for (int i = 0; i < 15; i++) {
            this.bordescajas[i]=new Rectangle(this.cajas[i].getX()+this.x,this.cajas[i].getY(),60,60);
        }
        this.bordescajas[15]=new Rectangle(0,725,1920,1);
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
    public void monedas(){
        this.monedas[0]= new Moneda(625,550);
        this.monedas[1]= new Moneda(550,600);
        this.monedas[2]= new Moneda(400,500);
        this.monedas[3]= new Moneda(340,560);
        this.monedas[4]= new Moneda(280,620);
        this.monedas[5]= new Moneda(400,680);
        this.monedas[6]= new Moneda(432,680);
        this.monedas[7]= new Moneda(464,680);
        this.monedas[8]= new Moneda(496,680);
        this.monedas[9]= new Moneda(0,0);
        this.monedas[10]= new Moneda(0,0);
        this.monedas[11]= new Moneda(0,0);
        this.monedas[12]= new Moneda(0,0);
        this.monedas[13]= new Moneda(0,0);
        this.monedas[14]= new Moneda(0,0);
        this.monedas[15]= new Moneda(0,0);
        this.monedas[16]= new Moneda(0,0);
        this.monedas[17]= new Moneda(0,0);
        this.monedas[18]= new Moneda(0,0);
        this.monedas[19]= new Moneda(0,0);
    
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

    public Rectangle[] getBordescajas() {
        return bordescajas;
    }

    public void setBordescajas(Rectangle[] bordescajas) {
        this.bordescajas = bordescajas;
    }

    public Rectangle[] getBordesmonedas() {
        return bordesmonedas;
    }

    public void setBordesmonedas(Rectangle[] bordesmonedas) {
        this.bordesmonedas = bordesmonedas;
    }

    public Moneda[] getMonedas() {
        return monedas;
    }

    public void setMonedas(Moneda[] monedas) {
        this.monedas = monedas;
    }
    
}
